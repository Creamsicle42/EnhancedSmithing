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
        basicItem(Registration.VIBRONITE_INGOT.get());
        basicItem(Registration.VIBRONITE_NUGGET.get());
        basicItem(Registration.IMPREGNATED_DIAMONDSTEEL_INGOT.get());
        basicItem(Registration.VIBRONITE_UPGRADE_SMITHING_TEMPLATE.get());

        basicItem(Registration.AMETHYST_AXE.get());
        basicItem(Registration.AMETHYST_PICKAXE.get());
        basicItem(Registration.AMETHYST_HOE.get());
        basicItem(Registration.AMETHYST_SHOVEL.get());
        basicItem(Registration.AMETHYST_SWORD.get());

        basicItem(Registration.AMETHYST_HELMET.get());
        basicItem(Registration.AMETHYST_CHESTPLATE.get());
        basicItem(Registration.AMETHYST_LEGGINGS.get());
        basicItem(Registration.AMETHYST_BOOTS.get());

        basicItem(Registration.VIBRONITE_AXE.get());
        basicItem(Registration.VIBRONITE_PICKAXE.get());
        basicItem(Registration.VIBRONITE_HOE.get());
        basicItem(Registration.VIBRONITE_SHOVEL.get());
        basicItem(Registration.VIBRONITE_SWORD.get());

        basicItem(Registration.VIBRONITE_HELMET.get());
        basicItem(Registration.VIBRONITE_CHESTPLATE.get());
        basicItem(Registration.VIBRONITE_LEGGINGS.get());
        basicItem(Registration.VIBRONITE_BOOTS.get());
    }
}
