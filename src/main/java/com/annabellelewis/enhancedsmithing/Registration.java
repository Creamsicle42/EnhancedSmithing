package com.annabellelewis.enhancedsmithing;

import com.annabellelewis.enhancedsmithing.item.*;
import com.annabellelewis.enhancedsmithing.loot.ChestGenModifier;
import com.annabellelewis.enhancedsmithing.recipe.KitRepairRecipe;
import com.annabellelewis.enhancedsmithing.tiers.CustomArmorMaterials;
import com.annabellelewis.enhancedsmithing.tiers.ToolTiers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.FireworkRocketRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class Registration {
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EnhancedSmithing.MODID);
    public static final DeferredRegister<Item> OVERRIDEITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "minecraft");
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, EnhancedSmithing.MODID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPES = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, EnhancedSmithing.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EnhancedSmithing.MODID);

    public static final RegistryObject<Item> ENH_STONE_PICKAXE = OVERRIDEITEMS.register(
            "stone_pickaxe",
            () -> new EnhancedPickaxeItem(Tiers.STONE, 1, -2.8F, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_STONE_SWORD = OVERRIDEITEMS.register(
            "stone_sword",
            () -> new EnhancedSwordItem(Tiers.STONE, 3, -2.4F, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_STONE_SHOVEL = OVERRIDEITEMS.register(
            "stone_shovel",
            () -> new EnhancedShovelItem(Tiers.STONE, 1.5F, -3.0F, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_STONE_AXE = OVERRIDEITEMS.register(
            "stone_axe",
            () -> new EnhancedAxeItem(Tiers.STONE, 7.0F, -3.2F, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_STONE_HOE = OVERRIDEITEMS.register(
            "stone_hoe",
            () -> new EnhancedHoeItem(Tiers.STONE, -1, -2.0F, new Item.Properties())
    );


    public static final RegistryObject<Item> ENH_GOLD_PICKAXE = OVERRIDEITEMS.register(
            "golden_pickaxe",
            () -> new EnhancedPickaxeItem(ToolTiers.ENHANCED_GOLD, 1, -2.8F, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_GOLD_SWORD = OVERRIDEITEMS.register(
            "golden_sword",
            () -> new EnhancedSwordItem(ToolTiers.ENHANCED_GOLD, 3, -2.4F, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_GOLD_SHOVEL = OVERRIDEITEMS.register(
            "golden_shovel",
            () -> new EnhancedShovelItem(ToolTiers.ENHANCED_GOLD, 1.5F, -3.0F, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_GOLD_AXE = OVERRIDEITEMS.register(
            "golden_axe",
            () -> new EnhancedAxeItem(ToolTiers.ENHANCED_GOLD, 6.0F, -3.0F, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_GOLD_HOE = OVERRIDEITEMS.register(
            "golden_hoe",
            () -> new EnhancedHoeItem(ToolTiers.ENHANCED_GOLD, 0, -3.0F, new Item.Properties())
    );


    public static final RegistryObject<Item> ENH_IRON_SWORD = OVERRIDEITEMS.register(
            "iron_sword",
            () -> new EnhancedSwordItem(Tiers.IRON, 3, -2.4F, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_IRON_SHOVEL = OVERRIDEITEMS.register(
            "iron_shovel",
            () -> new EnhancedShovelItem(Tiers.IRON, 1.5F, -3.0F, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_IRON_PICKAXE = OVERRIDEITEMS.register(
            "iron_pickaxe",
            () -> new EnhancedPickaxeItem(Tiers.IRON, 1, -2.8F, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_IRON_AXE = OVERRIDEITEMS.register(
            "iron_axe",
            () -> new EnhancedAxeItem(Tiers.IRON, 6.0F, -3.1F, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_IRON_HOE = OVERRIDEITEMS.register(
            "iron_hoe",
            () -> new EnhancedHoeItem(Tiers.IRON, -2, -1.0F, new Item.Properties())
    );

    public static final RegistryObject<Item> ENH_DIAMOND_SWORD = OVERRIDEITEMS.register(
            "diamond_sword",
            () -> new EnhancedSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_DIAMOND_SHOVEL = OVERRIDEITEMS.register(
            "diamond_shovel",
            () -> new EnhancedShovelItem(Tiers.DIAMOND, 1.5F, -3.0F, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_DIAMOND_PICKAXE = OVERRIDEITEMS.register(
            "diamond_pickaxe",
            () -> new EnhancedPickaxeItem(Tiers.DIAMOND, 1, -2.8F, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_DIAMOND_AXE = OVERRIDEITEMS.register(
            "diamond_axe",
            () -> new EnhancedAxeItem(Tiers.DIAMOND, 5.0F, -3.0F, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_DIAMOND_HOE = OVERRIDEITEMS.register(
            "diamond_hoe",
            () -> new EnhancedHoeItem(Tiers.DIAMOND, -3, 0.0F, new Item.Properties())
    );

    public static final RegistryObject<Item> ENH_NETHERITE_SWORD = OVERRIDEITEMS.register(
            "netherite_sword",
            () -> new EnhancedSwordItem(Tiers.NETHERITE, 3, -2.4F, (new Item.Properties()).fireResistant())
    );
    public static final RegistryObject<Item> ENH_NETHERITE_SHOVEL = OVERRIDEITEMS.register(
            "netherite_shovel",
            () -> new EnhancedShovelItem(Tiers.NETHERITE, 1.5F, -3.0F, (new Item.Properties()).fireResistant())
    );
    public static final RegistryObject<Item> ENH_NETHERITE_PICKAXE = OVERRIDEITEMS.register(
            "netherite_pickaxe",
            () -> new EnhancedPickaxeItem(Tiers.NETHERITE, 1, -2.8F, (new Item.Properties()).fireResistant())
    );
    public static final RegistryObject<Item> ENH_NETHERITE_AXE = OVERRIDEITEMS.register(
            "netherite_axe",
            () -> new EnhancedAxeItem(Tiers.NETHERITE, 5.0F, -3.0F, (new Item.Properties()).fireResistant())
    );
    public static final RegistryObject<Item> ENH_NETHERITE_HOE = OVERRIDEITEMS.register(
            "netherite_hoe",
            () -> new EnhancedHoeItem(Tiers.NETHERITE, -4, 0.0F, (new Item.Properties()).fireResistant())
    );


    public static final RegistryObject<Item> ENH_LEATHER_HELMET = OVERRIDEITEMS.register(
            "leather_helmet",
            () -> new EnhancedDyeableArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.HELMET, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_LEATHER_CHESTPLATE = OVERRIDEITEMS.register(
            "leather_chestplate",
            () -> new EnhancedDyeableArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_LEATHER_LEGGINGS = OVERRIDEITEMS.register(
            "leather_leggings",
            () -> new EnhancedDyeableArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_LEATHER_BOOTS = OVERRIDEITEMS.register(
            "leather_boots",
            () -> new EnhancedDyeableArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.BOOTS, new Item.Properties())
    );

    public static final RegistryObject<Item> ENH_IRON_HELMET = OVERRIDEITEMS.register(
            "iron_helmet",
            () -> new EnhancedArmorItem(ArmorMaterials.IRON, ArmorItem.Type.HELMET, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_IRON_CHESTPLATE = OVERRIDEITEMS.register(
            "iron_chestplate",
            () -> new EnhancedArmorItem(ArmorMaterials.IRON, ArmorItem.Type.CHESTPLATE, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_IRON_LEGGINGS = OVERRIDEITEMS.register(
            "iron_leggings",
            () -> new EnhancedArmorItem(ArmorMaterials.IRON, ArmorItem.Type.LEGGINGS, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_IRON_BOOTS = OVERRIDEITEMS.register(
            "iron_boots",
            () -> new EnhancedArmorItem(ArmorMaterials.IRON, ArmorItem.Type.BOOTS, new Item.Properties())
    );

    public static final RegistryObject<Item> ENH_GOLD_HELMET = OVERRIDEITEMS.register(
            "golden_helmet",
            () -> new EnhancedArmorItem(CustomArmorMaterials.ENHANCED_GOLD_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_GOLD_CHESTPLATE = OVERRIDEITEMS.register(
            "golden_chestplate",
            () -> new EnhancedArmorItem(CustomArmorMaterials.ENHANCED_GOLD_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_GOLD_LEGGINGS = OVERRIDEITEMS.register(
            "golden_leggings",
            () -> new EnhancedArmorItem(CustomArmorMaterials.ENHANCED_GOLD_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_GOLD_BOOTS = OVERRIDEITEMS.register(
            "golden_boots",
            () -> new EnhancedArmorItem(CustomArmorMaterials.ENHANCED_GOLD_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties())
    );

    public static final RegistryObject<Item> ENH_DIAMOND_HELMET = OVERRIDEITEMS.register(
            "diamond_helmet",
            () -> new EnhancedArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_DIAMOND_CHESTPLATE = OVERRIDEITEMS.register(
            "diamond_chestplate",
            () -> new EnhancedArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_DIAMOND_LEGGINGS = OVERRIDEITEMS.register(
            "diamond_leggings",
            () -> new EnhancedArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_DIAMOND_BOOTS = OVERRIDEITEMS.register(
            "diamond_boots",
            () -> new EnhancedArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties())
    );

    public static final RegistryObject<Item> ENH_NETHERITE_HELMET = OVERRIDEITEMS.register(
            "netherite_helmet",
            () -> new EnhancedArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.HELMET, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_NETHERITE_CHESTPLATE = OVERRIDEITEMS.register(
            "netherite_chestplate",
            () -> new EnhancedArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_NETHERITE_LEGGINGS = OVERRIDEITEMS.register(
            "netherite_leggings",
            () -> new EnhancedArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.LEGGINGS, new Item.Properties())
    );
    public static final RegistryObject<Item> ENH_NETHERITE_BOOTS = OVERRIDEITEMS.register(
            "netherite_boots",
            () -> new EnhancedArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.BOOTS, new Item.Properties())
    );


    // Register templates
    public static final RegistryObject<Item> IRON_UPGRADE_SMITHING_TEMPLATE = ITEMS.register(
            "iron_upgrade_smithing_template",
            () -> EnhancedSmithingTemplateItem.createIronUpgradeTemplate()
    );

    public static final RegistryObject<Item> DIAMOND_UPGRADE_SMITHING_TEMPLATE = ITEMS.register(
            "diamond_upgrade_smithing_template",
            () -> EnhancedSmithingTemplateItem.createDiamondUpgradeTemplate()
    );

    public static final RegistryObject<Item> GOLD_UPGRADE_SMITHING_TEMPLATE = ITEMS.register(
            "gold_upgrade_smithing_template",
            () -> EnhancedSmithingTemplateItem.createGoldUpgradeTemplate()
    );


    // Register misc items
    public static final RegistryObject<AttributeCrystalItem> ATTRIBUTE_CRYSTAL = ITEMS.register(
            "attribute_crystal",
            () -> new AttributeCrystalItem()
    );
    public static final RegistryObject<Item> REFINED_IRON_INGOT = ITEMS.register(
            "refined_iron_ingot",
            () -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> REFINED_IRON_NUGGET = ITEMS.register(
            "refined_iron_nugget",
            () -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> IRON_SLATE = ITEMS.register(
            "iron_slate",
            () -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> DIAMONDSTEEL_COMPOUND = ITEMS.register(
            "diamondsteel_compound",
            () -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> DIAMONDSTEEL_NUGGET = ITEMS.register(
            "diamondsteel_nugget",
            () -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> DIAMONDSTEEL_INGOT = ITEMS.register(
            "diamondsteel_ingot",
            () -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> DIAMOND_SHARD = ITEMS.register(
            "diamond_shard",
            () -> new Item(new Item.Properties())
    );

    public static final RegistryObject<Item> BLOOD_GOLD_COMPOUND = ITEMS.register(
            "blood_gold_compound",
            () -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> BLOOD_GOLD_INGOT = ITEMS.register(
            "blood_gold_ingot",
            () -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> BLOOD_GOLD_NUGGET = ITEMS.register(
            "blood_gold_nugget",
            () -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> BLOOD_GOLD_SLATE = ITEMS.register(
            "blood_gold_slate",
            () -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> REPAIR_KIT = ITEMS.register(
            "repair_kit",
            () -> new Item(new Item.Properties().durability(12))
    );

    // Register loot modifiers
    public static final RegistryObject<Codec<ChestGenModifier>> CHEST_GEN_MODIFIER = GLOBAL_LOOT_MODIFIERS.register(
            "loot_chest_gen",
            ChestGenModifier.CODEC
    );

    // Register recipes
    public static final RegistryObject<RecipeSerializer<?>> KIT_REPAIR_RECIPE = RECIPES.register(
            "kit_repair",
            () -> new SimpleCraftingRecipeSerializer<>(KitRepairRecipe::new)
    );

    // Register creative mode tab
    public static final RegistryObject<CreativeModeTab> ENHANCED_SMITHING_TAB = CREATIVE_MODE_TABS.register("example", () -> CreativeModeTab.builder()
            // Set name of tab to display
            .title(Component.translatable("item_group." + EnhancedSmithing.MODID + ".main_tab"))
            // Set icon of creative tab
            .icon(() -> new ItemStack(REFINED_IRON_INGOT.get()))
            .build()
    );

    public static void init(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        OVERRIDEITEMS.register(modEventBus);
        GLOBAL_LOOT_MODIFIERS.register(modEventBus);
        RECIPES.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }

    static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == ENHANCED_SMITHING_TAB.getKey()) {
            event.accept(ATTRIBUTE_CRYSTAL);
            event.accept(REPAIR_KIT);
            event.accept(IRON_UPGRADE_SMITHING_TEMPLATE);
            event.accept(GOLD_UPGRADE_SMITHING_TEMPLATE);
            event.accept(DIAMOND_UPGRADE_SMITHING_TEMPLATE);
            event.accept(IRON_SLATE);
            event.accept(BLOOD_GOLD_SLATE);
            event.accept(REFINED_IRON_INGOT);
            event.accept(REFINED_IRON_NUGGET);
            event.accept(BLOOD_GOLD_COMPOUND);
            event.accept(BLOOD_GOLD_INGOT);
            event.accept(BLOOD_GOLD_NUGGET);
            event.accept(DIAMONDSTEEL_COMPOUND);
            event.accept(DIAMONDSTEEL_INGOT);
            event.accept(DIAMONDSTEEL_NUGGET);
            event.accept(DIAMOND_SHARD);

        }
    }

}
