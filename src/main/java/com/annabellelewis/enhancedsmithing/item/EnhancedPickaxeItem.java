package com.annabellelewis.enhancedsmithing.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.List;

public class EnhancedPickaxeItem extends PickaxeItem implements ILevelableItem {

    public EnhancedPickaxeItem(Tier tier, int p_42962_, float p_42963_, Item.Properties props) {
        super(tier, p_42962_, p_42963_,  props);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
        if(stack.getDamageValue() == stack.getMaxDamage() - 1) return false;
        return net.minecraftforge.common.ToolActions.DEFAULT_PICKAXE_ACTIONS.contains(toolAction);
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
