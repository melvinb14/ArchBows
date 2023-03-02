package com.melvinbur.archbows.common.events;


import com.melvinbur.archbows.core.ItemInit;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.melvinbur.archbows.common.weapons.bow.FlatbowItem.drawSpeed;
import static com.melvinbur.archbows.common.weapons.bow.FlatbowItem.maxVelocity;


@Mod.EventBusSubscriber
public class TooltipAddFlatBow {

@SubscribeEvent
public static void addTooltip(ItemTooltipEvent itemTooltipEvent) {
    if (itemTooltipEvent.getItemStack().getItem() == ItemInit.FLAT_BOW.get()) {
        itemTooltipEvent.getToolTip().add(new TextComponent(""));
         itemTooltipEvent.getToolTip().add((new TranslatableComponent(String.format("tooltip.%s.modifiers.bow.draw_length", "archbows"), (new TranslatableComponent(String.format("tooltip.%s.modifiers.bow.draw_length.value", "archbows"), (double) drawSpeed / 20)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
        itemTooltipEvent.getToolTip().add((new TranslatableComponent(String.format("tooltip.%s.modifiers.speed_multiplier", "archbows"), (new TranslatableComponent(String.format("tooltip.%s.modifiers.speed_multiplier.value", "archbows"), maxVelocity)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
        }
    }
}
