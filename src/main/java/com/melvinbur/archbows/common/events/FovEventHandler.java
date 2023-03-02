package com.melvinbur.archbows.common.events;





import com.melvinbur.archbows.common.weapons.bow.*;


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
        if (event.getEntity().isUsingItem() && event.getEntity().getMainHandItem().getItem() instanceof ShortbowItem
        ) {
            float fovModifier = (float) event.getEntity().getTicksUsingItem() / ((ShortbowItem) event.getEntity().getMainHandItem().getItem()).getDrawSpeed();

            if (fovModifier > 1.0F) {
                fovModifier = 1.0F;
            } else {
                fovModifier *= fovModifier;
            }

            event.setNewfov(event.getFov() * (1.0F - fovModifier * 0.2F));

        }
        if (event.getEntity().isUsingItem() && event.getEntity().getMainHandItem().getItem() instanceof LongbowItem
        ) {
            float fovModifier = (float) event.getEntity().getTicksUsingItem() / ((LongbowItem) event.getEntity().getMainHandItem().getItem()).getDrawSpeed();

            if (fovModifier > 1.0F) {
                fovModifier = 1.0F;
            } else {
                fovModifier *= fovModifier;
            }

            event.setNewfov(event.getFov() * (1.0F - fovModifier * 0.2F));

        }
        if (event.getEntity().isUsingItem() && event.getEntity().getMainHandItem().getItem() instanceof FlatbowItem
        ) {
            float fovModifier = (float) event.getEntity().getTicksUsingItem() / ((FlatbowItem) event.getEntity().getMainHandItem().getItem()).getDrawSpeed();

            if (fovModifier > 1.0F) {
                fovModifier = 1.0F;
            } else {
                fovModifier *= fovModifier;
            }

            event.setNewfov(event.getFov() * (1.0F - fovModifier * 0.2F));

        }
        if (event.getEntity().isUsingItem() && event.getEntity().getMainHandItem().getItem() instanceof RecurvebowItem
        ) {
            float fovModifier = (float) event.getEntity().getTicksUsingItem() / ((RecurvebowItem) event.getEntity().getMainHandItem().getItem()).getDrawSpeed();

            if (fovModifier > 1.0F) {
                fovModifier = 1.0F;
            } else {
                fovModifier *= fovModifier;
            }

            event.setNewfov(event.getFov() * (1.0F - fovModifier * 0.2F));

        }
    }
}




