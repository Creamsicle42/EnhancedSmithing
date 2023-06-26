package com.annabellelewis.enhancedsmithing.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;



public interface ILevelableItem {

    default int getExperience(ItemStack stack) {
        return stack.getOrCreateTag().contains("ItemExperience") ? stack.getOrCreateTag().getInt("ItemExperience") : 0;
    }


    default void addExperience(ItemStack stack, int ammount) {
        int currentExperience = getExperience(stack);
        currentExperience += ammount;
        stack.getTag().putInt("ItemExperience", currentExperience);
    }


    default int getLevel(ItemStack stack) {
        int currentExperience = getExperience(stack);
        return Math.min((int)Math.floor(Math.sqrt((double)currentExperience * 0.01)), 10);
    }


    default void addAttribute(ItemStack stack, AttributeModifier modifier) {
        stack.getOrCreateTag();
        if (!stack.getTag().contains("AttributeModifiers", 9)) {
            stack.getTag().put("AttributeModifiers", new ListTag());
        }

        ListTag listtag = stack.getTag().getList("AttributeModifiers", 10);
        CompoundTag compoundtag = modifier.save();
        compoundtag.putString("AttributeName", modifier.getName());
        compoundtag.putString("Slot", EquipmentSlot.MAINHAND.getName());


        listtag.add(compoundtag);
    }

    default int getModifierCount(ItemStack stack) {
        stack.getOrCreateTag();
        return stack.getTag().getInt("NumModifiers");
    }

    default void clearModifiers(ItemStack stack) {
        stack.getOrCreateTag();
        if (stack.getTag().contains("AttributeModifiers", 9)) {
            stack.getTag().put("AttributeModifiers", new ListTag());
        }
        stack.getTag().putInt("NumModifiers", 0);
    }

}
