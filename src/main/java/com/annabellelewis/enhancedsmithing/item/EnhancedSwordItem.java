package com.annabellelewis.enhancedsmithing.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EnhancedSwordItem extends TieredItem implements Vanishable, ILevelableItem {
    private final float attackDamage;
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;
    private final Multimap<Attribute, AttributeModifier> brokenModifiers;

    public EnhancedSwordItem(Tier p_43269_, int p_43270_, float p_43271_, Item.Properties p_43272_) {
        super(p_43269_, p_43272_);
        this.attackDamage = (float)p_43270_ + p_43269_.getAttackDamageBonus();
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", (double)this.attackDamage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double)p_43271_, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();

        ImmutableMultimap.Builder<Attribute, AttributeModifier> brokenBuilder = ImmutableMultimap.builder();
        brokenBuilder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 0, AttributeModifier.Operation.ADDITION));
        brokenBuilder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double)p_43271_, AttributeModifier.Operation.ADDITION));
        this.brokenModifiers = brokenBuilder.build();
    }

    public float getDamage() {
        return this.attackDamage;
    }

    public boolean canAttackBlock(BlockState p_43291_, Level p_43292_, BlockPos p_43293_, Player player) {
        if(player.getItemInHand(InteractionHand.MAIN_HAND).getDamageValue() == player.getItemInHand(InteractionHand.MAIN_HAND).getMaxDamage() - 1) return false;
        return !player.isCreative();
    }

    public float getDestroySpeed(ItemStack stack, BlockState p_43289_) {
        if(stack.getDamageValue() == stack.getMaxDamage() - 1) return 0.0f;
        if (p_43289_.is(Blocks.COBWEB)) {
            return 15.0F;
        } else {
            return p_43289_.is(BlockTags.SWORD_EFFICIENT) ? 1.5F : 1.0F;
        }
    }

    public boolean hurtEnemy(ItemStack stack, LivingEntity p_43279_, LivingEntity p_43280_) {
        if(stack.getDamageValue() == stack.getMaxDamage() - 1) return false;
        stack.hurtAndBreak(1, p_43280_, (p_43296_) -> {
            p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    public boolean mineBlock(ItemStack stack, Level p_43283_, BlockState p_43284_, BlockPos p_43285_, LivingEntity p_43286_) {
        if(stack.getDamageValue() == stack.getMaxDamage() - 1) return false;
        if (p_43284_.getDestroySpeed(p_43283_, p_43285_) != 0.0F) {
            stack.hurtAndBreak(2, p_43286_, (p_43276_) -> {
                p_43276_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }

        return true;
    }

    public boolean isCorrectToolForDrops(BlockState p_43298_) {
        return p_43298_.is(Blocks.COBWEB);
    }

    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        if(stack.getDamageValue() == stack.getMaxDamage() - 1  && slot == EquipmentSlot.MAINHAND) return this.brokenModifiers;
        return slot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(slot);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
        if(stack.getDamageValue() == stack.getMaxDamage() - 1) return false;
        return net.minecraftforge.common.ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> componentList, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, level, componentList, tooltipFlag);
        componentList.add(Component.literal("Current Level: " + getLevel(stack)));
        componentList.add(Component.literal("Current Exp: " + getExperience(stack)));
    }


}
