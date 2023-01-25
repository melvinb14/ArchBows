package com.melvinbur.archbows;


import com.melvinbur.archbows.common.config.ABConfig;
import com.melvinbur.archbows.common.config.Config;
import com.melvinbur.archbows.common.util.Logger;
import com.melvinbur.archbows.core.BlockInit;
import com.melvinbur.archbows.core.CompostablesInit;
import com.melvinbur.archbows.core.CreativeModeTabInit;
import com.melvinbur.archbows.core.ItemInit;
import com.melvinbur.archbows.world.ABBiomeModifiers;
import com.melvinbur.archbows.world.ABConfiguredFeatures;
import com.melvinbur.archbows.world.ABPlacements;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;


@Mod(ArchBows.MOD_ID)
public class ArchBows {
    public static final String MOD_ID = "archbows";
    public static final Logger LOGGER = new Logger(MOD_ID);

    public ArchBows() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //Register config
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ABConfig.CONFIG_SPEC, "archbows-server.toml");
        ABConfig.loadConfig(ABConfig.CONFIG_SPEC,
                FMLPaths.CONFIGDIR.get().resolve("archbows-server.toml").toString());

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.CONFIG);



        ItemInit.register(eventBus);
        BlockInit.register(eventBus);


        ABBiomeModifiers.BIOME_MODIFIER_SERIALIZERS.register(eventBus);



        // EntityInit.ENTITY_TYPES.register(eventBus);
        eventBus.addListener(this::addCreative);
        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::clientSetup);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabInit.ARCHBOWS_TAB) {
            event.accept(BlockInit.WILD_FLAX);
            event.accept(BlockInit.WILD_FLAX2);
            event.accept(ItemInit.FLAX);
            event.accept(ItemInit.FLAX_SEEDS);
            event.accept(ItemInit.FLAX_STRING);
            event.accept(ItemInit.LINEN_STRING);
            event.accept(ItemInit.SHORT_BOW);
            event.accept(ItemInit.RECURVE_BOW);
            event.accept(ItemInit.FLAT_BOW);
            event.accept(ItemInit.LONG_BOW);
            event.accept(ItemInit.PISTOL_CROSSBOW);
            event.accept(ItemInit.HEAVY_CROSSBOW);
            event.accept(ItemInit.ARBALEST);

        }
        if (event.getTab() == CreativeModeTabs.COMBAT) {
            event.accept(ItemInit.SHORT_BOW);
            event.accept(ItemInit.RECURVE_BOW);
            event.accept(ItemInit.FLAT_BOW);
            event.accept(ItemInit.LONG_BOW);
            event.accept(ItemInit.PISTOL_CROSSBOW);
            event.accept(ItemInit.HEAVY_CROSSBOW);
            event.accept(ItemInit.ARBALEST);

        }
        if (event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ItemInit.FLAX_STRING);
            event.accept(ItemInit.LINEN_STRING);
            event.accept(ItemInit.FLAX);

        }
        if (event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(BlockInit.WILD_FLAX);
            event.accept(BlockInit.WILD_FLAX2);
            event.accept(ItemInit.FLAX_SEEDS);

        }

    }



    private void clientSetup(final FMLClientSetupEvent event) {
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(CompostablesInit::init);

    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent evt) {
        LOGGER.debug("Debug Log.");
        LOGGER.error("Error Log.");


    }
}
