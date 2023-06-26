package com.annabellelewis.enhancedsmithing.recipe;

import com.annabellelewis.enhancedsmithing.Registration;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class KitRepairRecipe extends CustomRecipe {


    public KitRepairRecipe(ResourceLocation p_252125_, CraftingBookCategory p_249010_) {
        super(p_252125_, p_249010_);
    }

    @Override
    public boolean matches(CraftingContainer container, Level p_44003_) {
        ItemStack toolStack = ItemStack.EMPTY;
        ItemStack repairItemStack = ItemStack.EMPTY;
        boolean foundTool = false;
        boolean foundRepairItem = false;
        boolean foundKit = false;
        for(int i = 0; i < container.getContainerSize(); i++){
            ItemStack stack =  container.getItem(i);
            if(stack.getItem() == Registration.REPAIR_KIT.get()){
                if(foundKit){
                    System.out.println("Aborting, already found kit");
                    return false;
                }else {
                    System.out.println("Setting kit");
                    foundKit = true;
                }
            } else if (stack.isRepairable()) {
                if(foundTool){
                    System.out.println("Aborting, already found tool");
                    return false;
                }else{
                    System.out.println("Setting tool");
                    foundTool = true;
                    toolStack = stack;
                }
            } else if (!stack.isEmpty()) {
                if(foundRepairItem){
                    System.out.println("Aborting, already found repair item");
                    return false;
                }else{
                    System.out.println("Setting repair item");
                    repairItemStack = stack;
                    foundRepairItem = true;
                }
            }
        }
        if(!toolStack.getItem().isValidRepairItem(toolStack, repairItemStack)) {
            System.out.println("Aborting, repair item " + repairItemStack.getItem().toString() + " is not valid");
            return false;
        }
        return foundKit && foundTool && foundRepairItem;
    }

    @Override
    public ItemStack assemble(CraftingContainer container, RegistryAccess p_267165_) {
        ItemStack toolStack = ItemStack.EMPTY;
        ItemStack repairKitStack = ItemStack.EMPTY;
        for(int i = 0; i < container.getContainerSize(); i++){
            ItemStack stack =  container.getItem(i);
            if(stack.getItem() == Registration.REPAIR_KIT.get()){
                repairKitStack = stack;
            } else if (stack.isRepairable()) {
                toolStack = stack;
            }
        }

        ItemStack outStack = toolStack.copy();
        int inputDamage = outStack.getDamageValue();
        inputDamage -= outStack.getMaxDamage() / 3;
        if(inputDamage < 0){
            inputDamage = 0;
        }
        outStack.setDamageValue(inputDamage);
        return outStack;
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingContainer container) {
        NonNullList<ItemStack> remainder = NonNullList.withSize(container.getContainerSize(), ItemStack.EMPTY);

        for(int i = 0; i < container.getContainerSize(); i++){
            ItemStack stack =  container.getItem(i);
            if(stack.getItem() == Registration.REPAIR_KIT.get()){
                stack.setDamageValue(stack.getDamageValue() + 1);
                if(stack.getDamageValue() < stack.getMaxDamage()){
                    remainder.set(i, stack.copy());
                }
            }
        }
        return remainder;
    }



    @Override
    public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
        return true;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Registration.KIT_REPAIR_RECIPE.get();
    }
}
