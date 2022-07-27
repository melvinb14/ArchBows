package com.melvinbur.archbows.common.events;


import com.melvinbur.archbows.common.bow.ArchBowItem;
import com.melvinbur.archbows.common.bow.ArchFlatbowItem;
import com.melvinbur.archbows.common.bow.ArchLongbowItem;
import com.melvinbur.archbows.common.bow.ArchShortbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.FOVModifierEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
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
        if (event.getEntity().isUsingItem() && event.getEntity().getMainHandItem().getItem() instanceof ArchShortbowItem
        ) {
            float fovModifier = (float) event.getEntity().getTicksUsingItem() / ((ArchShortbowItem) event.getEntity().getMainHandItem().getItem()).getDrawSpeed();

            if (fovModifier > 1.0F) {
                fovModifier = 1.0F;
            } else {
                fovModifier *= fovModifier;
            }

            event.setNewfov(event.getFov() * (1.0F - fovModifier * 0.2F));

        }
        if (event.getEntity().isUsingItem() && event.getEntity().getMainHandItem().getItem() instanceof ArchLongbowItem
        ) {
            float fovModifier = (float) event.getEntity().getTicksUsingItem() / ((ArchLongbowItem) event.getEntity().getMainHandItem().getItem()).getDrawSpeed();

            if (fovModifier > 1.0F) {
                fovModifier = 1.0F;
            } else {
                fovModifier *= fovModifier;
            }

            event.setNewfov(event.getFov() * (1.0F - fovModifier * 0.2F));

        }
        if (event.getEntity().isUsingItem() && event.getEntity().getMainHandItem().getItem() instanceof ArchFlatbowItem
        ) {
            float fovModifier = (float) event.getEntity().getTicksUsingItem() / ((ArchFlatbowItem) event.getEntity().getMainHandItem().getItem()).getDrawSpeed();

            if (fovModifier > 1.0F) {
                fovModifier = 1.0F;
            } else {
                fovModifier *= fovModifier;
            }

            event.setNewfov(event.getFov() * (1.0F - fovModifier * 0.2F));

        }
        if (event.getEntity().isUsingItem() && event.getEntity().getMainHandItem().getItem() instanceof ArchBowItem
        ) {
            float fovModifier = (float) event.getEntity().getTicksUsingItem() / ((ArchBowItem) event.getEntity().getMainHandItem().getItem()).getDrawSpeed();

            if (fovModifier > 1.0F) {
                fovModifier = 1.0F;
            } else {
                fovModifier *= fovModifier;
            }

            event.setNewfov(event.getFov() * (1.0F - fovModifier * 0.2F));

        }


    }
}




