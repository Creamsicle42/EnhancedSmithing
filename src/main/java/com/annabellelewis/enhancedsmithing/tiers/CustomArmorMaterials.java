package com.annabellelewis.enhancedsmithing.tiers;

import com.annabellelewis.enhancedsmithing.EnhancedSmithing;
import com.annabellelewis.enhancedsmithing.Registration;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class CustomArmorMaterials {
    public static final ArmorMaterial ENHANCED_GOLD_MATERIAL = new CustomArmorMaterial(13,5, 22, SoundEvents.ARMOR_EQUIP_GOLD, Ingredient.of(Items.GOLD_INGOT), "minecraft:gold", 0.0f, 0.0f);
    public static final ArmorMaterial AMETHYST_MATERIAL = new CustomArmorMaterial(31,7, 22, SoundEvents.AMETHYST_CLUSTER_STEP, Ingredient.of(Items.AMETHYST_SHARD), EnhancedSmithing.MODID + ":amethyst", 1.0f, 0.0f);

    private static class CustomArmorMaterial implements ArmorMaterial{
        private final int baseDurability;
        private final int baseDefense;
        private final int enchantmentValue;
        private final SoundEvent equipSound;
        private final Ingredient repairIngredient;
        private final String name;
        private final float toughness;
        private final float knockbackResistance;

        CustomArmorMaterial(int baseDurability, int baseDefense, int enchantmentValue, SoundEvent equipSound, Ingredient repairIngredient, String name, float toughness, float knockbackResistance){
            this.baseDurability = baseDurability;
            this.baseDefense = baseDefense;
            this.enchantmentValue = enchantmentValue;
            this.equipSound = equipSound;
            this.repairIngredient = repairIngredient;
            this.name = name;
            this.toughness = toughness;
            this.knockbackResistance = knockbackResistance;
        }

        @Override
        public int getDurabilityForType(ArmorItem.Type type) {
            switch (type.getName()){
                case ("helmet"):
                    return 11 * this.baseDurability;
                case "chestplate":
                    return 16 * this.baseDurability;
                case "leggings":
                    return 15 * this.baseDurability;
                case "boots":
                    return 13 * this.baseDurability;
            }
            return 0;
        }

        @Override
        public int getDefenseForType(ArmorItem.Type type) {
            switch (type.getName()){
                case ("helmet"):
                    return (int)Math.ceil(0.25f * this.baseDefense);
                case "chestplate":
                    return (int)Math.ceil(1f * this.baseDefense);
                case "leggings":
                    return (int)Math.ceil(0.75f * this.baseDefense);
                case "boots":
                    return (int)Math.ceil(0.20f * this.baseDefense);
            }
            return 0;
        }

        @Override
        public int getEnchantmentValue() {
            return this.enchantmentValue;
        }

        @Override
        public SoundEvent getEquipSound() {
            return this.equipSound;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return this.repairIngredient;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public float getToughness() {
            return this.toughness;
        }

        @Override
        public float getKnockbackResistance() {
            return this.knockbackResistance;
        }
    }
}
