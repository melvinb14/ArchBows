package com.melvinbur.archbows.world;


import com.melvinbur.archbows.ArchBows;


import com.melvinbur.archbows.common.config.ABConfig;
import com.melvinbur.archbows.common.config.Config;
import com.melvinbur.archbows.core.BlockInit;

import net.minecraft.core.Registry;

import net.minecraft.data.worldgen.placement.PlacementUtils;

import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ABConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, ArchBows.MOD_ID);

    // Overworld
    public static final RegistryObject<ConfiguredFeature<?, ?>> FLAX = register("flax1", () -> new ConfiguredFeature<>(Feature.FLOWER, new RandomPatchConfiguration(ABConfig.CONFIG.flax1Tries.get(), ABConfig.CONFIG.flax1XZspread.get(), ABConfig.CONFIG.flax1Yspread.get(), PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(BlockInit.WILD_FLAX.get()))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> FLAX2 = register("flax2", () -> new ConfiguredFeature<>(Feature.FLOWER, new RandomPatchConfiguration(ABConfig.CONFIG.flax2Tries.get(), ABConfig.CONFIG.flax2XZspread.get(), ABConfig.CONFIG.flax2Yspread.get(), PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(BlockInit.WILD_FLAX2.get()))))));


    public static <FC extends FeatureConfiguration, F extends Feature<FC>> RegistryObject<ConfiguredFeature<?, ?>> register(String name, Supplier<ConfiguredFeature<?, ?>> configuredFeature) {
        return CONFIGURED_FEATURES.register(name, configuredFeature);
    }



}