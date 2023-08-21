package com.annabellelewis.enhancedsmithing.item.armor;

import com.annabellelewis.enhancedsmithing.item.ILevelableItem;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class EnhancedArmorItem extends ArmorItem implements ILevelableItem {

    private final Multimap<Attribute, AttributeModifier> brokenModifiers;

    public EnhancedArmorItem(ArmorMaterial armorMaterial, Type type, Properties properties) {
        super(armorMaterial, type, properties);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ARMOR, new AttributeModifier("Armor modifier", 0.0, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier("Armor toughness", 0.0, AttributeModifier.Operation.ADDITION));
        this.brokenModifiers = builder.build();
    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
        if(stack.getDamageValue() == stack.getMaxDamage() - 1){
            return 0;
        }
        return super.damageItem(stack, amount, entity, onBroken);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        if(stack.getDamageValue() == stack.getMaxDamage() - 1){return this.brokenModifiers;}
        return super.getAttributeModifiers(slot, stack);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> componentList, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, level, componentList, tooltipFlag);
        componentList.add(Component.literal("Current Level: " + getLevel(stack)));
        componentList.add(Component.literal("Current Exp: " + getExperience(stack)));
    }

    @Override
    public void addAttribute(ItemStack stack, AttributeModifier modifier) {
        stack.getOrCreateTag();
        if (!stack.getTag().contains("AttributeModifiers", 9)) {
            stack.getTag().put("AttributeModifiers", new ListTag());
        }

        ListTag listtag = stack.getTag().getList("AttributeModifiers", 10);
        CompoundTag compoundtag = modifier.save();
        compoundtag.putString("AttributeName", modifier.getName());
        compoundtag.putString("Slot", getType().getSlot().getName());


        listtag.add(compoundtag);
    }

    public static void LivingHurtEvent(LivingHurtEvent event){
        if(event.getEntity().getType() != EntityType.PLAYER){return;}
        Iterable<ItemStack> armor  = event.getEntity().getArmorSlots();
        for (ItemStack stack: armor) {
            if(stack.getItem() instanceof ILevelableItem){
                ((ILevelableItem)stack.getItem()).addExperience(stack, 1);
            }
        }
    }
}
