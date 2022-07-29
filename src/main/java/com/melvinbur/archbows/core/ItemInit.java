package com.melvinbur.archbows.core;

import com.melvinbur.archbows.ArchBows;


import com.melvinbur.archbows.common.bow.*;

import net.minecraft.world.item.Item;

import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Tiers;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ArchBows.MOD_ID);

    public static final RegistryObject<Item> FLAX_FIBER = ITEMS.register("flax_fiber",
            () -> new Item(new Item.Properties().tab(CreativeModeTabInit.ARCHBOWS_TAB)));

    public static final RegistryObject<Item> FLAX_STRING= ITEMS.register("flax_string",
            () -> new Item(new Item.Properties().tab(CreativeModeTabInit.ARCHBOWS_TAB)));

    public static final RegistryObject<Item> LINEN_STRING = ITEMS.register("linen_string",
            () -> new Item(new Item.Properties().tab(CreativeModeTabInit.ARCHBOWS_TAB)));
    public static final RegistryObject<Item> FLAX_SEEDS = ITEMS.register("flax_seeds",
            () -> new ItemNameBlockItem(BlockInit.FLAX_CROP.get(),
                    new Item.Properties().tab(CreativeModeTabInit.ARCHBOWS_TAB)));








    /**
     * Longbow = base range 41 - base drawspeed 45 - durability 460
     * Flatbow = base range 30 - base drawspeed 34 - durability 435
     * Recurvebow = base range 23 - base drawspeed 25 - durability 410
     * Bow = base range 15 - base drawspeed 20 - durability 385
     * Shortbow = base range 7 - base drawspeed 10 - durability 360
     * Crossbow = base range 8 - base drawspeed 25 - durability 465
     * Arbalest = base range 14,5 - base drawspeed 28 - durability 465
     */

    //DrawSpeed - Range
    public static final RegistryObject<ArchLongbowItem> LONG_BOW  = ITEMS.register("longbow",
            () -> new ArchLongbowItem(Tiers.WOOD, new Item.Properties().tab(CreativeModeTabInit.ARCHBOWS_TAB).stacksTo(1).durability(460), 45, 41f));

    public static final RegistryObject<ArchBowItem> RECURVE_BOW = ITEMS.register("recurve",
            () -> new ArchBowItem(Tiers.WOOD, new Item.Properties().tab(CreativeModeTabInit.ARCHBOWS_TAB).stacksTo(1).durability(410), 25, 23f));

    public static final RegistryObject<ArchShortbowItem> SHORT_BOW = ITEMS.register("shortbow",
            () -> new ArchShortbowItem(Tiers.WOOD, new Item.Properties().tab(CreativeModeTabInit.ARCHBOWS_TAB).stacksTo(1).durability(360), 10, 7f));

    public static final RegistryObject<ArchFlatbowItem> FLAT_BOW = ITEMS.register("flatbow",
            () -> new ArchFlatbowItem(Tiers.WOOD, new Item.Properties().tab(CreativeModeTabInit.ARCHBOWS_TAB).stacksTo(1).durability(435), 34, 30f));

    public static final RegistryObject<ArchCrossbowItem> ARBALEST = ITEMS.register("arbalest",
            () -> new ArchCrossbowItem(Tiers.WOOD, new Item.Properties().tab(CreativeModeTabInit.ARCHBOWS_TAB).stacksTo(1).durability(495), 28, 14.5f));





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}


