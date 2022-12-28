package com.melvinbur.archbows.common.events;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.minecraft.world.item.BowItem.MAX_DRAW_DURATION;


@Mod.EventBusSubscriber
public class VanillaTooltipAddBow {


    private static final Object VELOCITY_RANGE = 1.0;

@SubscribeEvent
public static void addTooltip(ItemTooltipEvent itemTooltipEvent) {
    if (itemTooltipEvent.getItemStack().getItem() == Items.BOW) {

        itemTooltipEvent.getToolTip().add(Component.literal(""));
         itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.%s.modifiers.longbow.draw_length", "archbows"), (Component.translatable(String.format("tooltip.%s.modifiers.longbow.draw_length.value", "archbows"), (double) MAX_DRAW_DURATION / 20)).withStyle(ChatFormatting.GRAY))).withStyle(ChatFormatting.DARK_GREEN));
        itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.%s.modifiers.longbow.speed_multiplier", "archbows"), (Component.translatable(String.format("tooltip.%s.modifiers.longbow.draw_length.value", "archbows"), VELOCITY_RANGE)).withStyle(ChatFormatting.GRAY))).withStyle(ChatFormatting.DARK_GREEN));
        itemTooltipEvent.getToolTip().add(Component.literal(""));
        }
    }
}
