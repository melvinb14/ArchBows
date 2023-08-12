package com.melvinbur.archbows.common.events;

import com.melvinbur.archbows.ArchBows;
import com.melvinbur.archbows.common.weapons.bow.FlatBowItem;
import com.melvinbur.archbows.common.weapons.bow.LongBowItem;
import com.melvinbur.archbows.common.weapons.bow.RecurveBowItem;
import com.melvinbur.archbows.common.weapons.bow.ShortBowItem;
import com.melvinbur.archbows.common.weapons.crossbow.ArbalestItem;
import com.melvinbur.archbows.common.weapons.crossbow.HeavyCrossbowItem;
import com.melvinbur.archbows.common.weapons.crossbow.PistolCrossbowItem;
import com.melvinbur.archbows.core.ItemInit;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import javax.annotation.ParametersAreNonnullByDefault;

import static net.minecraft.world.item.BowItem.MAX_DRAW_DURATION;


@OnlyIn(Dist.CLIENT)
@ParametersAreNonnullByDefault
@Mod.EventBusSubscriber(modid = ArchBows.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ArchBows.LOGGER.debug("Running client setup.");

        //Bows
        ItemProperties.register(ItemInit.LONG_BOW.get(), new ResourceLocation("pull"), (stack, clientLevel, living, k) ->
                living == null ? 0F : (living.getUseItem() != stack ? 0.0F : (float) (stack.getUseDuration() - living.getUseItemRemainingTicks()) / LongBowItem.drawSpeed));
        ItemProperties.register(ItemInit.LONG_BOW.get(), new ResourceLocation("pulling"), (stack, clientLevel, living, k) ->
                living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0F : 0.0F);

        ItemProperties.register(ItemInit.FLAT_BOW.get(), new ResourceLocation("pull"), (stack, clientLevel, living, k) ->
                living == null ? 0F : (living.getUseItem() != stack ? 0.0F : (float) (stack.getUseDuration() - living.getUseItemRemainingTicks()) / FlatBowItem.drawSpeed));
        ItemProperties.register(ItemInit.FLAT_BOW.get(), new ResourceLocation("pulling"), (stack, clientLevel, living, k) ->
                living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0F : 0.0F);

        ItemProperties.register(ItemInit.RECURVE_BOW.get(), new ResourceLocation("pull"), (stack, clientLevel, living, k) ->
                living == null ? 0F : (living.getUseItem() != stack ? 0.0F : (float) (stack.getUseDuration() - living.getUseItemRemainingTicks()) / RecurveBowItem.drawSpeed));
        ItemProperties.register(ItemInit.RECURVE_BOW.get(), new ResourceLocation("pulling"), (stack, clientLevel, living, k) ->
                living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0F : 0.0F);

        ItemProperties.register(ItemInit.SHORT_BOW.get(), new ResourceLocation("pull"), (stack, clientLevel, living, k) ->
                living == null ? 0F : (living.getUseItem() != stack ? 0.0F : (float) (stack.getUseDuration() - living.getUseItemRemainingTicks()) / ShortBowItem.drawSpeed));
        ItemProperties.register(ItemInit.SHORT_BOW.get(), new ResourceLocation("pulling"), (stack, clientLevel, living, k) ->
                living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0F : 0.0F);

        //Crossbows
        ItemProperties.register(ItemInit.ARBALEST.get(), new ResourceLocation("pull"), (stack, clientLevel, living, k) -> {
            if (living == null) {
                return 0.0F;
            } else {
                return ArbalestItem.isCharged(stack) ? 0.0F : (float) (stack.getUseDuration() - living.getUseItemRemainingTicks()) / (float) ArbalestItem.getChargeDuration(stack);
            }
        });
        ItemProperties.register(ItemInit.ARBALEST.get(), new ResourceLocation("pulling"), (stack, clientLevel, living, k) -> living != null && living.isUsingItem() && living.getUseItem() == stack && !ArbalestItem.isCharged(stack) ? 1.0F : 0.0F);
        ItemProperties.register(ItemInit.ARBALEST.get(), new ResourceLocation("charged"), (stack, clientLevel, living, k) -> living != null && ArbalestItem.isCharged(stack) ? 1.0F : 0.0F);
        ItemProperties.register(ItemInit.ARBALEST.get(), new ResourceLocation("firework"), (stack, clientLevel, living, k) -> living != null && ArbalestItem.isCharged(stack) && ArbalestItem.containsChargedProjectile(stack, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F);

        ItemProperties.register(ItemInit.HEAVY_CROSSBOW.get(), new ResourceLocation("pull"), (stack, clientLevel, living, k) -> {
            if (living == null) {
                return 0.0F;
            } else {
                return HeavyCrossbowItem.isCharged(stack) ? 0.0F : (float) (stack.getUseDuration() - living.getUseItemRemainingTicks()) / (float) HeavyCrossbowItem.getChargeDuration(stack);
            }
        });
        ItemProperties.register(ItemInit.HEAVY_CROSSBOW.get(), new ResourceLocation("pulling"), (stack, clientLevel, living, k) -> living != null && living.isUsingItem() && living.getUseItem() == stack && !HeavyCrossbowItem.isCharged(stack) ? 1.0F : 0.0F);
        ItemProperties.register(ItemInit.HEAVY_CROSSBOW.get(), new ResourceLocation("charged"), (stack, clientLevel, living, k) -> living != null && HeavyCrossbowItem.isCharged(stack) ? 1.0F : 0.0F);
        ItemProperties.register(ItemInit.HEAVY_CROSSBOW.get(), new ResourceLocation("firework"), (stack, clientLevel, living, k) -> living != null && HeavyCrossbowItem.isCharged(stack) && HeavyCrossbowItem.containsChargedProjectile(stack, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F);

        ItemProperties.register(ItemInit.PISTOL_CROSSBOW.get(), new ResourceLocation("pull"), (stack, clientLevel, living, k) -> {
            if (living == null) {
                return 0.0F;
            } else {
                return PistolCrossbowItem.isCharged(stack) ? 0.0F : (float) (stack.getUseDuration() - living.getUseItemRemainingTicks()) / (float) PistolCrossbowItem.getChargeDuration(stack);
            }
        });
        ItemProperties.register(ItemInit.PISTOL_CROSSBOW.get(), new ResourceLocation("pulling"), (stack, clientLevel, living, k) -> living != null && living.isUsingItem() && living.getUseItem() == stack && !PistolCrossbowItem.isCharged(stack) ? 1.0F : 0.0F);
        ItemProperties.register(ItemInit.PISTOL_CROSSBOW.get(), new ResourceLocation("charged"), (stack, clientLevel, living, k) -> living != null && PistolCrossbowItem.isCharged(stack) ? 1.0F : 0.0F);
        ItemProperties.register(ItemInit.PISTOL_CROSSBOW.get(), new ResourceLocation("firework"), (stack, clientLevel, living, k) -> living != null && PistolCrossbowItem.isCharged(stack) && PistolCrossbowItem.containsChargedProjectile(stack, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F);

    }

}
