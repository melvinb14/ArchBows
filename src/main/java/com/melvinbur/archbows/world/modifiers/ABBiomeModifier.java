package com.melvinbur.archbows.world.modifiers;

import com.melvinbur.archbows.common.config.Config;
import com.melvinbur.archbows.world.ABBiomeModifiers;
import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo.BiomeInfo.Builder;
import java.util.List;

public record ABBiomeModifier(TagKey<Biome> dimension, List<HolderSet<Biome>> biomes, List<HolderSet<Biome>> blacklist, Decoration decoration, Holder<PlacedFeature> feature, String configOption) implements BiomeModifier {

    @Override
    public void modify(Holder<Biome> biome, Phase phase, Builder builder) {
        if(Config.CONFIG_DATA.configOptions.get(configOption).get()) {
            if(phase == Phase.ADD) {
                if(biome.is(dimension)) {
                    boolean flag = false;
                    for(HolderSet<Biome> set : biomes) {
                        if(set.contains(biome)) {
                            flag = true;
                            break;
                        }
                    }

                    if(flag) {
                        for(HolderSet<Biome> set : blacklist) {
                            if(set.contains(biome)) {
                                return;
                            }
                        }

                        builder.getGenerationSettings().addFeature(decoration, feature);
                    }
                }
            }
        }
    }

    @Override
    public Codec<? extends BiomeModifier> codec() {
        return ABBiomeModifiers.BIOME_MODIFIER_SERIALIZER.get();
    }


}