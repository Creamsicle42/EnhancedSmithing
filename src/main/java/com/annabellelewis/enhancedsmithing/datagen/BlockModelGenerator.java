package com.annabellelewis.enhancedsmithing.datagen;

import com.annabellelewis.enhancedsmithing.EnhancedSmithing;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockModelGenerator extends BlockModelProvider {
    public BlockModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EnhancedSmithing.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        cubeAll("impregnated_diamondsteel_block", modLoc("block/impregnated_diamondsteel_block"));
        cubeAll("rough_vibronite_block", modLoc("block/rough_vibronite_block"));
    }
}
