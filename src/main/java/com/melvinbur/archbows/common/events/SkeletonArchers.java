package com.melvinbur.archbows.common.events;



import com.melvinbur.archbows.core.ItemInit;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.AbstractSkeleton;

import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Stray;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
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
    public static void giveWeapon(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof AbstractSkeleton) {
            AbstractSkeleton skeleton = (AbstractSkeleton) event.getEntity();
            int i = eventRand.nextInt(100);
            if (skeleton instanceof Skeleton || skeleton instanceof Stray && skeleton.getItemBySlot(EquipmentSlot.MAINHAND).getItem() == Items.BOW) {
                if (i < 20) {
                    if (i < 10) {
                        skeleton.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ItemInit.SHORT_BOW.get()));
                    } else {
                        skeleton.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ItemInit.RECURVE_BOW.get()));
                    }
                }

                if (i > 20 && i < 30) {
                    skeleton.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ItemInit.LONG_BOW.get()));

                    }
                }

            }

        }



**/


}




