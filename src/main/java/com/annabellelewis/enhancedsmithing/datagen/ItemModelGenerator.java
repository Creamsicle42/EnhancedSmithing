package com.annabellelewis.enhancedsmithing.datagen;

import com.annabellelewis.enhancedsmithing.EnhancedSmithing;
import com.annabellelewis.enhancedsmithing.Registration;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.ModelProvider;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelGenerator extends ItemModelProvider {


    public ItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EnhancedSmithing.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(Registration.AMETHYST_AXE.get());
        basicItem(Registration.AMETHYST_PICKAXE.get());
        basicItem(Registration.AMETHYST_HOE.get());
        basicItem(Registration.AMETHYST_SHOVEL.get());
        basicItem(Registration.AMETHYST_SWORD.get());

        basicItem(Registration.AMETHYST_HELMET.get());
        basicItem(Registration.AMETHYST_CHESTPLATE.get());
        basicItem(Registration.AMETHYST_LEGGINGS.get());
        basicItem(Registration.AMETHYST_BOOTS.get());
    }
}
