package com.melvinbur.archbows.common.events;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber
public class VanillaTooltipAddCrossbow {

    private static final Object LOADTICKS = 1.0;
    private static final Object AIMTICKS = 0.5;
    private static final Object RANGE_VELOCITY = 1.0;

    @SubscribeEvent
    public static void addTooltip(ItemTooltipEvent itemTooltipEvent) {
        if (itemTooltipEvent.getItemStack().getItem() == Items.CROSSBOW) {
               itemTooltipEvent.getToolTip().add(Component.literal(""));
               itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.archbows.modifiers.heavy_crossbow.load_time", "archbows"), (Component.translatable(String.format("tooltip.archbows.modifiers.heavy_crossbow.load_time.value", "archbows"), LOADTICKS)).withStyle(ChatFormatting.GRAY))).withStyle(ChatFormatting.DARK_GREEN));
                itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.archbows.modifiers.heavy_crossbow.aim_time", "archbows"), (Component.translatable(String.format("tooltip.archbows.modifiers.heavy_crossbow.aim_time.value", "archbows"), AIMTICKS)).withStyle(ChatFormatting.GRAY))).withStyle(ChatFormatting.DARK_GREEN));
                itemTooltipEvent.getToolTip().add((Component.translatable(String.format("tooltip.%s.modifiers.longbow.speed_multiplier", "archbows"), (Component.translatable(String.format("tooltip.%s.modifiers.longbow.draw_length.value", "archbows"), RANGE_VELOCITY)).withStyle(ChatFormatting.GRAY))).withStyle(ChatFormatting.DARK_GREEN));
                itemTooltipEvent.getToolTip().add(Component.literal(""));
            }
        }
    }



