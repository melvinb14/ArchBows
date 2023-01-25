package com.melvinbur.archbows.core;

import com.melvinbur.archbows.ArchBows;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ArchBows.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeModeTabInit {
    public static CreativeModeTab ARCHBOWS_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        ARCHBOWS_TAB = event.registerCreativeModeTab(new ResourceLocation(ArchBows.MOD_ID, "archbowstab"),
                builder -> builder.icon(() -> new ItemStack(ItemInit.RECURVE_BOW.get())).title(Component.literal("Arch Bows")).build());
    }
}