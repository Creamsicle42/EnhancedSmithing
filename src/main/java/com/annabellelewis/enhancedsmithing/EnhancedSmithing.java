package com.annabellelewis.enhancedsmithing;

import com.annabellelewis.enhancedsmithing.datagen.Datagen;
import com.annabellelewis.enhancedsmithing.item.EnhancedArmorItem;
import com.annabellelewis.enhancedsmithing.recipe.Anvil;
import com.annabellelewis.enhancedsmithing.recipe.Grindstone;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.GrindstoneEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
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
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }
}
