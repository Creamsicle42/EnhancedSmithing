package com.annabellelewis.enhancedsmithing.item;

import com.annabellelewis.enhancedsmithing.Registration;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import java.util.List;

public class EnhancedNetheriteArmorItem extends EnhancedArmorItem{

    static List<ResourceKey<DamageType>> blockableDamageTypes = List.of(
            DamageTypes.FIREBALL,
            DamageTypes.IN_FIRE,
            DamageTypes.LAVA,
            DamageTypes.ON_FIRE,
            DamageTypes.UNATTRIBUTED_FIREBALL
    );

    public EnhancedNetheriteArmorItem(ArmorMaterial armorMaterial, Type type, Properties properties) {
        super(armorMaterial, type, properties);
    }

    public static void LivingHurtEvent(LivingHurtEvent event){
        if(event.getEntity().getType() != EntityType.PLAYER){return;}

        // Prevent taking damage from magma if the player is wearing netherite boots
        if(
                event.getSource().is(DamageTypes.HOT_FLOOR) &&
               event.getEntity().getItemBySlot(EquipmentSlot.FEET).is(Registration.ENH_NETHERITE_BOOTS.get())
        ){
            event.setCanceled(true);
        }

        // Reduce damage from fire sources by 20% for each peace of netherite equipment
        if(IsDamageSourceBlockable(event.getSource())) {
            Iterable<ItemStack> armor = event.getEntity().getArmorSlots();
            float damageReduction = 0.0f;
            for (ItemStack stack : armor) {
                if (stack.getItem() instanceof EnhancedNetheriteArmorItem) {
                    damageReduction += 0.2f;
                }
            }
            event.setAmount(event.getAmount() - (event.getAmount() * damageReduction));
        }
    }

    public static boolean IsDamageSourceBlockable(DamageSource source){
        for(ResourceKey<DamageType> type: blockableDamageTypes){
            if(source.is(type)) return true;
        }
        return false;
    }
}
