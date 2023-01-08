package com.melvinbur.archbows.world;


import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.melvinbur.archbows.ArchBows;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;





public class ABPlacements {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, ArchBows.MOD_ID);

    
    // Overworld
   public static final RegistryObject<PlacedFeature> FLAX = register("flax1", ABConfiguredFeatures.FLAX, List.of(RarityFilter.onAverageOnceEvery(33), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final RegistryObject<PlacedFeature> FLAX2 = register("flax2", ABConfiguredFeatures.FLAX2, List.of(RarityFilter.onAverageOnceEvery(33), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));





    private static RegistryObject<PlacedFeature> copy(String name, Holder<PlacedFeature> placedFeature) {
        return register(name, placedFeature.value().feature(), placedFeature.value().placement());
    }

    private static <T extends FeatureConfiguration> RegistryObject<PlacedFeature> register(String name, Holder<? extends ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers) {
        return PLACED_FEATURES.register(name, () -> new PlacedFeature(Holder.hackyErase(feature), modifiers));
    }

    public static RegistryObject<PlacedFeature> register(String name, RegistryObject<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers) {
        return PLACED_FEATURES.register(name, () -> new PlacedFeature(Holder.hackyErase(feature.getHolder().orElseThrow()), modifiers));
    }

    public static RegistryObject<PlacedFeature> register(String name, RegistryObject<ConfiguredFeature<?, ?>> feature, PlacementModifier... modifiers) {
        return register(name, feature, List.of(modifiers));
    }

    public static List<PlacementModifier> onceEvery(int distance) {
        Builder<PlacementModifier> builder = ImmutableList.builder();
        builder.add(RarityFilter.onAverageOnceEvery(distance));

        builder.add(InSquarePlacement.spread());
        builder.add(PlacementUtils.HEIGHTMAP);
        builder.add(BiomeFilter.biome());
        return builder.build();
    }

    public static void init() {};
}