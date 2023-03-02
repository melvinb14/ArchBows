package com.melvinbur.archbows.common.weapons.bow;



import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;




public class BowProperties  {





        public static void registerRecurveBowProperties(RecurvebowItem bow)  {
            ItemProperties.register(bow, new ResourceLocation("pull"),(ItemStack, Level, LivingEntity, Int) -> {
                if (LivingEntity == null) {
                    return 0.0F;
                } else {
                    int useTicks = ItemStack.getUseDuration() - LivingEntity.getUseItemRemainingTicks();
                    return LivingEntity.getUseItem() != ItemStack ? 0.0F :
                            (float)(useTicks) / bow.getDrawSpeed();
                }
            });

            ItemProperties.register(bow, new ResourceLocation("pulling"), (ItemStack, Level, LivingEntity, Int) ->
                    LivingEntity != null && LivingEntity.isUsingItem() && LivingEntity.getUseItem() == ItemStack ? 1.0F : 0.0F);


        }


        public static void registerShortBowProperties(ShortbowItem bow) {
            ItemProperties.register(bow, new ResourceLocation("pull"),(ItemStack, Level, LivingEntity, Int) -> {
                if (LivingEntity == null) {
                    return 0.0F;
                } else {
                    int useTicks = ItemStack.getUseDuration() - LivingEntity.getUseItemRemainingTicks();
                    return LivingEntity.getUseItem() != ItemStack ? 0.0F :
                            (float)(useTicks) / bow.getDrawSpeed();
                }
            });

            ItemProperties.register(bow, new ResourceLocation("pulling"), (ItemStack, Level, LivingEntity, Int) ->
                    LivingEntity != null && LivingEntity.isUsingItem() && LivingEntity.getUseItem() == ItemStack ? 1.0F : 0.0F);


        }

        public static void registerLongBowProperties(LongbowItem bow) {
            ItemProperties.register(bow, new ResourceLocation("pull"),(ItemStack, Level, LivingEntity, Int) -> {
                if (LivingEntity == null) {
                    return 0.0F;
                } else {
                    int useTicks = ItemStack.getUseDuration() - LivingEntity.getUseItemRemainingTicks();
                    return LivingEntity.getUseItem() != ItemStack ? 0.0F :
                            (float)(useTicks) / bow.getDrawSpeed();
                }
            });

            ItemProperties.register(bow, new ResourceLocation("pulling"), (ItemStack, Level, LivingEntity, Int) ->
                    LivingEntity != null && LivingEntity.isUsingItem() && LivingEntity.getUseItem() == ItemStack ? 1.0F : 0.0F);


        }

        public static void registerFlatBowProperties(FlatbowItem bow) {
            ItemProperties.register(bow, new ResourceLocation("pull"),(ItemStack, Level, LivingEntity, Int) -> {
                if (LivingEntity == null) {
                    return 0.0F;
                } else {
                    int useTicks = ItemStack.getUseDuration() - LivingEntity.getUseItemRemainingTicks();
                    return LivingEntity.getUseItem() != ItemStack ? 0.0F :
                            (float)(useTicks) / bow.getDrawSpeed();
                }
            });

            ItemProperties.register(bow, new ResourceLocation("pulling"), (ItemStack, Level, LivingEntity, Int) ->
                    LivingEntity != null && LivingEntity.isUsingItem() && LivingEntity.getUseItem() == ItemStack ? 1.0F : 0.0F);


        }



    }