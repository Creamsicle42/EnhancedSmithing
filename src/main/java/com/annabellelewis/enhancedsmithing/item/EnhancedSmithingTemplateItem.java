package com.annabellelewis.enhancedsmithing.item;

import com.annabellelewis.enhancedsmithing.EnhancedSmithing;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class EnhancedSmithingTemplateItem {
    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;

    private static final String DESCRIPTION_ID = Util.makeDescriptionId("item", new ResourceLocation("smithing_template"));
    private static final Component INGREDIENTS_TITLE = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.ingredients"))).withStyle(TITLE_FORMAT);
    private static final Component APPLIES_TO_TITLE = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.applies_to"))).withStyle(TITLE_FORMAT);

    // Upgrade stuff
    private static final Component IRON_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation(EnhancedSmithing.MODID, "iron_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component IRON_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(EnhancedSmithing.MODID,"smithing_template.iron_upgrade.applies_to"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component IRON_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(EnhancedSmithing.MODID,"smithing_template.iron_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component IRON_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(EnhancedSmithing.MODID,"smithing_template.iron_upgrade.base_slot_description")));
    private static final Component IRON_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(EnhancedSmithing.MODID,"smithing_template.iron_upgrade.additions_slot_description")));


    private static final Component DIAMOND_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation(EnhancedSmithing.MODID, "diamond_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component DIAMOND_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(EnhancedSmithing.MODID,"smithing_template.diamond_upgrade.applies_to"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component DIAMOND_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(EnhancedSmithing.MODID,"smithing_template.diamond_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component DIAMOND_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(EnhancedSmithing.MODID,"smithing_template.diamond_upgrade.base_slot_description")));
    private static final Component DIAMOND_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(EnhancedSmithing.MODID,"smithing_template.diamond_upgrade.additions_slot_description")));


    private static final Component GOLD_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation(EnhancedSmithing.MODID, "gold_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component GOLD_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(EnhancedSmithing.MODID,"smithing_template.gold_upgrade.applies_to"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component GOLD_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(EnhancedSmithing.MODID,"smithing_template.gold_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component GOLD_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(EnhancedSmithing.MODID,"smithing_template.gold_upgrade.base_slot_description")));
    private static final Component GOLD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(EnhancedSmithing.MODID,"smithing_template.gold_upgrade.additions_slot_description")));



    // Slots
    private static final ResourceLocation EMPTY_SLOT_HELMET = new ResourceLocation("item/empty_armor_slot_helmet");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = new ResourceLocation("item/empty_armor_slot_chestplate");
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS = new ResourceLocation("item/empty_armor_slot_leggings");
    private static final ResourceLocation EMPTY_SLOT_BOOTS = new ResourceLocation("item/empty_armor_slot_boots");
    private static final ResourceLocation EMPTY_SLOT_HOE = new ResourceLocation("item/empty_slot_hoe");
    private static final ResourceLocation EMPTY_SLOT_AXE = new ResourceLocation("item/empty_slot_axe");
    private static final ResourceLocation EMPTY_SLOT_SWORD = new ResourceLocation("item/empty_slot_sword");
    private static final ResourceLocation EMPTY_SLOT_SHOVEL = new ResourceLocation("item/empty_slot_shovel");
    private static final ResourceLocation EMPTY_SLOT_PICKAXE = new ResourceLocation("item/empty_slot_pickaxe");
    private static final ResourceLocation EMPTY_SLOT_INGOT = new ResourceLocation("item/empty_slot_ingot");

    public static SmithingTemplateItem createIronUpgradeTemplate() {
        return new SmithingTemplateItem(IRON_UPGRADE_APPLIES_TO, IRON_UPGRADE_INGREDIENTS, IRON_UPGRADE, IRON_UPGRADE_BASE_SLOT_DESCRIPTION, IRON_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createTemplateUpgradeIconList(),  List.of(EMPTY_SLOT_INGOT));
    }

    public static SmithingTemplateItem createDiamondUpgradeTemplate() {
        return new SmithingTemplateItem(DIAMOND_UPGRADE_APPLIES_TO, DIAMOND_UPGRADE_INGREDIENTS, DIAMOND_UPGRADE, DIAMOND_UPGRADE_BASE_SLOT_DESCRIPTION, DIAMOND_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createTemplateUpgradeIconList(),  List.of(EMPTY_SLOT_INGOT));
    }

    public static SmithingTemplateItem createGoldUpgradeTemplate() {
        return new SmithingTemplateItem(GOLD_UPGRADE_APPLIES_TO, GOLD_UPGRADE_INGREDIENTS, GOLD_UPGRADE, GOLD_UPGRADE_BASE_SLOT_DESCRIPTION, GOLD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createTemplateUpgradeIconList(),  List.of(EMPTY_SLOT_INGOT));
    }

    private static List<ResourceLocation> createTemplateUpgradeIconList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_SWORD, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_AXE, EMPTY_SLOT_BOOTS, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL);
    }

}
