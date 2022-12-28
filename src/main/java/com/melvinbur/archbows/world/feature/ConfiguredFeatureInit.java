package com.melvinbur.archbows.world.feature;

import com.melvinbur.archbows.common.config.ABConfig;
import com.melvinbur.archbows.core.BlockInit;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class ConfiguredFeatureInit {
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FLAX =
            FeatureUtils.register("flower_flax", Feature.FLOWER,
                    new RandomPatchConfiguration(ABConfig.CONFIG.flaxTries.get(), ABConfig.CONFIG.flaxXZspread.get(), ABConfig.CONFIG.flaxYspread.get(), PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(BlockInit.FLAX.get())))));



}
