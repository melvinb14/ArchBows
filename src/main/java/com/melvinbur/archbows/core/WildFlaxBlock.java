package com.melvinbur.archbows.core;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;

import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;

import net.minecraftforge.common.PlantType;

public class WildFlaxBlock extends FlowerBlock {

    public WildFlaxBlock() {
        super(MobEffects.SATURATION, 2, Properties.ofFullCopy(Blocks.DANDELION));
    }



    @Override
    public PlantType getPlantType(BlockGetter world, BlockPos pos) {
        return PlantType.PLAINS;
    }
}