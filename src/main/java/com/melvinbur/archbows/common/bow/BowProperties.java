package com.melvinbur.archbows.common.bow;



import com.melvinbur.archbows.core.ItemInit;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.world.item.Items;


public class BowProperties  {
    public static void addCustomItemProperties() {
        registerLongBowProperties(ItemInit.LONG_BOW.get());
        registerBowProperties(ItemInit.RECURVE_BOW.get());
        registerShortBowProperties(ItemInit.SHORT_BOW.get());
        registerFlatBowProperties(ItemInit.FLAT_BOW.get());
        registerCrossbowProperties(ItemInit.ARBALEST.get());
    }



    public static void registerBowProperties(ArchBowItem bow)  {
        ItemProperties.register(bow, new ResourceLocation("pull"),(bowItem, level, playerEntity, integer) -> {
            if (playerEntity == null) {
                return 0.0F;
            } else {
                int useTicks = bowItem.getUseDuration() - playerEntity.getUseItemRemainingTicks();
                return playerEntity.getUseItem() != bowItem ? 0.0F :
                        (float)(useTicks) / bow.getDrawSpeed();
            }
        });

        ItemProperties.register(bow, new ResourceLocation("pulling"), (itemStack, clientLevel, livingEntity, integer) ->
                livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F);


    }

    public static void registerShortBowProperties(ArchShortbowItem bow) {
        ItemProperties.register(bow, new ResourceLocation("pull"),(bowItem, level, playerEntity, integer) -> {
            if (playerEntity == null) {
                return 0.0F;
            } else {
                int useTicks = bowItem.getUseDuration() - playerEntity.getUseItemRemainingTicks();
                return playerEntity.getUseItem() != bowItem ? 0.0F :
                        (float)(useTicks) / bow.getDrawSpeed();
            }
        });

        ItemProperties.register(bow, new ResourceLocation("pulling"), (itemStack, clientLevel, livingEntity, integer) ->
                livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F);
    }

    public static void registerLongBowProperties(ArchLongbowItem bow) {
        ItemProperties.register(bow, new ResourceLocation("pull"),(bowItem, level, playerEntity, integer) -> {
            if (playerEntity == null) {
                return 0.0F;
            } else {
                int useTicks = bowItem.getUseDuration() - playerEntity.getUseItemRemainingTicks();
                return playerEntity.getUseItem() != bowItem ? 0.0F :
                        (float)(useTicks) / bow.getDrawSpeed();
            }
        });

        ItemProperties.register(bow, new ResourceLocation("pulling"), (itemStack, clientLevel, livingEntity, integer) ->
                livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F);
    }

    public static void registerFlatBowProperties(ArchFlatbowItem bow) {
        ItemProperties.register(bow, new ResourceLocation("pull"),(bowItem, level, playerEntity, integer) -> {
            if (playerEntity == null) {
                return 0.0F;
            } else {
                int useTicks = bowItem.getUseDuration() - playerEntity.getUseItemRemainingTicks();
                return playerEntity.getUseItem() != bowItem ? 0.0F :
                        (float)(useTicks) / bow.getDrawSpeed();
            }
        });

        ItemProperties.register(bow, new ResourceLocation("pulling"), (itemStack, clientLevel, livingEntity, integer) ->
                livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F);


    }

    public static void registerCrossbowProperties(ArchCrossbowItem crossbow) {
        ItemProperties.register(crossbow, new ResourceLocation("pull"),(crossbowItem, level, playerEntity, integer) -> {
            if (playerEntity == null) {
                return 0.0F;
            } else {
                int useTicks = crossbowItem.getUseDuration() - playerEntity.getUseItemRemainingTicks();
                return ArchCrossbowItem.isCharged(crossbowItem) ? 0.0F :
                        (float) (useTicks) / (float)  ArchCrossbowItem.getChargeDuration(crossbowItem);
            }
        });

        ItemProperties.register(crossbow, new ResourceLocation("pulling"), (itemStack, clientLevel, livingEntity, integer) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack && !ArchCrossbowItem.isCharged(itemStack) ? 1.0F : 0.0F;
            }
        });

        ItemProperties.register(crossbow, new ResourceLocation("charged"), (itemStack, clientLevel, livingEntity, integer) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return ArchCrossbowItem.isCharged(itemStack) ? 1.0F : 0.0F;
            }
        });

        ItemProperties.register(crossbow, new ResourceLocation("firework"), (itemStack, clientLevel, livingEntity, integer) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return ArchCrossbowItem.isCharged(itemStack) && ArchCrossbowItem.containsChargedProjectile(itemStack,
                        Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
            }
        });
    }


}