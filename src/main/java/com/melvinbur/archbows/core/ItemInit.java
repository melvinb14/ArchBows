package com.melvinbur.archbows.core;

import com.melvinbur.archbows.ArchBows;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ArchBows.MOD_ID);





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}


