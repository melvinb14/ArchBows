package com.melvinbur.archbows.core;

import com.melvinbur.archbows.ArchBows;
import com.melvinbur.archbows.world.ABConfiguredFeatures;
import com.melvinbur.archbows.world.ABPlacements;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class WorldGenProviderInit extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ABConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ABPlacements::bootstrap);

    public WorldGenProviderInit(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Collections.singleton(ArchBows.MOD_ID));
    }
}