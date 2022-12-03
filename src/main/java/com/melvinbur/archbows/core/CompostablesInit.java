package com.melvinbur.archbows.core;


import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;

public class CompostablesInit {

    public static void init() {
        //Plants & Bushes

        setCompostInfo(BlockInit.FLAX.get(), 0.25F);






    }

    public static void setCompostInfo(ItemLike item, float chance) {
        ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
    }
}