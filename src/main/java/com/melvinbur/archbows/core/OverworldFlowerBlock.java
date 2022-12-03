package com.melvinbur.archbows.core;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraftforge.common.PlantType;

public class OverworldFlowerBlock extends FlowerBlock {


    public OverworldFlowerBlock() {
        super(MobEffects.SATURATION, 2, Properties.copy(Blocks.DANDELION));
    }



    @Override
    public PlantType getPlantType(BlockGetter world, BlockPos pos) {
        return PlantType.PLAINS;
    }
}

