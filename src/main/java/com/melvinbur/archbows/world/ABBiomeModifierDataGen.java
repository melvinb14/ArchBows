/*
package com.melvinbur.archbows.world;


import com.google.gson.JsonElement;
import com.melvinbur.archbows.ArchBows;
import com.melvinbur.archbows.world.modifiers.ABBiomeModifier;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class ABBiomeModifierDataGen {

    private static final TagKey<Biome> OVERWORLD = BiomeTags.IS_OVERWORLD;
    private static final TagKey<Biome> NETHER = BiomeTags.IS_NETHER;
    private static final TagKey<Biome> END = BiomeTags.IS_END;

    public static Map<ResourceLocation, BiomeModifier> createFeatureGenMap(RegistryOps<JsonElement> registryOps) {
        Map<ResourceLocation, BiomeModifier> map = new HashMap<>();

        return map;
    }

    private static void addFeature(Map<ResourceLocation, BiomeModifier> map, String placedFeatureName, Builder builder) {
        BiomeModifier modifier = builder.build();
        ResourceLocation location = new ResourceLocation(ArchBows.MOD_ID, placedFeatureName);
        map.put(location, modifier);
    }


    private static HolderSet<Biome> getAllBiomes(RegistryOps<JsonElement> registryOps, TagKey<Biome> tag) {
        return new HolderSet.Named<>(registryOps.registry(Registry.BIOME_REGISTRY).get(), tag);
    }

    private static List<TagKey<Biome>> forestOrPlains() {
        return List.of(Tags.Biomes.IS_PLAINS, BiomeTags.IS_FOREST);
    }

    private static List<TagKey<Biome>> plainsType() {
        return List.of(Tags.Biomes.IS_PLAINS, BiomeTags.IS_SAVANNA);
    }

    private static List<TagKey<Biome>> oceanOrBeach() {
        return List.of(BiomeTags.IS_BEACH, BiomeTags.IS_OCEAN);
    }

    private static List<TagKey<Biome>> badlands() {
        return List.of(BiomeTags.IS_BADLANDS);
    }

    private static List<TagKey<Biome>> beach() {
        return List.of(BiomeTags.IS_BEACH);
    }

    private static List<TagKey<Biome>> river() {
        return List.of(BiomeTags.IS_RIVER);
    }

    private static List<TagKey<Biome>> coniferous() {
        return List.of(Tags.Biomes.IS_CONIFEROUS);
    }

    private static List<TagKey<Biome>> snowy() {
        return List.of(Tags.Biomes.IS_SNOWY);
    }

    private static List<TagKey<Biome>> mushroom() {
        return List.of(Tags.Biomes.IS_MUSHROOM);
    }

    private static List<ResourceKey<Biome>> veryCold() {
        return List.of(Biomes.FROZEN_RIVER, Biomes.SNOWY_PLAINS,
                Biomes.SNOWY_BEACH,
                Biomes.SNOWY_SLOPES,
                Biomes.ICE_SPIKES,
                Biomes.FROZEN_OCEAN,
                Biomes.DEEP_FROZEN_OCEAN,
                Biomes.JAGGED_PEAKS);
    }

    private static List<TagKey<Biome>> desert() {
        */
/* rip BiomeCategory, going to take a risk and hope modded biomes with desert pyramids are also actually deserts *//*

        return List.of(BiomeTags.HAS_DESERT_PYRAMID, BiomeTags.IS_BADLANDS);
    }

    private static List<TagKey<Biome>> overworld() {
        return List.of(BiomeTags.IS_OVERWORLD);
    }

    private static List<TagKey<Biome>> nether() {
        return List.of(BiomeTags.IS_NETHER);
    }

    private static Holder<Biome> getBiome(RegistryOps<JsonElement> registryOps, ResourceKey<Biome> biomeKey) {
        return registryOps.registry(Registry.BIOME_REGISTRY).get().getHolder(biomeKey).get();
    }



    private static class Builder {

        private String placedFeatureName;
        private TagKey<Biome> dimension = OVERWORLD;
        private List<TagKey<Biome>> biomeTags = new ArrayList<>();
        private List<TagKey<Biome>> blacklistTags = new ArrayList<>();;
        private List<Holder<Biome>> extraBiomes = new ArrayList<>();;
        private List<Holder<Biome>> extraBlacklist = new ArrayList<>();;
        private RegistryOps<JsonElement> registryOps;
        private GenerationStep.Decoration decoration = GenerationStep.Decoration.VEGETAL_DECORATION;
        private String configOption;

        public Builder(RegistryOps<JsonElement> registryOps, String placedFeatureName, String configOption) {
            this.registryOps = registryOps;
            this.placedFeatureName = placedFeatureName;
            this.configOption = configOption;
        }

        public Builder dimension(TagKey<Biome> tag) {
            this.dimension = tag;
            return this;
        }

        public Builder tag(List<TagKey<Biome>> tags) {
            this.biomeTags.addAll(combine(tags));
            return this;
        }

        public Builder blacklist(List<TagKey<Biome>>... tags) {
            this.blacklistTags.addAll(combine(tags));
            return this;
        }

        public Builder extraBiomes(List<Holder<Biome>>... biomes) {
            this.extraBiomes.addAll(combine(biomes));
            return this;
        }

        public Builder extraBiomes(ResourceKey<Biome>... biomes) {
            for(ResourceKey<Biome> biome : biomes) {
                this.extraBiomes.add(registryOps.registry(Registry.BIOME_REGISTRY).get().getHolder(biome).get());
            }
            return this;
        }

        public Builder extraBlacklist(List<Holder<Biome>>... biomes) {
            this.extraBlacklist.addAll(combine(biomes));
            return this;
        }

        public Builder extraBlacklist(ResourceKey<Biome>... biomes) {
            for(ResourceKey<Biome> biome : biomes) {
                this.extraBlacklist.add(registryOps.registry(Registry.BIOME_REGISTRY).get().getHolder(biome).get());
            }
            return this;
        }

        public Builder extraBlacklist(List<ResourceKey<Biome>> biomes) {
            for(ResourceKey<Biome> biome : biomes) {
                this.extraBlacklist.add(registryOps.registry(RegistryDataLoader.BIOME_REGISTRY).get().getHolder(biome).get());
            }
            return this;
        }

        public Builder decoration(GenerationStep.Decoration decoration) {
            this.decoration = decoration;
            return this;
        }

        @SafeVarargs
        public final <T> List<T> combine(List<T>... lists) {
            List<T> list = new ArrayList<>();
            for(List<T> i : lists)
                for(T tag : i)
                    list.add(tag);

            return list;
        }

        public ABBiomeModifier build() {
            List<HolderSet<Biome>> biomesSet = new ArrayList<>(this.biomeTags.stream().map(tag -> getAllBiomes(registryOps, tag)).toList());
            List<HolderSet<Biome>> blacklistSet = new ArrayList<>(this.blacklistTags.stream().map(tag -> getAllBiomes(registryOps, tag)).toList());
            biomesSet.add(HolderSet.direct(this.extraBiomes));
            blacklistSet.add(HolderSet.direct(this.extraBlacklist));
            ResourceLocation location = new ResourceLocation(ArchBows.MOD_ID, placedFeatureName);
            Holder<PlacedFeature> placedFeature = registryOps.registry(Registry.PLACED_FEATURE_REGISTRY).get().getHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, location));
            return new ABBiomeModifier(dimension, biomesSet, blacklistSet, decoration, placedFeature, configOption);
        }
    }
}*/
