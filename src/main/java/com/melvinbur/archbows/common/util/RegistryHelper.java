package com.melvinbur.archbows.common.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;


import java.util.Objects;

public class RegistryHelper {
    private RegistryHelper() {}
    public static String getItemRegistryName(Item item) {
        ResourceLocation rl = ForgeRegistries.ITEMS.getKey(item);
        //null check because some mods don't properly register items they use in recipes
        if(rl != null) {
            return rl.toString();
        }

        return "";
    }

    public static ResourceLocation getRegistryName(ForgeRegistry<?> registryEntry) {
        ResourceLocation registryName = registryEntry.getRegistryName();
        Objects.requireNonNull(registryName);
        return registryName;
    }


}