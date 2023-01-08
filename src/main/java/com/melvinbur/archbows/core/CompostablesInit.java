package com.melvinbur.archbows.core;


import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;

public class CompostablesInit {

    public static void init() {
        //Plants & Bushes

        setCompostInfo(BlockInit.WILD_FLAX.get(), 0.45F);
        setCompostInfo(ItemInit.FLAX.get(), 0.25F);
        setCompostInfo(ItemInit.FLAX_SEEDS.get(), 0.1F);






    }

    public static void setCompostInfo(ItemLike item, float chance) {
        ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
    }
}