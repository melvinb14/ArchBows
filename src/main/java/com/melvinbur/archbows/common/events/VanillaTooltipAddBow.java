package com.melvinbur.archbows.common.events;


import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


import static net.minecraft.world.item.BowItem.MAX_DRAW_DURATION;


@Mod.EventBusSubscriber
public class VanillaTooltipAddBow {


    public static float basicVelocity = 1.0F;

@SubscribeEvent
public static void addTooltip(ItemTooltipEvent itemTooltipEvent) {
    if (itemTooltipEvent.getItemStack().getItem() == Items.BOW) {
        itemTooltipEvent.getToolTip().add(Component.literal(""));
         itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.%s.modifiers.bow.draw_length", "archbows"), (Component.translatable(String.format("tooltip.%s.modifiers.bow.draw_length.value", "archbows"), (double) MAX_DRAW_DURATION / 20)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
        itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.%s.modifiers.speed_multiplier", "archbows"), (Component.translatable(String.format("tooltip.%s.modifiers.speed_multiplier.value", "archbows"), basicVelocity)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
        }
    }
}
