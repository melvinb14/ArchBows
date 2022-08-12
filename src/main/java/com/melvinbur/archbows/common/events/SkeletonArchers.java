package com.melvinbur.archbows.common.events;


import com.melvinbur.archbows.core.ItemInit;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Stray;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber
public class SkeletonArchers  {/**
    protected static Random eventRand = new Random();


    public SkeletonArchers() {
        super();
    }
    @SubscribeEvent
    public static void giveWeapon(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof AbstractSkeleton) {
            AbstractSkeleton skeleton = (AbstractSkeleton) event.getEntity();
            int i = eventRand.nextInt(100);
            if (skeleton instanceof Skeleton || skeleton instanceof Stray && skeleton.getItemBySlot(EquipmentSlot.MAINHAND).getItem() == Items.BOW) {
                if (i < 20) {
                    if (i < 10) {
                        skeleton.setItemSlot(EquipmentSlot.MAINHAND, ItemInit.SHORT_BOW.get().getDefaultInstance());
                    } else {
                        skeleton.setItemSlot(EquipmentSlot.MAINHAND, ItemInit.RECURVE_BOW.get().getDefaultInstance());
                    }
                }

                if (i > 20 && i < 30) {
                    skeleton.setItemSlot(EquipmentSlot.MAINHAND, ItemInit.LONG_BOW.get().getDefaultInstance());

                    }
                }

            }

        }



**/


}




