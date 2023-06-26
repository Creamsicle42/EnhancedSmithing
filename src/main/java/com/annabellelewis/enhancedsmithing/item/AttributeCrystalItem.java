package com.annabellelewis.enhancedsmithing.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.RandomSequence;
import net.minecraft.world.RandomSequences;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.sql.Time;
import java.util.List;
import java.util.Random;

import static com.annabellelewis.enhancedsmithing.item.AttributeCrystalItem.AttributeCrystalHelper.possibleAttributes;

public class AttributeCrystalItem extends Item {



    public AttributeCrystalItem() {
        super(new Item.Properties().fireResistant().stacksTo(1));
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return isCrystalEmpowered(stack);
    }

    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
        if(isCrystalEmpowered(stack)) {return false;}
        if(entity.level().getBlockState(entity.blockPosition()).is(Blocks.SOUL_FIRE)){
            empowerCrystal(stack);
        }
        return super.onEntityItemUpdate(stack, entity);
    }

    static void empowerCrystal(ItemStack stack){
        stack.getTag().putBoolean("IsEmpowered", true);
        Random rand = new Random();
        stack.getTag().putString("AttributeName", possibleAttributes.get(Math.abs(rand.nextInt()) % possibleAttributes.size()));
        stack.getTag().putFloat("AttributePower",  (float)Math.pow(rand.nextFloat() % 1f, 2f)/2f);
    }

    public static boolean isCrystalEmpowered(ItemStack stack) {
        if(!stack.getOrCreateTag().contains("IsEmpowered")){
            stack.getTag().putBoolean("IsEmpowered", false);
        }
        return stack.getTag().getBoolean("IsEmpowered");
    }

    public static AttributeModifier getModifier(ItemStack stack) {
        return AttributeCrystalHelper.getModifier(
            stack.getTag().getString("AttributeName"),
            stack.getTag().getFloat("AttributePower")
        );
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, level, components, tooltipFlag);
        if(!isCrystalEmpowered(stack)){
            components.add(Component.literal("Throw into soul fire to charge."));
        } else {
            components.add(AttributeCrystalHelper.getCrystalComponent(stack.getTag().getString("AttributeName"), stack.getTag().getFloat("AttributePower")));
            components.add(Component.translatable("item.enhancedsmithing.attribute_crystal.size_prefix").append("%1.2f".formatted(stack.getTag().getFloat("AttributePower"))).withStyle(ChatFormatting.GRAY));
        }
    }

    public static class AttributeCrystalHelper{
        public static List<String> possibleAttributes = List.of(
                "generic.max_health",
                "generic.knockback_resistance",
                "generic.movement_speed",
                "generic.attack_damage",
                "generic.armor",
                "generic.armor_toughness",
                "generic.attack_knockback",
                "generic.attack_speed",
                "generic.luck"
        );

        public static int getOpperation(String attribute){
            switch (attribute){
                case "generic.max_health", "generic.knockback_resistance", "generic.armor", "generic.armor_toughness", "generic.luck":
                    return 0;
                case "generic.movement_speed", "generic.attack_damage", "generic.attack_knockback", "generic.attack_speed":
                    return 1;

            }
            return 0;
        }

        public static float getModifierValue(String name, float baseValue){
            switch (name){
                case "generic.max_health":
                    return (float)Math.ceil(baseValue * 4);
                case "generic.knockback_resistance", "generic.movement_speed", "generic.attack_damage", "generic.attack_knockback", "generic.attack_speed":
                    return (float)Math.ceil((baseValue * 0.5f) * 10f) / 10f;
                case "generic.armor", "generic.armor_toughness", "generic.luck":
                    return (float)Math.ceil(baseValue * 6);

            }
            return 0f;
        }

        public static AttributeModifier getModifier(String name, float value){
            return new AttributeModifier(
                    name,
                    (double)getModifierValue(name, value),
                    AttributeModifier.Operation.fromValue(getOpperation(name))
            );
        }

        public static Component getCrystalComponent(String name, float value) {
            String affix = "";
            int opperation = getOpperation(name);
            float modValue = getModifierValue(name, value);
            if(opperation == 1) {
                affix = "%";
                modValue *= 100f;
            }


            return  Component.literal(" +" + modValue + affix + " ").append(Component.translatable("attribute.name." + name)).withStyle(ChatFormatting.BLUE);
        }
    }
}
