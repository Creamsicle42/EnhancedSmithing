package com.annabellelewis.enhancedsmithing;

import com.annabellelewis.enhancedsmithing.datagen.Datagen;
import com.annabellelewis.enhancedsmithing.item.armor.EnhancedArmorItem;
import com.annabellelewis.enhancedsmithing.item.armor.EnhancedNetheriteArmorItem;
import com.annabellelewis.enhancedsmithing.item.armor.SculkArmorItem;
import com.annabellelewis.enhancedsmithing.recipe.Anvil;
import com.annabellelewis.enhancedsmithing.recipe.Grindstone;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EnhancedSmithing.MODID)
public class EnhancedSmithing
{
    public static final String MODID = "enhancedsmithing";
    private static final Logger LOGGER = LogUtils.getLogger();

    public EnhancedSmithing()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        Registration.init(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(Registration::addCreative);
        modEventBus.addListener(Datagen::generate);

        forgeEventBus.addListener(Anvil::updateAnvil);
        forgeEventBus.addListener(Grindstone::grindstonePlaceEvent);
        forgeEventBus.addListener(Grindstone::grindstoneTakeEvent);
        forgeEventBus.addListener(EnhancedArmorItem::LivingHurtEvent);
        forgeEventBus.addListener(EnhancedNetheriteArmorItem::LivingHurtEvent);
        forgeEventBus.addListener(SculkArmorItem::LivingVisibilityEvent);
        forgeEventBus.addListener(SculkArmorItem::VanillaGameEvent);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }
}
