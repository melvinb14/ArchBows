package com.melvinbur.archbows.core;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeModeTabInit {
    public static final CreativeModeTab ARCHBOWS_TAB = new CreativeModeTab("archbowsTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.RECURVE_BOW.get());
        }
    };
}

//t