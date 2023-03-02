package com.melvinbur.archbows.common.weapons.crossbow;



import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.world.item.Items;


public class CrossbowProperties {



    public static void registerArbalestProperties(ArbalestItem crossbow) {
        ItemProperties.register(crossbow, new ResourceLocation("pull"),(crossbowItem, level, playerEntity, integer) -> {
            if (playerEntity == null) {
                return 0.0F;
            } else {
                int useTicks = crossbowItem.getUseDuration() - playerEntity.getUseItemRemainingTicks();
                return ArbalestItem.isCharged(crossbowItem) ? 0.0F :
                        (float) (useTicks) / (float)  ArbalestItem.getChargeDuration(crossbowItem);
            }
        });

        ItemProperties.register(crossbow, new ResourceLocation("pulling"), (itemStack, clientLevel, livingEntity, integer) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack && !ArbalestItem.isCharged(itemStack) ? 1.0F : 0.0F;
            }
        });

        ItemProperties.register(crossbow, new ResourceLocation("charged"), (itemStack, clientLevel, livingEntity, integer) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return ArbalestItem.isCharged(itemStack) ? 1.0F : 0.0F;
            }
        });

        ItemProperties.register(crossbow, new ResourceLocation("firework"), (itemStack, clientLevel, livingEntity, integer) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return ArbalestItem.isCharged(itemStack) && ArbalestItem.containsChargedProjectile(itemStack,
                        Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
            }
        });
    }

    public static void registerHeavyCrossbowProperties(HeavyCrossbowItem crossbow) {
        ItemProperties.register(crossbow, new ResourceLocation("pull"),(crossbowItem, level, playerEntity, integer) -> {
            if (playerEntity == null) {
                return 0.0F;
            } else {
                int useTicks = crossbowItem.getUseDuration() - playerEntity.getUseItemRemainingTicks();
                return HeavyCrossbowItem.isCharged(crossbowItem) ? 0.0F :
                        (float) (useTicks) / (float)  HeavyCrossbowItem.getChargeDuration(crossbowItem);
            }
        });

        ItemProperties.register(crossbow, new ResourceLocation("pulling"), (itemStack, clientLevel, livingEntity, integer) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack && !HeavyCrossbowItem.isCharged(itemStack) ? 1.0F : 0.0F;
            }
        });

        ItemProperties.register(crossbow, new ResourceLocation("charged"), (itemStack, clientLevel, livingEntity, integer) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return HeavyCrossbowItem.isCharged(itemStack) ? 1.0F : 0.0F;
            }
        });

        ItemProperties.register(crossbow, new ResourceLocation("firework"), (itemStack, clientLevel, livingEntity, integer) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return HeavyCrossbowItem.isCharged(itemStack) && HeavyCrossbowItem.containsChargedProjectile(itemStack,
                        Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
            }
        });
    }

    public static void registerPistolCrossbowProperties(PistolCrossbowItem crossbow) {
        ItemProperties.register(crossbow, new ResourceLocation("pull"),(crossbowItem, level, playerEntity, integer) -> {
            if (playerEntity == null) {
                return 0.0F;
            } else {
                int useTicks = crossbowItem.getUseDuration() - playerEntity.getUseItemRemainingTicks();
                return PistolCrossbowItem.isCharged(crossbowItem) ? 0.0F :
                        (float) (useTicks) / (float)  PistolCrossbowItem.getChargeDuration(crossbowItem);
            }
        });

        ItemProperties.register(crossbow, new ResourceLocation("pulling"), (itemStack, clientLevel, livingEntity, integer) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack && !PistolCrossbowItem.isCharged(itemStack) ? 1.0F : 0.0F;
            }
        });

        ItemProperties.register(crossbow, new ResourceLocation("charged"), (itemStack, clientLevel, livingEntity, integer) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return PistolCrossbowItem.isCharged(itemStack) ? 1.0F : 0.0F;
            }
        });

        ItemProperties.register(crossbow, new ResourceLocation("firework"), (itemStack, clientLevel, livingEntity, integer) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return PistolCrossbowItem.isCharged(itemStack) && PistolCrossbowItem.containsChargedProjectile(itemStack,
                        Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
            }
        });
    }




}