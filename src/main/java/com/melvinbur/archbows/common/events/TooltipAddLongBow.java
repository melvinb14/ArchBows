package com.melvinbur.archbows.common.events;


import com.melvinbur.archbows.core.ItemInit;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.melvinbur.archbows.common.weapons.bow.LongbowItem.drawSpeed;
import static com.melvinbur.archbows.common.weapons.bow.LongbowItem.maxVelocity;


@Mod.EventBusSubscriber
public class TooltipAddLongBow {

@SubscribeEvent
public static void addTooltip(ItemTooltipEvent itemTooltipEvent) {
    if (itemTooltipEvent.getItemStack().getItem() == ItemInit.LONG_BOW.get()) {
        itemTooltipEvent.getToolTip().add(Component.literal(""));
         itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.%s.modifiers.bow.draw_length", "archbows"), (Component.translatable(String.format("tooltip.%s.modifiers.bow.draw_length.value", "archbows"), (double) drawSpeed / 20)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
        itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.%s.modifiers.speed_multiplier", "archbows"), (Component.translatable(String.format("tooltip.%s.modifiers.speed_multiplier.value", "archbows"), maxVelocity)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
        }
    }
}
