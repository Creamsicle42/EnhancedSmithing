package com.annabellelewis.enhancedsmithing.datagen;

import com.annabellelewis.enhancedsmithing.EnhancedSmithing;
import com.annabellelewis.enhancedsmithing.Registration;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStateGenerator extends BlockStateProvider {
    public BlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, EnhancedSmithing.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(Registration.IMPREGNATED_DIAMONDSTEEL_BLOCK.get(), cubeAll(Registration.IMPREGNATED_DIAMONDSTEEL_BLOCK.get()));
        simpleBlockWithItem(Registration.ROUGH_VIBRONITE_BLOCK.get(), cubeAll(Registration.ROUGH_VIBRONITE_BLOCK.get()));
    }
}
