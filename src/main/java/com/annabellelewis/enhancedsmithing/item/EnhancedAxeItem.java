package com.annabellelewis.enhancedsmithing.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EnhancedAxeItem extends AxeItem implements ILevelableItem  {
    private final Multimap<Attribute, AttributeModifier> brokenModifiers;
    public EnhancedAxeItem(Tier p_40521_, float p_40522_, float p_40523_, Properties p_40524_) {
        super(p_40521_, p_40522_, p_40523_, p_40524_);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> brokenBuilder = ImmutableMultimap.builder();
        brokenBuilder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 0, AttributeModifier.Operation.ADDITION));
        brokenBuilder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", 1f, AttributeModifier.Operation.ADDITION));
        this.brokenModifiers = brokenBuilder.build();
    }

    @Override
    public boolean mineBlock(ItemStack itemStack, Level p_40999_, BlockState p_41000_, BlockPos p_41001_, LivingEntity p_41002_) {
        addExperience(itemStack, 1);
        return super.mineBlock(itemStack, p_40999_, p_41000_, p_41001_, p_41002_);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if(context.getItemInHand().getDamageValue() == context.getItemInHand().getMaxDamage() - 1) return InteractionResult.FAIL;
        addExperience(context.getItemInHand(), 1);
        return super.useOn(context);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        if(stack.getDamageValue() == stack.getMaxDamage() - 1) return false;
        return super.canPerformAction(stack, toolAction);
    }

    public float getDestroySpeed(ItemStack stack, BlockState blockState) {
        if(stack.getDamageValue() == stack.getMaxDamage() - 1) return 0.0f;
        return super.getDestroySpeed(stack, blockState);
    }

    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        if(stack.getDamageValue() == stack.getMaxDamage() - 1  && slot == EquipmentSlot.MAINHAND) return this.brokenModifiers;
        return super.getDefaultAttributeModifiers(slot);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> componentList, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, level, componentList, tooltipFlag);
        componentList.add(Component.literal("Current Level: " + getLevel(stack)));
        componentList.add(Component.literal("Current Exp: " + getExperience(stack)));
    }


}
