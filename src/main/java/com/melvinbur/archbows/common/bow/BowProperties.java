package com.melvinbur.archbows.common.bow;


import com.melvinbur.archbows.core.ItemInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;


public class BowProperties  {
    public static void addCustomItemProperties() {
        registerLongBowPredicates(ItemInit.LONG_BOW.get());
        registerBowPredicates(ItemInit.RECURVE_BOW.get());
        registerShortBowPredicates(ItemInit.SHORT_BOW.get());
        registerFlatBowPredicates(ItemInit.FLAT_BOW.get());
    }



    public static void registerBowPredicates(ArchBowItem bow) {
        ItemProperties.register(bow, new ResourceLocation("pull"),(itemStack, clientWorld,
                                                                   livingEntity, seed) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                int useTicks = itemStack.getUseDuration() - livingEntity.getUseItemRemainingTicks();
                return livingEntity.getUseItem() != itemStack ? 0.0F :
                        (float)(useTicks) / bow.getDrawSpeed();
            }
        });

        ItemProperties.register(bow, new ResourceLocation("pulling"), (itemStack, clientWorld,
                                                                                 livingEntity, seed) ->
                livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F);
    }

    public static void registerShortBowPredicates(ArchShortbowItem bow) {
        ItemProperties.register(bow, new ResourceLocation("pull"),(itemStack, clientWorld,
                                                                             livingEntity, seed) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                int useTicks = itemStack.getUseDuration() - livingEntity.getUseItemRemainingTicks();
                return livingEntity.getUseItem() != itemStack ? 0.0F :
                        (float)(useTicks) / bow.getDrawSpeed();
            }
        });

        ItemProperties.register(bow, new ResourceLocation("pulling"), (itemStack, clientWorld,
                                                                                 livingEntity, seed) ->
                livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F);
    }

    public static void registerLongBowPredicates(ArchLongbowItem bow) {
        ItemProperties.register(bow, new ResourceLocation("pull"),(itemStack, clientWorld,
                                                                             livingEntity, seed) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                int useTicks = itemStack.getUseDuration() - livingEntity.getUseItemRemainingTicks();
                return livingEntity.getUseItem() != itemStack ? 0.0F :
                        (float)(useTicks) / bow.getDrawSpeed();
            }
        });

        ItemProperties.register(bow, new ResourceLocation("pulling"), (itemStack, clientWorld,
                                                                                 livingEntity, seed) ->
                livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F);
    }

    public static void registerFlatBowPredicates(ArchFlatbowItem bow) {
        ItemProperties.register(bow, new ResourceLocation("pull"),(itemStack, clientWorld,
                                                                   livingEntity, seed) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                int useTicks = itemStack.getUseDuration() - livingEntity.getUseItemRemainingTicks();
                return livingEntity.getUseItem() != itemStack ? 0.0F :
                        (float)(useTicks) / bow.getDrawSpeed();
            }
        });

        ItemProperties.register(bow, new ResourceLocation("pulling"), (itemStack, clientWorld,
                                                                       livingEntity, seed) ->
                livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F);


    }

    public static void registerCrossbowPredicates(ArchCrossbowItem crossbow) {
        ItemProperties.register(crossbow, new ResourceLocation("pull"),(itemStack, clientWorld,
                                                                                  livingEntity, seed) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                int useTicks = itemStack.getUseDuration() - livingEntity.getUseItemRemainingTicks();
                return ArchCrossbowItem.isCharged(itemStack) ? 0.0F :
                        (float) (useTicks) / (float)  ArchCrossbowItem.getChargeDuration(itemStack);
            }
        });

        ItemProperties.register(crossbow, new ResourceLocation("pulling"), (itemStack, clientWorld,
                                                                                      livingEntity, seed) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack && !ArchCrossbowItem.isCharged(itemStack) ? 1.0F : 0.0F;
            }
        });

        ItemProperties.register(crossbow, new ResourceLocation("charged"), (itemStack, clientWorld,
                                                                                      livingEntity, seed) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return ArchCrossbowItem.isCharged(itemStack) ? 1.0F : 0.0F;
            }
        });

        ItemProperties.register(crossbow, new ResourceLocation("firework"), (itemStack, clientWorld,
                                                                                       livingEntity, seed) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return ArchCrossbowItem.isCharged(itemStack) && ArchCrossbowItem.containsChargedProjectile(itemStack,
                        Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
            }
        });
    }


}