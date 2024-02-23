package com.melvinbur.archbows.core;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraftforge.common.PlantType;

public class WildFlax2Block extends FlowerBlock {

    public WildFlax2Block() {
        super(MobEffects.SATURATION, 2, Properties.ofFullCopy(Blocks.DANDELION));
    }



    @Override
    public PlantType getPlantType(BlockGetter world, BlockPos pos) {
        return PlantType.DESERT;
    }
}