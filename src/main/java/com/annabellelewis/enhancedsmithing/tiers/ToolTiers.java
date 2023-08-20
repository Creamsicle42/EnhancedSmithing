package com.annabellelewis.enhancedsmithing.tiers;

import com.annabellelewis.enhancedsmithing.Registration;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

public class ToolTiers {
    public static Tier ENHANCED_GOLD = new ForgeTier(2, 200, 8f, 2.0f, 22, BlockTags.NEEDS_IRON_TOOL,
            () -> {return Ingredient.of(Items.GOLD_INGOT);});

    public static Tier AMETHYST = new ForgeTier(3, 1200, 10f, 3.0f, 22, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> {return Ingredient.of(Items.AMETHYST_SHARD);});
}
