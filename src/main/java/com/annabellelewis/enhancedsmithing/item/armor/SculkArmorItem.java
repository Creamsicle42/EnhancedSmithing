package com.annabellelewis.enhancedsmithing.item.armor;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.event.VanillaGameEvent;
import net.minecraftforge.event.entity.living.LivingEvent;

import java.util.List;

public class SculkArmorItem extends EnhancedArmorItem{


    private static final List<GameEvent> vibrationCancelableEvents = List.of(
            GameEvent.STEP,
            GameEvent.HIT_GROUND
    );

    public SculkArmorItem(ArmorMaterial armorMaterial, Type type, Properties properties) {
        super(armorMaterial, type, properties);
    }



    public static void LivingVisibilityEvent(LivingEvent.LivingVisibilityEvent event){
        Entity entity = event.getEntity();
        if(entity.getType() != EntityType.PLAYER){return;}
        float sculkCoverage = GetSculkArmorCoverage(entity);

        if(sculkCoverage == 0.0f){return;}

        double modifier = 1.0;

        if(entity.isInvisible()){
            modifier -= 0.9 * sculkCoverage;
        }else if(((LivingEntity)entity).isDiscrete()){
            modifier -= 0.5 * sculkCoverage;
        }else{
            modifier -= 0.2 * sculkCoverage;
        }

        event.modifyVisibility(modifier);
    }

    public static void VanillaGameEvent(VanillaGameEvent event){
        if(vibrationCancelableEvents.contains(event.getVanillaEvent())){tryCancelVibrationEvent(event);}

    }

    public static void tryCancelVibrationEvent(VanillaGameEvent event){
        if(!(event.getContext().sourceEntity() instanceof LivingEntity)){return;}
        Entity entity = event.getContext().sourceEntity();
        float coverage = GetSculkArmorCoverage(entity);
        if(coverage == 1.0f){
            event.setCanceled(true);
        }
    }

    public static float GetSculkArmorCoverage(Entity entity){
        int armorSlots = 0;
        int sculkSlots = 0;
        Iterable<ItemStack> armor = entity.getArmorSlots();
        for (ItemStack stack : armor) {
            if (stack.getItem() instanceof SculkArmorItem) {
                sculkSlots++;
            }
            armorSlots++;
        }
        return armorSlots == 0 ? 0.0f : (float)sculkSlots / (float)armorSlots;
    }
}
