package com.melvinbur.archbows;


import com.melvinbur.archbows.common.config.ABConfig;
import com.melvinbur.archbows.common.config.Config;
import com.melvinbur.archbows.common.util.Logger;
import com.melvinbur.archbows.core.BlockInit;
import com.melvinbur.archbows.core.CompostablesInit;
import com.melvinbur.archbows.core.ItemInit;
import com.melvinbur.archbows.world.ABBiomeModifiers;
import com.melvinbur.archbows.world.ABConfiguredFeatures;
import com.melvinbur.archbows.world.ABPlacements;
import net.minecraftforge.common.MinecraftForge;
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
@Mod.EventBusSubscriber(modid = ArchBows.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
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
        ABConfiguredFeatures.CONFIGURED_FEATURES.register(eventBus);
        ABPlacements.PLACED_FEATURES.register(eventBus);


        // EntityInit.ENTITY_TYPES.register(eventBus);

        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::clientSetup);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
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
