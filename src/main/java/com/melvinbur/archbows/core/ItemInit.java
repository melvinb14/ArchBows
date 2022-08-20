package com.melvinbur.archbows.core;

import com.melvinbur.archbows.ArchBows;


import com.melvinbur.archbows.common.bow.*;

import com.melvinbur.archbows.common.config.ABConfig;
import net.minecraft.world.item.Item;

import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Tiers;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.item.Tiers.WOOD;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ArchBows.MOD_ID);

    //Bows
    public static final RegistryObject<ShortbowItem> SHORT_BOW = ITEMS.register("shortbow",
            () -> new ShortbowItem(new Item.Properties().tab(CreativeModeTabInit.ARCHBOWS_TAB).stacksTo(1).durability(ABConfig.CONFIG.shortBowDurability.get()), WOOD));
    public static final RegistryObject<BaseBowItem> RECURVE_BOW = ITEMS.register("recurve",
            () -> new BaseBowItem(new Item.Properties().tab(CreativeModeTabInit.ARCHBOWS_TAB).stacksTo(1).durability(ABConfig.CONFIG.recurveBowDurability.get()), WOOD));

    public static final RegistryObject<FlatbowItem> FLAT_BOW = ITEMS.register("flatbow",
            () -> new FlatbowItem(new Item.Properties().tab(CreativeModeTabInit.ARCHBOWS_TAB).stacksTo(1).durability(ABConfig.CONFIG.flatBowDurability.get()), WOOD));

    public static final RegistryObject<LongbowItem> LONG_BOW  = ITEMS.register("longbow",
            () -> new LongbowItem(new Item.Properties().tab(CreativeModeTabInit.ARCHBOWS_TAB).stacksTo(1).durability(ABConfig.CONFIG.longBowDurability.get()), WOOD));



    public static final RegistryObject<Item> FLAX_FIBER = ITEMS.register("flax_fiber",
            () -> new Item(new Item.Properties().tab(CreativeModeTabInit.ARCHBOWS_TAB)));

    public static final RegistryObject<Item> FLAX_STRING= ITEMS.register("flax_string",
            () -> new Item(new Item.Properties().tab(CreativeModeTabInit.ARCHBOWS_TAB)));

    public static final RegistryObject<Item> LINEN_STRING = ITEMS.register("linen_string",
            () -> new Item(new Item.Properties().tab(CreativeModeTabInit.ARCHBOWS_TAB)));
    public static final RegistryObject<Item> FLAX_SEEDS = ITEMS.register("flax_seeds",
            () -> new ItemNameBlockItem(BlockInit.FLAX_CROP.get(),
                    new Item.Properties().tab(CreativeModeTabInit.ARCHBOWS_TAB)));










    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}


