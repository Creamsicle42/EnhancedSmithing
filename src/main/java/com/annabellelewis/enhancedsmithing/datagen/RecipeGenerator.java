package com.annabellelewis.enhancedsmithing.datagen;

import com.annabellelewis.enhancedsmithing.EnhancedSmithing;
import com.annabellelewis.enhancedsmithing.Registration;
import com.google.gson.JsonElement;
import net.minecraft.advancements.critereon.ImpossibleTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider {



    public RecipeGenerator(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        add_tool_upgrade_recipes(
                consumer,
                "minecraft:stone",
                "minecraft:iron",
                Registration.REFINED_IRON_INGOT.get(),
                Registration.IRON_UPGRADE_SMITHING_TEMPLATE.get(),
                "stone_to_iron");
        add_armor_upgrade_recipes(
                consumer,
                "minecraft:leather",
                "minecraft:iron",
                Registration.REFINED_IRON_INGOT.get(),
                Registration.IRON_UPGRADE_SMITHING_TEMPLATE.get(),
                "leather_to_iron"
        );
        add_tool_upgrade_recipes(
                consumer,
                "minecraft:iron",
                "minecraft:diamond",
                Registration.DIAMONDSTEEL_INGOT.get(),
                Registration.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get(),
                "iron_to_diamond");
        add_armor_upgrade_recipes(
                consumer,
                "minecraft:iron",
                "minecraft:diamond",
                Registration.DIAMONDSTEEL_INGOT.get(),
                Registration.DIAMOND_UPGRADE_SMITHING_TEMPLATE.get(),
                "iron_to_diamond"
        );

        addIngotToNugget(
                consumer,
                Registration.REFINED_IRON_NUGGET.get(),
                Registration.REFINED_IRON_INGOT.get(),
                "refined_iron"
        );

        addIngotToNugget(
                consumer,
                Registration.DIAMONDSTEEL_NUGGET.get(),
                Registration.DIAMONDSTEEL_INGOT.get(),
                "diamondsteel"
        );
        addIngotToNugget(
                consumer,
                Registration.BLOOD_GOLD_NUGGET.get(),
                Registration.BLOOD_GOLD_INGOT.get(),
                "blood_gold"
        );

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registration.ENH_STONE_AXE.get())
                .pattern("FF")
                .pattern("FS")
                .pattern(" S")
                .define('F', Items.FLINT)
                .define('S', Items.STICK)
                .unlockedBy("has_flint", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Items.FLINT).build()))
                .save(consumer, "stone_axe_from_flint");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registration.ENH_STONE_PICKAXE.get())
                .pattern("FFF")
                .pattern(" S ")
                .pattern(" S ")
                .define('F', Items.FLINT)
                .define('S', Items.STICK)
                .unlockedBy("has_flint", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Items.FLINT).build()))
                .save(consumer, "stone_pickaxe_from_flint");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registration.ENH_STONE_SWORD.get())
                .pattern("F")
                .pattern("F")
                .pattern("S")
                .define('F', Items.FLINT)
                .define('S', Items.STICK)
                .unlockedBy("has_flint", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Items.FLINT).build()))
                .save(consumer, "stone_sword_from_flint");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registration.ENH_STONE_SHOVEL.get())
                .pattern("F")
                .pattern("S")
                .pattern("S")
                .define('F', Items.FLINT)
                .define('S', Items.STICK)
                .unlockedBy("has_flint", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Items.FLINT).build()))
                .save(consumer, "stone_shovel_from_flint");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registration.ENH_STONE_HOE.get())
                .pattern("FF")
                .pattern(" S")
                .pattern(" S")
                .define('F', Items.FLINT)
                .define('S', Items.STICK)
                .unlockedBy("has_flint", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Items.FLINT).build()))
                .save(consumer, "stone_hoe_from_flint");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.FLINT)
                .pattern("GG")
                .pattern("G ")
                .define('G', Items.GRAVEL)
                .unlockedBy("has_flint", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Items.GRAVEL).build()))
                .save(consumer, new ResourceLocation(EnhancedSmithing.MODID,"gravel_from_flint"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registration.REPAIR_KIT.get())
                .pattern("SMI")
                .pattern("LLL")
                .define('L', Items.LEATHER)
                .define('S', Items.STICK)
                .define('M', Items.SMOOTH_STONE_SLAB)
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_iron", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(Items.IRON_INGOT).build()))
                .save(consumer,new ResourceLocation(EnhancedSmithing.MODID, "repair_kit"));

        removeToolRecipes(consumer, "wooden");
        removeToolRecipes(consumer, "iron");
        removeArmorRecipes(consumer, "iron");
        removeToolRecipes(consumer, "diamond");
        removeArmorRecipes(consumer, "diamond");


    }

    static void add_tool_upgrade_recipes(Consumer<FinishedRecipe> consumer, String baseMaterial, String targetMaterial, Item upgradeItem, Item upgradeTemplate, String name){
        CompoundTag inSwordTag = new CompoundTag();
        inSwordTag.putString("id", baseMaterial + "_sword");
        inSwordTag.putInt("Count", 1);
        CompoundTag outSwordTag = new CompoundTag();
        outSwordTag.putString("id", targetMaterial + "_sword");
        outSwordTag.putInt("Count", 1);

        CompoundTag inAxeTag = new CompoundTag();
        inAxeTag.putString("id", baseMaterial + "_axe");
        inAxeTag.putInt("Count", 1);
        CompoundTag outAxeTag = new CompoundTag();
        outAxeTag.putString("id", targetMaterial + "_axe");
        outAxeTag.putInt("Count", 1);

        CompoundTag inPickaxeTag = new CompoundTag();
        inPickaxeTag.putString("id", baseMaterial + "_pickaxe");
        inPickaxeTag.putInt("Count", 1);
        CompoundTag outPickaxeTag = new CompoundTag();
        outPickaxeTag.putString("id", targetMaterial + "_pickaxe");
        outPickaxeTag.putInt("Count", 1);

        CompoundTag inShovelTag = new CompoundTag();
        inShovelTag.putString("id", baseMaterial + "_shovel");
        inShovelTag.putInt("Count", 1);
        CompoundTag outShovelTag = new CompoundTag();
        outShovelTag.putString("id", targetMaterial + "_shovel");
        outShovelTag.putInt("Count", 1);

        CompoundTag inHoeTag = new CompoundTag();
        inHoeTag.putString("id", baseMaterial + "_hoe");
        inHoeTag.putInt("Count", 1);
        CompoundTag outHoeTag = new CompoundTag();
        outHoeTag.putString("id", targetMaterial + "_hoe");
        outHoeTag.putInt("Count", 1);

        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(upgradeTemplate),
                Ingredient.of(ItemStack.of(inSwordTag)),
                Ingredient.of(upgradeItem),
                RecipeCategory.TOOLS,
                ItemStack.of(outSwordTag).getItem())
                .unlocks ("has_template", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(upgradeTemplate).build()))
                .save(consumer, new ResourceLocation(EnhancedSmithing.MODID,  name + "_sword_upgrade"));

        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(upgradeTemplate),
                Ingredient.of(ItemStack.of(inAxeTag)),
                Ingredient.of(upgradeItem),
                RecipeCategory.TOOLS,
                ItemStack.of(outAxeTag).getItem())
                .unlocks ("has_template", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(upgradeTemplate).build()))
                .save(consumer, new ResourceLocation(EnhancedSmithing.MODID,name + "_axe_upgrade"));

        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(upgradeTemplate),
                Ingredient.of(ItemStack.of(inPickaxeTag)),
                Ingredient.of(upgradeItem),
                RecipeCategory.TOOLS,
                ItemStack.of(outPickaxeTag).getItem())
                .unlocks ("has_template", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(upgradeTemplate).build()))
                .save(consumer, new ResourceLocation(EnhancedSmithing.MODID, name + "_pickaxe_upgrade"));

        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(upgradeTemplate),
                Ingredient.of(ItemStack.of(inShovelTag)),
                Ingredient.of(upgradeItem),
                RecipeCategory.TOOLS,
                ItemStack.of(outShovelTag).getItem())
                .unlocks ("has_template", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(upgradeTemplate).build()))
                .save(consumer, new ResourceLocation(EnhancedSmithing.MODID,name + "_shovel_upgrade"));

        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(upgradeTemplate),
                Ingredient.of(ItemStack.of(inHoeTag)),
                Ingredient.of(upgradeItem),
                RecipeCategory.TOOLS,
                ItemStack.of(outHoeTag).getItem())
                .unlocks ("has_template", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(upgradeTemplate).build()))
                .save(consumer, new ResourceLocation(EnhancedSmithing.MODID,name + "_hoe_upgrade" ));
    }

    static void add_armor_upgrade_recipes(Consumer<FinishedRecipe> consumer, String baseMaterial, String targetMaterial, Item upgradeItem, Item upgradeTemplate, String name){
        CompoundTag inHelmetTag = new CompoundTag();
        inHelmetTag.putString("id", baseMaterial + "_helmet");
        inHelmetTag.putInt("Count", 1);
        CompoundTag outHelmetTag = new CompoundTag();
        outHelmetTag.putString("id", targetMaterial + "_helmet");
        outHelmetTag.putInt("Count", 1);

        CompoundTag inChestplateTag = new CompoundTag();
        inChestplateTag.putString("id", baseMaterial + "_chestplate");
        inChestplateTag.putInt("Count", 1);
        CompoundTag outChestplateTag = new CompoundTag();
        outChestplateTag.putString("id", targetMaterial + "_chestplate");
        outChestplateTag.putInt("Count", 1);

        CompoundTag inLeggingsTag = new CompoundTag();
        inLeggingsTag.putString("id", baseMaterial + "_leggings");
        inLeggingsTag.putInt("Count", 1);
        CompoundTag outLeggingsTag = new CompoundTag();
        outLeggingsTag.putString("id", targetMaterial + "_leggings");
        outLeggingsTag.putInt("Count", 1);

        CompoundTag inBootsTag = new CompoundTag();
        inBootsTag.putString("id", baseMaterial + "_boots");
        inBootsTag.putInt("Count", 1);
        CompoundTag outBootsTag = new CompoundTag();
        outBootsTag.putString("id", targetMaterial + "_boots");
        outBootsTag.putInt("Count", 1);


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(upgradeTemplate),
                        Ingredient.of(ItemStack.of(inHelmetTag)),
                        Ingredient.of(upgradeItem),
                        RecipeCategory.TOOLS,
                        ItemStack.of(outHelmetTag).getItem())
                .unlocks ("has_template", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(upgradeTemplate).build()))
                .save(consumer, new ResourceLocation(EnhancedSmithing.MODID,  name + "_helmet_upgrade"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(upgradeTemplate),
                        Ingredient.of(ItemStack.of(inChestplateTag)),
                        Ingredient.of(upgradeItem),
                        RecipeCategory.TOOLS,
                        ItemStack.of(outChestplateTag).getItem())
                .unlocks ("has_template", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(upgradeTemplate).build()))
                .save(consumer, new ResourceLocation(EnhancedSmithing.MODID,name + "_chestplate_upgrade"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(upgradeTemplate),
                        Ingredient.of(ItemStack.of(inLeggingsTag)),
                        Ingredient.of(upgradeItem),
                        RecipeCategory.TOOLS,
                        ItemStack.of(outLeggingsTag).getItem())
                .unlocks ("has_template", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(upgradeTemplate).build()))
                .save(consumer, new ResourceLocation(EnhancedSmithing.MODID, name + "_leggings_upgrade"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(upgradeTemplate),
                        Ingredient.of(ItemStack.of(inBootsTag)),
                        Ingredient.of(upgradeItem),
                        RecipeCategory.TOOLS,
                        ItemStack.of(outBootsTag).getItem())
                .unlocks ("has_template", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(upgradeTemplate).build()))
                .save(consumer, new ResourceLocation(EnhancedSmithing.MODID,name + "_boots_upgrade"));
    }

    void addIngotToNugget(Consumer<FinishedRecipe> consumer, Item nuggetItem, Item ingotItem, String material){
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, nuggetItem, 9)
                .requires(ingotItem)
                .unlockedBy("has_" + material + "_ingot",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(ingotItem).build()))
                .save(consumer, new ResourceLocation(EnhancedSmithing.MODID, material + "_ingot_to_nuggets"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ingotItem)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', nuggetItem)
                .unlockedBy("has_" + material + "_ingot",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ItemPredicate.Builder.item().of(nuggetItem).build()))
                .save(consumer, new ResourceLocation(EnhancedSmithing.MODID, material + "_nuggets_to_ingot"));
    }

    void removeRecipe(Consumer<FinishedRecipe> consumer, String recipeName){
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.AIR)
                .requires(Items.AIR)
                .unlockedBy("", new ImpossibleTrigger.TriggerInstance())
                .save(consumer, new ResourceLocation("minecraft", recipeName));
    }

    void removeToolRecipes(Consumer<FinishedRecipe> consumer, String tier){
        removeRecipe(consumer, tier + "_axe");
        removeRecipe(consumer, tier + "_pickaxe");
        removeRecipe(consumer, tier + "_sword");
        removeRecipe(consumer, tier + "_hoe");
        removeRecipe(consumer, tier + "_shovel");
    }

    void removeArmorRecipes(Consumer<FinishedRecipe> consumer, String tier){
        removeRecipe(consumer, tier + "_helmet");
        removeRecipe(consumer, tier + "_chestplate");
        removeRecipe(consumer, tier + "_leggings");
        removeRecipe(consumer, tier + "_boots");
    }
}
