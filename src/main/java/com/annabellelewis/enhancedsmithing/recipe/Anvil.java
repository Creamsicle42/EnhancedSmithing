package com.annabellelewis.enhancedsmithing.recipe;

import com.annabellelewis.enhancedsmithing.item.AttributeCrystalItem;
import com.annabellelewis.enhancedsmithing.item.ILevelableItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.AnvilUpdateEvent;



public class Anvil {
    public static void updateAnvil(AnvilUpdateEvent event) {


        if(event.getLeft().isRepairable()){
            if(event.getLeft().getItem().isValidRepairItem(event.getLeft(), event.getRight())){
                ItemStack output = event.getLeft().copy();
                event.setCost(1);

                if(event.getName() != ""){
                    output.setHoverName(Component.literal(event.getName()));
                    event.setCost(3);
                }

                output.setDamageValue(0);
                event.setOutput(output);

                event.setMaterialCost(1);
            }
        }

        if(event.getLeft().getItem() instanceof ILevelableItem && event.getRight().getItem() instanceof AttributeCrystalItem){
            AttributeCrystalItem rightItem = (AttributeCrystalItem)event.getRight().getItem();
            ILevelableItem leftItem = (ILevelableItem)event.getLeft().getItem();
            int remainingModifiers = 0;
            event.getLeft().getOrCreateTag();
            if (event.getLeft().getTag().contains("NumModifiers")){
                remainingModifiers = leftItem.getLevel(event.getLeft()) - event.getLeft().getTag().getInt("NumModifiers");
            } else {
                remainingModifiers = leftItem.getLevel(event.getLeft());
            }
            if(rightItem.isCrystalEmpowered(event.getRight()) &&  remainingModifiers > 0){
                ItemStack output = event.getLeft().copy();
                event.setCost(1);

                CompoundTag crystalTag = event.getRight().getTag();


                leftItem.addAttribute(
                        output,
                        rightItem.getModifier(event.getRight())
                        );
                output.getTag().putInt("NumModifiers", event.getLeft().getTag().getInt("NumModifiers") + 1);
                event.setMaterialCost(1);
                event.setOutput(output);
            }
        }
    }
}
