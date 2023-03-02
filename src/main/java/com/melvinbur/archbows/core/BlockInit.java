package com.melvinbur.archbows.core;


import com.melvinbur.archbows.ArchBows;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;
import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ArchBows.MOD_ID);



    /* CROPS */
    public static final RegistryObject<Block> FLAX = BLOCKS.register("flax",
            () -> new FlaxCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));




    public static final RegistryObject<Block> WILD_FLAX = registerBlock("wild_flax", WildFlaxBlock::new);
    public static final RegistryObject<Block> WILD_FLAX2 = registerBlock("wild_flax2", WildFlax2Block::new);

    /* MISC */
  public static final RegistryObject<Block> POTTED_FLAX = registerBlockWithoutItem("potted_flax", () -> createFlowerPot(WILD_FLAX.get()));
    public static final RegistryObject<Block> POTTED_FLAX2 = registerBlockWithoutItem("potted_flax2", () -> createFlowerPot(WILD_FLAX2.get()));






    private static RegistryObject<Block> registerBlock(String name, Supplier<Block> block) {
        RegistryObject<Block> temp = BLOCKS.register(name, block);

        ItemInit.ITEMS.register(name, () -> new ItemNameBlockItem(temp.get(), new Item.Properties().tab(CreativeModeTabInit.ARCHBOWS_TAB)));
        return temp;
    }

    private static RegistryObject<Block> registerBlock(String name, Supplier<Item> item, Supplier<Block> block) {
        RegistryObject<Block> temp = BLOCKS.register(name, block);

        ItemInit.ITEMS.register(name, item);
        return temp;
    }

    private static RegistryObject<Block> registerBlockWithoutItem(String name, Supplier<Block> block) {
        return BLOCKS.register(name, block);
    }





    public static Block createFlowerPot(Block plant) {
        Block block = new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, ()-> plant, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT));
        ((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(plant)), () -> block);
        return block;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
