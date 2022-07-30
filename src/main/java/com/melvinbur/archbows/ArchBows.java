package com.melvinbur.archbows;


import com.melvinbur.archbows.common.bow.BowProperties;
import com.melvinbur.archbows.common.config.CommonConfigs;
import com.melvinbur.archbows.common.util.Logger;
import com.melvinbur.archbows.core.BlockInit;
import com.melvinbur.archbows.core.ItemInit;
import com.melvinbur.archbows.world.feature.BiomeModifiersInit;
import com.melvinbur.archbows.world.feature.PlacedFeaturesInit;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(ArchBows.MOD_ID)
public class ArchBows {
    public static final String MOD_ID = "archbows";







    // Directly reference a log4j logger.
    public static final Logger LOGGER = new Logger(MOD_ID);
    public ArchBows() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.register(eventBus);
        BlockInit.register(eventBus);
        BiomeModifiersInit.register(eventBus);
        PlacedFeaturesInit.register(eventBus);










      // ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, CommonConfigs.SERVER_SPEC, "archbows-common.toml");
        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }





    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent evt) {
        LOGGER.debug("Running common setup.");





    }







    private void clientSetup(final FMLClientSetupEvent event) {
        BowProperties.addCustomItemProperties();






    }


    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockInit.FLAX.getId(), BlockInit.POTTED_FLAX);

        });

    }
}
