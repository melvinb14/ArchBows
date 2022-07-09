package com.melvinbur.archbows.common.events;

import com.melvinbur.archbows.common.bow.ArchFlatbowItem;
import com.melvinbur.archbows.core.ItemInit;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.FOVModifierEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class FOVevent {

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void getFieldOfViewModifier(FOVModifierEvent event) {
        LivingEntity livingEntity = event.getEntity();
        if (event.getEntity().isUsingItem() && event.getEntity().getUseItem().getItem() instanceof ArchFlatbowItem){
                {

                    int i = livingEntity.getTicksUsingItem();
                    float f1 = (float) i / 20.0F;
                    if (f1 > 1.0F) {
                        f1 = 1.0F;
                    } else {
                        f1 *= f1;
                    }

                    f1 *= 1.0F - f1 * 0.15F;

                    event.setNewfov(Mth.lerp(Minecraft.getInstance().options.fovEffectScale, 1.0F, f1));

                }
            }
        }
    }

