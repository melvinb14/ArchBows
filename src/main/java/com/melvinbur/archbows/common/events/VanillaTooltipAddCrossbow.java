package com.melvinbur.archbows.common.events;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber
public class VanillaTooltipAddCrossbow {

    public static float LOADTICKS = 1.0F;

    public static float RANGE_VELOCITY = 1.0F;

    @SubscribeEvent
    public static void addTooltip(ItemTooltipEvent itemTooltipEvent) {
        if (itemTooltipEvent.getItemStack().getItem() == Items.CROSSBOW) {
               itemTooltipEvent.getToolTip().add(new TextComponent(""));
               itemTooltipEvent.getToolTip().add((new TranslatableComponent(String.format("tooltip.archbows.modifiers.crossbow.load_time", "archbows"), (new TranslatableComponent(String.format("tooltip.archbows.modifiers.crossbow.load_time.value", "archbows"), LOADTICKS)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
                itemTooltipEvent.getToolTip().add((new TranslatableComponent(String.format("tooltip.archbows.modifiers.speed_multiplier", "archbows"), (new TranslatableComponent(String.format("tooltip.archbows.modifiers.speed_multiplier.value", "archbows"), RANGE_VELOCITY)).withStyle(ChatFormatting.DARK_GREEN))).withStyle(ChatFormatting.DARK_GREEN));
            }
        }
    }



