package com.melvinbur.archbows.core;


import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;

public class FlaxCropBlock extends CropBlock {
        public static final IntegerProperty AGE = BlockStateProperties.AGE_7;

        public FlaxCropBlock(Properties properties) {
            super(properties);
        }

        @Override
        public int getMaxAge() {
            return 7;
        }

        @Override
        protected @NotNull ItemLike getBaseSeedId() {
            return ItemInit.FLAX_SEEDS.get();
        }
    }

