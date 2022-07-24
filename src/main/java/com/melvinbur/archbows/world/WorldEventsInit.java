package com.melvinbur.archbows.world;

import com.melvinbur.archbows.ArchBows;
import com.melvinbur.archbows.world.gen.FlowerGenerationInit;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ArchBows.MOD_ID)
public class WorldEventsInit {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {

        FlowerGenerationInit.generateFlowers(event);

    }
}