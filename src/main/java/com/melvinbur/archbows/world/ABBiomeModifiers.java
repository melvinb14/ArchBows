package com.melvinbur.archbows.world;


import com.melvinbur.archbows.ArchBows;
import com.melvinbur.archbows.world.modifiers.ABBiomeModifier;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.PrimitiveCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ABBiomeModifiers {
    public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, ArchBows.MOD_ID);

    public static final RegistryObject<Codec<ABBiomeModifier>> BIOME_MODIFIER_SERIALIZER = BIOME_MODIFIER_SERIALIZERS.register("biome_modifier_serializer",
            () -> RecordCodecBuilder.create(builder -> builder.group(
                    TagKey.codec(Registries.BIOME).fieldOf("dimension").forGetter(ABBiomeModifier::dimension),
                    Biome.LIST_CODEC.listOf().fieldOf("biomes").forGetter(ABBiomeModifier::biomes),
                    Biome.LIST_CODEC.listOf().fieldOf("blacklist").forGetter(ABBiomeModifier::blacklist),
                    GenerationStep.Decoration.CODEC.fieldOf("decoration").forGetter(ABBiomeModifier::decoration),
                    PlacedFeature.CODEC.fieldOf("feature").forGetter(ABBiomeModifier::feature),
                    PrimitiveCodec.STRING.fieldOf("configOption").forGetter(ABBiomeModifier::configOption)
            ).apply(builder, ABBiomeModifier::new)));



}