package com.annabellelewis.enhancedsmithing.recipe;

import com.annabellelewis.enhancedsmithing.item.ILevelableItem;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.GrindstoneMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.GrindstoneEvent;
import net.minecraftforge.eventbus.api.Cancelable;

public class Grindstone {
    public static void grindstonePlaceEvent(GrindstoneEvent.OnPlaceItem event){
        if(event.getTopItem().getItem() instanceof ILevelableItem && event.getBottomItem().isEmpty()){
            ILevelableItem topItem = (ILevelableItem) event.getTopItem().getItem();
            if(topItem.getModifierCount(event.getTopItem()) > 0){
                ItemStack output = event.getTopItem().copy();
                topItem.clearModifiers(output);
                event.setOutput(output);
                event.setXp(topItem.getModifierCount(event.getTopItem()) * 4);
            }
        }
        if(event.getBottomItem().getItem() instanceof ILevelableItem && event.getTopItem().isEmpty()){
            ILevelableItem topItem = (ILevelableItem) event.getBottomItem().getItem();
            if(topItem.getModifierCount(event.getBottomItem()) > 0){
                ItemStack output = event.getBottomItem().copy();
                topItem.clearModifiers(output);
                event.setOutput(output);
                event.setXp(topItem.getModifierCount(event.getBottomItem()) * 4);
            }
        }
    }

    public static void grindstoneTakeEvent(GrindstoneEvent.OnTakeItem event){
    }
}
