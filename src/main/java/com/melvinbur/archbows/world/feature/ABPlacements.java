package com.melvinbur.archbows.world.feature;


import net.minecraft.core.Holder;

import net.minecraft.data.worldgen.placement.PlacementUtils;

import net.minecraft.world.level.levelgen.placement.*;


import java.util.List;

public class ABPlacements {
    public static final Holder<PlacedFeature> FLAX_PLACED = PlacementUtils.register("flax_placed",
            ABConfiguredFeatures.FLAX, RarityFilter.onAverageOnceEvery(16),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

    public static final Holder<PlacedFeature> FLAX_PLACED2 = PlacementUtils.register("flax_placed2",
            ABConfiguredFeatures.FLAX2, RarityFilter.onAverageOnceEvery(16),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
}

