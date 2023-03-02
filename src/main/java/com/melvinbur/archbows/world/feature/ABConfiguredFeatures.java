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


public class ABConfiguredFeatures {
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FLAX =
            FeatureUtils.register("flax1", Feature.FLOWER,
                    new RandomPatchConfiguration(ABConfig.CONFIG.flax1Tries.get(), ABConfig.CONFIG.flax1XZspread.get(),ABConfig.CONFIG.flax1Yspread.get(), PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(BlockInit.WILD_FLAX.get())))));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FLAX2 =
            FeatureUtils.register("flax2", Feature.FLOWER,
                    new RandomPatchConfiguration(ABConfig.CONFIG.flax2Tries.get(), ABConfig.CONFIG.flax2XZspread.get(),ABConfig.CONFIG.flax2Yspread.get(), PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(BlockInit.WILD_FLAX2.get())))));




}