package com.melvinbur.archbows;


import com.melvinbur.archbows.common.util.Logger;
import com.melvinbur.archbows.core.ItemInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
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
















        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

    // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
}


    @SubscribeEvent
    public static void onCommonSetup() {
        LOGGER.debug("Running common setup.");

    }




    private void clientSetup(final FMLClientSetupEvent event) {

    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

        });

    }
}
