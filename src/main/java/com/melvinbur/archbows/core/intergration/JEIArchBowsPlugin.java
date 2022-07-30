package com.melvinbur.archbows.core.intergration;

import com.melvinbur.archbows.ArchBows;


import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import net.minecraft.resources.ResourceLocation;


@JeiPlugin
public class JEIArchBowsPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(ArchBows.MOD_ID, "jei_plugin");
    }
}
