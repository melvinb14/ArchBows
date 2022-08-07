package com.melvinbur.archbows.common.events;




import com.melvinbur.archbows.common.bow.BaseBowItem;
import com.melvinbur.archbows.common.bow.FlatbowItem;
import com.melvinbur.archbows.common.bow.LongbowItem;
import com.melvinbur.archbows.common.bow.ShortbowItem;
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
        if (event.getPlayer().isUsingItem() && event.getPlayer().getMainHandItem().getItem() instanceof ShortbowItem
        ) {
            float fovModifier = (float) event.getPlayer().getTicksUsingItem() / ((ShortbowItem) event.getPlayer().getMainHandItem().getItem()).getDrawSpeed();

            if (fovModifier > 1.0F) {
                fovModifier = 1.0F;
            } else {
                fovModifier *= fovModifier;
            }

            event.setNewFovModifier(event.getFovModifier() * (1.0F - fovModifier * 0.2F));

        }
        if (event.getPlayer().isUsingItem() && event.getPlayer().getMainHandItem().getItem() instanceof LongbowItem
        ) {
            float fovModifier = (float) event.getPlayer().getTicksUsingItem() / ((LongbowItem) event.getPlayer().getMainHandItem().getItem()).getDrawSpeed();

            if (fovModifier > 1.0F) {
                fovModifier = 1.0F;
            } else {
                fovModifier *= fovModifier;
            }

            event.setNewFovModifier(event.getFovModifier() * (1.0F - fovModifier * 0.2F));

        }
        if (event.getPlayer().isUsingItem() && event.getPlayer().getMainHandItem().getItem() instanceof FlatbowItem
        ) {
            float fovModifier = (float) event.getPlayer().getTicksUsingItem() / ((FlatbowItem) event.getPlayer().getMainHandItem().getItem()).getDrawSpeed();

            if (fovModifier > 1.0F) {
                fovModifier = 1.0F;
            } else {
                fovModifier *= fovModifier;
            }

            event.setNewFovModifier(event.getFovModifier() * (1.0F - fovModifier * 0.2F));

        }
        if (event.getPlayer().isUsingItem() && event.getPlayer().getMainHandItem().getItem() instanceof BaseBowItem
        ) {
            float fovModifier = (float) event.getPlayer().getTicksUsingItem() / ((BaseBowItem) event.getPlayer().getMainHandItem().getItem()).getDrawSpeed();

            if (fovModifier > 1.0F) {
                fovModifier = 1.0F;
            } else {
                fovModifier *= fovModifier;
            }

            event.setNewFovModifier(event.getFovModifier() * (1.0F - fovModifier * 0.2F));

        }


    }
}




