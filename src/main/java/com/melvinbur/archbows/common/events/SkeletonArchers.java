package com.melvinbur.archbows.common.events;


import net.minecraftforge.fml.common.Mod;

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




