package com.melvinbur.archbows.common.events;





import com.melvinbur.archbows.common.bow.ArchBowItem;


import com.melvinbur.archbows.common.bow.ArchFlatbowItem;
import com.melvinbur.archbows.common.bow.ArchLongbowItem;
import com.melvinbur.archbows.common.bow.ArchShortbowItem;

import net.minecraftforge.client.event.FOVModifierEvent;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(
        modid = "archbows"
)
public class FovEventHandler {
    public FovEventHandler() {
    }

    @SubscribeEvent
    public static void handleBowFOV(FOVModifierEvent event) {
        if (event.getEntity().isUsingItem() && event.getEntity().getMainHandItem().getItem() instanceof ArchBowItem
                || event.getEntity().isUsingItem() && event.getEntity().getMainHandItem().getItem() instanceof ArchLongbowItem
                || event.getEntity().isUsingItem() && event.getEntity().getMainHandItem().getItem() instanceof ArchFlatbowItem
                || event.getEntity().isUsingItem() && event.getEntity().getMainHandItem().getItem() instanceof ArchShortbowItem) {
            float fovModifier = (float) event.getEntity().getTicksUsingItem() / 20.0F;
            if (fovModifier > 1.0F) {
                fovModifier = 1.0F;
            } else {
                fovModifier *= fovModifier;
            }

            event.setNewfov(event.getFov() * (1.0F - fovModifier * 0.2F));
        }

    }

}


