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
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.ParametersAreNonnullByDefault;

import static net.minecraft.world.item.BowItem.MAX_DRAW_DURATION;


@OnlyIn(Dist.CLIENT)
@ParametersAreNonnullByDefault
@Mod.EventBusSubscriber(modid = ArchBows.MOD_ID, value = Dist.CLIENT)
public class ClientEventSubscriber {
    public static float basicVelocity = 3.0F;
    public static float LOADTICKS = 1.0F;

    public static float RANGE_VELOCITY = 3.15F;
    @SubscribeEvent
    public static void onFOVModifier(ComputeFovModifierEvent event) {
        Player player = event.getPlayer();
        if (player.isUsingItem()) {
            ItemStack useStack = player.getUseItem();
            Item useItem = useStack.getItem();
            if (useItem instanceof LongBowItem) {
                float f1 = player.getTicksUsingItem() / LongBowItem.drawSpeed;
                f1 = f1 > 1.0F ? 1.0F : (float) Math.pow(f1, 1.6D);
                event.setNewFovModifier(event.getFovModifier() * (1.0F - f1 * 0.2F));

            }
            if (useItem instanceof FlatBowItem) {
                float f1 = player.getTicksUsingItem() / FlatBowItem.drawSpeed;
                f1 = f1 > 1.0F ? 1.0F : (float) Math.pow(f1, 1.6D);
                event.setNewFovModifier(event.getFovModifier() * (1.0F - f1 * 0.2F));

            }
            if (useItem instanceof RecurveBowItem) {
                float f1 = player.getTicksUsingItem() / RecurveBowItem.drawSpeed;
                f1 = f1 > 1.0F ? 1.0F : (float) Math.pow(f1, 1.6D);
                event.setNewFovModifier(event.getFovModifier() * (1.0F - f1 * 0.2F));

            }
            if (useItem instanceof ShortBowItem) {
                float f1 = player.getTicksUsingItem() / ShortBowItem.drawSpeed;
                f1 = f1 > 1.0F ? 1.0F : (float) Math.pow(f1, 1.6D);
                event.setNewFovModifier(event.getFovModifier() * (1.0F - f1 * 0.2F));

            }
        }
    }

    @SubscribeEvent
    public static void addTooltip(ItemTooltipEvent itemTooltipEvent) {

        //Vanilla Crossbow
        if (itemTooltipEvent.getItemStack().getItem() == Items.CROSSBOW) {
            itemTooltipEvent.getToolTip().add(Component.literal(""));
            itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.archbows.modifiers.speed_multiplier", "archbows"), (Component.translatable(String.format("tooltip.archbows.modifiers.speed_multiplier.value", "archbows"), RANGE_VELOCITY)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
            itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.archbows.modifiers.crossbow.load_time", "archbows"), (Component.translatable(String.format("tooltip.archbows.modifiers.crossbow.load_time.value", "archbows"), LOADTICKS)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
        }

        //Crossbow
        if (itemTooltipEvent.getItemStack().getItem() == ItemInit.ARBALEST.get()) {
            itemTooltipEvent.getToolTip().add(Component.literal(""));
            itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.archbows.modifiers.speed_multiplier", "archbows"), (Component.translatable(String.format("tooltip.archbows.modifiers.speed_multiplier.value", "archbows"), ArbalestItem.maxVelocity)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
            itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.archbows.modifiers.crossbow.load_time", "archbows"), (Component.translatable(String.format("tooltip.archbows.modifiers.crossbow.load_time.value", "archbows"), (float) ArbalestItem.loadTime / 20)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
        }
        if (itemTooltipEvent.getItemStack().getItem() == ItemInit.HEAVY_CROSSBOW.get()) {
            itemTooltipEvent.getToolTip().add(Component.literal(""));
            itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.archbows.modifiers.speed_multiplier", "archbows"), (Component.translatable(String.format("tooltip.archbows.modifiers.speed_multiplier.value", "archbows"), HeavyCrossbowItem.maxVelocity)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
            itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.archbows.modifiers.crossbow.load_time", "archbows"), (Component.translatable(String.format("tooltip.archbows.modifiers.crossbow.load_time.value", "archbows"), (float) HeavyCrossbowItem.loadTime / 20)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
        }
        if (itemTooltipEvent.getItemStack().getItem() == ItemInit.PISTOL_CROSSBOW.get()) {
            itemTooltipEvent.getToolTip().add(Component.literal(""));
            itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.archbows.modifiers.speed_multiplier", "archbows"), (Component.translatable(String.format("tooltip.archbows.modifiers.speed_multiplier.value", "archbows"), PistolCrossbowItem.maxVelocity)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
            itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.archbows.modifiers.crossbow.load_time", "archbows"), (Component.translatable(String.format("tooltip.archbows.modifiers.crossbow.load_time.value", "archbows"), (float) PistolCrossbowItem.loadTime / 20)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
        }

        //Vanilla Bow
        if (itemTooltipEvent.getItemStack().getItem() == Items.BOW) {
            itemTooltipEvent.getToolTip().add(Component.literal(""));
            itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.%s.modifiers.speed_multiplier", "archbows"), (Component.translatable(String.format("tooltip.%s.modifiers.speed_multiplier.value", "archbows"), basicVelocity)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
            itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.%s.modifiers.bow.draw_length", "archbows"), (Component.translatable(String.format("tooltip.%s.modifiers.bow.draw_length.value", "archbows"),  MAX_DRAW_DURATION / 20)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
        }


        //Bows
        if (itemTooltipEvent.getItemStack().getItem() == ItemInit.LONG_BOW.get()) {
            itemTooltipEvent.getToolTip().add(Component.literal(""));
            itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.%s.modifiers.speed_multiplier", "archbows"), (Component.translatable(String.format("tooltip.%s.modifiers.speed_multiplier.value", "archbows"), LongBowItem.maxVelocity)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
            itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.%s.modifiers.bow.draw_length", "archbows"), (Component.translatable(String.format("tooltip.%s.modifiers.bow.draw_length.value", "archbows"), LongBowItem.drawSpeed / 20)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
        }
        if (itemTooltipEvent.getItemStack().getItem() == ItemInit.FLAT_BOW.get()) {
            itemTooltipEvent.getToolTip().add(Component.literal(""));
            itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.%s.modifiers.speed_multiplier", "archbows"), (Component.translatable(String.format("tooltip.%s.modifiers.speed_multiplier.value", "archbows"), FlatBowItem.maxVelocity)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
            itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.%s.modifiers.bow.draw_length", "archbows"), (Component.translatable(String.format("tooltip.%s.modifiers.bow.draw_length.value", "archbows"), FlatBowItem.drawSpeed / 20)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
        }
        if (itemTooltipEvent.getItemStack().getItem() == ItemInit.RECURVE_BOW.get()) {
            itemTooltipEvent.getToolTip().add(Component.literal(""));
            itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.%s.modifiers.speed_multiplier", "archbows"), (Component.translatable(String.format("tooltip.%s.modifiers.speed_multiplier.value", "archbows"), RecurveBowItem.maxVelocity)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
            itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.%s.modifiers.bow.draw_length", "archbows"), (Component.translatable(String.format("tooltip.%s.modifiers.bow.draw_length.value", "archbows"), RecurveBowItem.drawSpeed / 20)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
        }
        if (itemTooltipEvent.getItemStack().getItem() == ItemInit.SHORT_BOW.get()) {
            itemTooltipEvent.getToolTip().add(Component.literal(""));
            itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.%s.modifiers.speed_multiplier", "archbows"), (Component.translatable(String.format("tooltip.%s.modifiers.speed_multiplier.value", "archbows"), ShortBowItem.maxVelocity)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
            itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.%s.modifiers.bow.draw_length", "archbows"), (Component.translatable(String.format("tooltip.%s.modifiers.bow.draw_length.value", "archbows"), ShortBowItem.drawSpeed / 20)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
        }
    }
}