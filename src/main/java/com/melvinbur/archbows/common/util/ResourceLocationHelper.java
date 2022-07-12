package com.melvinbur.archbows.common.util;

import com.melvinbur.archbows.ArchBows;
import net.minecraft.resources.ResourceLocation;

public class ResourceLocationHelper {
    public static ResourceLocation prefix(String path) {
        return new ResourceLocation(ArchBows.MOD_ID, path);
    }
}