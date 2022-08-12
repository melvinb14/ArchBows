package com.melvinbur.archbows.core;

import com.melvinbur.archbows.ArchBows;
import com.melvinbur.archbows.common.bow.*;
import com.melvinbur.archbows.common.config.ABConfig;
import com.melvinbur.archbows.common.test.TestCrossbow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.item.Tiers.IRON;
import static net.minecraft.world.item.Tiers.WOOD;

public class ItemInit {



    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ArchBows.MOD_ID);

    //Bows
    public static final RegistryObject<ShortbowItem> SHORT_BOW = ITEMS.register("shortbow",
            () -> new ShortbowItem(new Item.Properties().tab(CreativeModeTabInit.ARCHBOWS_TAB).stacksTo(1).durability(ABConfig.CONFIG.shortBowDurability.get()), WOOD, ABConfig.CONFIG.shortDrawspeed.get(), ABConfig.CONFIG.ShortBowProjectileVelocity.get()));
    public static final RegistryObject<BaseBowItem> RECURVE_BOW = ITEMS.register("recurve",
            () -> new BaseBowItem(new Item.Properties().tab(CreativeModeTabInit.ARCHBOWS_TAB).stacksTo(1).durability(ABConfig.CONFIG.recurveBowDurability.get()), WOOD, ABConfig.CONFIG.recurveDrawspeed.get(), ABConfig.CONFIG.RecurveBowProjectileVelocity.get()));

    public static final RegistryObject<FlatbowItem> FLAT_BOW = ITEMS.register("flatbow",
            () -> new FlatbowItem(new Item.Properties().tab(CreativeModeTabInit.ARCHBOWS_TAB).stacksTo(1).durability(ABConfig.CONFIG.flatBowDurability.get()), WOOD, ABConfig.CONFIG.flatDrawspeed.get(), ABConfig.CONFIG.FlatBowProjectileVelocity.get()));

    public static final RegistryObject<LongbowItem> LONG_BOW  = ITEMS.register("longbow",
            () -> new LongbowItem(new Item.Properties().tab(CreativeModeTabInit.ARCHBOWS_TAB).stacksTo(1).durability(ABConfig.CONFIG.longBowDurability.get()), WOOD, ABConfig.CONFIG.longDrawspeed.get(),ABConfig.CONFIG.LongBowProjectileVelocity.get()));


    //Crossbows
    public static final RegistryObject<HeavyCrossbowItem> ARBALEST = ITEMS.register("arbalest",
            () -> new HeavyCrossbowItem(new Item.Properties().tab(CreativeModeTabInit.ARCHBOWS_TAB).stacksTo(1).durability(ABConfig.CONFIG.heavyCrossbowDurability.get()), IRON));

    public static final RegistryObject<PistolCrossbowItem> PISTOL_CROSSBOW = ITEMS.register("pistol_crossbow",
            () -> new PistolCrossbowItem(new Item.Properties().tab(CreativeModeTabInit.ARCHBOWS_TAB).stacksTo(1).durability(ABConfig.CONFIG.pistolCrossbowDurability.get()), IRON));


    //Items
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
    public static final BoltItem bolt = new BoltItem("bolt",
            Config.INSTANCE.bolt.baseDamage.get().floatValue(), Config.INSTANCE.bolt.rangeMultiplier.get().floatValue(),
            Config.INSTANCE.bolt.armorPiercingFactor.get().floatValue());

    public static final BoltSpectralItem spectralBolt = new BoltSpectralItem("bolt_spectral",
            Config.INSTANCE.bolt.baseDamage.get().floatValue(), Config.INSTANCE.bolt.rangeMultiplier.get().floatValue(),
            Config.INSTANCE.bolt.armorPiercingFactor.get().floatValue());

    public static final BoltTippedItem tippedBolt = new BoltTippedItem("bolt_tipped", "bolt",
            Config.INSTANCE.bolt.baseDamage.get().floatValue(), Config.INSTANCE.bolt.rangeMultiplier.get().floatValue(),
            Config.INSTANCE.bolt.armorPiercingFactor.get().floatValue());

**/









    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}


