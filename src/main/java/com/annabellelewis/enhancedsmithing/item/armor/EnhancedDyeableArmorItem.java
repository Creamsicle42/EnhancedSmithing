package com.annabellelewis.enhancedsmithing.item.armor;

import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.DyeableLeatherItem;

public class EnhancedDyeableArmorItem extends EnhancedArmorItem implements DyeableLeatherItem {
    public EnhancedDyeableArmorItem(ArmorMaterial armorMaterial, Type type, Properties properties) {
        super(armorMaterial, type, properties);
    }
}
