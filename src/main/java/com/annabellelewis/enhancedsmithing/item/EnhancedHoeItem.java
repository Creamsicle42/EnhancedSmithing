package com.annabellelewis.enhancedsmithing.item;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EnhancedHoeItem extends HoeItem implements ILevelableItem  {
    public EnhancedHoeItem(Tier p_41336_, int p_41337_, float p_41338_, Properties p_41339_) {
        super(p_41336_, p_41337_, p_41338_, p_41339_);
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

    @Override
    public boolean mineBlock(ItemStack itemStack, Level p_40999_, BlockState p_41000_, BlockPos p_41001_, LivingEntity p_41002_) {
        addExperience(itemStack, 1);
        return super.mineBlock(itemStack, p_40999_, p_41000_, p_41001_, p_41002_);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> componentList, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, level, componentList, tooltipFlag);
        componentList.add(Component.literal("Current Level: " + getLevel(stack)));
        componentList.add(Component.literal("Current Exp: " + getExperience(stack)));
    }

}
