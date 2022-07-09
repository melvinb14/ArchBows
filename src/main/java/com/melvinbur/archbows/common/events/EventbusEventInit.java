package com.melvinbur.archbows.common.events;


import com.melvinbur.archbows.ArchBows;
import com.melvinbur.archbows.common.events.loot.TwigFromLeavesAdditionModifier;
import com.melvinbur.archbows.core.ItemInit;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraftforge.client.event.FOVModifierEvent;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = ArchBows.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventbusEventInit {

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                           event) {
        event.getRegistry().registerAll(
                new TwigFromLeavesAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(ArchBows.MOD_ID, "twig_from_leaves"))

        );
    }
}



