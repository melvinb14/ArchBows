package com.melvinbur.archbows.core;

import com.melvinbur.archbows.ArchBows;


import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


/**
public class EntityInit {



    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ArchBows.MOD_ID);

    public static final RegistryObject<EntityType<BoltEntity>> BOLT = ENTITY_TYPES.register("bolt", () -> EntityType.Builder.<BoltEntity>of(BoltEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4)
            .updateInterval(20).build(new ResourceLocation(ArchBows.MOD_ID, "bolt").toString()));

    public static final RegistryObject<EntityType<BoltSpectralEntity>> BOLT_SPECTRAL = ENTITY_TYPES.register("bolt_spectral", () -> EntityType.Builder.<BoltSpectralEntity>of(BoltSpectralEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4)
            .updateInterval(20).build(new ResourceLocation(ArchBows.MOD_ID, "bolt_spectral").toString()));




}
**/