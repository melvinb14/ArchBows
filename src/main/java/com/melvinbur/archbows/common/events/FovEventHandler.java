package com.melvinbur.archbows.common.events;


import com.melvinbur.archbows.common.bow.ArchBowItem;
import com.melvinbur.archbows.common.bow.ArchFlatbowItem;
import com.melvinbur.archbows.common.bow.ArchLongbowItem;
import com.melvinbur.archbows.common.bow.ArchShortbowItem;

import net.minecraftforge.client.event.ComputeFovModifierEvent;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(
        modid = "archbows"
)
public class FovEventHandler {
    public FovEventHandler() {
    }

    @SubscribeEvent
    public static void handleBowFOV(ComputeFovModifierEvent event) {
        if (event.getPlayer().isUsingItem() && event.getPlayer().getMainHandItem().getItem() instanceof ArchShortbowItem
        ) {
            float fovModifier = (float) event.getPlayer().getTicksUsingItem() / ((ArchShortbowItem) event.getPlayer().getMainHandItem().getItem()).getDrawSpeed();

            if (fovModifier > 1.0F) {
                fovModifier = 1.0F;
            } else {
                fovModifier *= fovModifier;
            }

            event.setNewFovModifier(event.getFovModifier() * (1.0F - fovModifier * 0.2F));

        }
        if (event.getPlayer().isUsingItem() && event.getPlayer().getMainHandItem().getItem() instanceof ArchLongbowItem
        ) {
            float fovModifier = (float) event.getPlayer().getTicksUsingItem() / ((ArchLongbowItem) event.getPlayer().getMainHandItem().getItem()).getDrawSpeed();

            if (fovModifier > 1.0F) {
                fovModifier = 1.0F;
            } else {
                fovModifier *= fovModifier;
            }

            event.setNewFovModifier(event.getFovModifier() * (1.0F - fovModifier * 0.2F));

        }
        if (event.getPlayer().isUsingItem() && event.getPlayer().getMainHandItem().getItem() instanceof ArchFlatbowItem
        ) {
            float fovModifier = (float) event.getPlayer().getTicksUsingItem() / ((ArchFlatbowItem) event.getPlayer().getMainHandItem().getItem()).getDrawSpeed();

            if (fovModifier > 1.0F) {
                fovModifier = 1.0F;
            } else {
                fovModifier *= fovModifier;
            }

            event.setNewFovModifier(event.getFovModifier() * (1.0F - fovModifier * 0.2F));

        }
        if (event.getPlayer().isUsingItem() && event.getPlayer().getMainHandItem().getItem() instanceof ArchBowItem
        ) {
            float fovModifier = (float) event.getPlayer().getTicksUsingItem() / ((ArchBowItem) event.getPlayer().getMainHandItem().getItem()).getDrawSpeed();

            if (fovModifier > 1.0F) {
                fovModifier = 1.0F;
            } else {
                fovModifier *= fovModifier;
            }

            event.setNewFovModifier(event.getFovModifier() * (1.0F - fovModifier * 0.2F));

        }


    }
}




