package com.melvinbur.archbows.core;

import com.melvinbur.archbows.ArchBows;


import com.melvinbur.archbows.common.config.ABConfig;


import com.melvinbur.archbows.common.weapons.bow.FlatBowItem;
import com.melvinbur.archbows.common.weapons.bow.LongBowItem;
import com.melvinbur.archbows.common.weapons.bow.RecurveBowItem;
import com.melvinbur.archbows.common.weapons.bow.ShortBowItem;
import com.melvinbur.archbows.common.weapons.crossbow.ArbalestItem;
import com.melvinbur.archbows.common.weapons.crossbow.HeavyCrossbowItem;
import com.melvinbur.archbows.common.weapons.crossbow.PistolCrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


import static net.minecraft.world.item.Tiers.WOOD;

public class ItemInit {



    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ArchBows.MOD_ID);

    //Bows
    public static final RegistryObject<Item> SHORT_BOW = ITEMS.register("shortbow",
            () -> new ShortBowItem(new Item.Properties().stacksTo(1).durability(ABConfig.CONFIG.shortBowDurability.get()), ABConfig.CONFIG.shortbowDrawspeed.get().floatValue(),  ABConfig.CONFIG.ShortBowProjectileVelocity.get().floatValue(), WOOD));
    public static final RegistryObject<Item> RECURVE_BOW = ITEMS.register("recurve",
            () -> new RecurveBowItem(new Item.Properties().stacksTo(1).durability(ABConfig.CONFIG.recurveBowDurability.get()),ABConfig.CONFIG.recurvebowDrawspeed.get().floatValue(),  ABConfig.CONFIG.RecurveBowProjectileVelocity.get().floatValue(), WOOD));

    public static final RegistryObject<Item> FLAT_BOW = ITEMS.register("flatbow",
            () -> new FlatBowItem(new Item.Properties().stacksTo(1).durability(ABConfig.CONFIG.flatBowDurability.get()),ABConfig.CONFIG.flatbowDrawspeed.get().floatValue(),  ABConfig.CONFIG.FlatBowProjectileVelocity.get().floatValue(), WOOD));

    public static final RegistryObject<Item> LONG_BOW  = ITEMS.register("longbow",
            () -> new LongBowItem(new Item.Properties().stacksTo(1).durability(ABConfig.CONFIG.longBowDurability.get()),ABConfig.CONFIG.longbowDrawspeed.get().floatValue(),  ABConfig.CONFIG.LongBowProjectileVelocity.get().floatValue(), WOOD));


    //Crossbows

    public static final RegistryObject<ArbalestItem> ARBALEST = ITEMS.register("arbalest",
            () -> new ArbalestItem(new Item.Properties().stacksTo(1).durability(ABConfig.CONFIG.arbalestDurability.get()),ABConfig.CONFIG.ArbalestProjectileVelocity.get().floatValue(),ABConfig.CONFIG.arbalestLoadTime.get(), WOOD));

    public static final RegistryObject<HeavyCrossbowItem> HEAVY_CROSSBOW = ITEMS.register("heavy_crossbow",
            () -> new HeavyCrossbowItem(new Item.Properties().stacksTo(1).durability(ABConfig.CONFIG.heavyCrossbowDurability.get()), ABConfig.CONFIG.HeavyCrossbowProjectileVelocity.get().floatValue(),ABConfig.CONFIG.heavycrossbowLoadTime.get(), WOOD));


    public static final RegistryObject<PistolCrossbowItem> PISTOL_CROSSBOW = ITEMS.register("pistol_crossbow",
            () -> new PistolCrossbowItem(new Item.Properties().stacksTo(1).durability(ABConfig.CONFIG.pistolCrossbowDurability.get()),ABConfig.CONFIG.PistolCrossbowProjectileVelocity.get().floatValue(),ABConfig.CONFIG.pistolcrossbowLoadTime.get(), WOOD));



    //Items
    public static final RegistryObject<Item> FLAX_STRING= ITEMS.register("flax_string",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LINEN_STRING = ITEMS.register("linen_string",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FLAX = ITEMS.register("flax",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FLAX_SEEDS = ITEMS.register("flax_seeds",
            () -> new ItemNameBlockItem(BlockInit.FLAX.get(),
                    new Item.Properties()));










    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}


