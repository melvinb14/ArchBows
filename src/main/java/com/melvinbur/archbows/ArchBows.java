package com.melvinbur.archbows;


import com.melvinbur.archbows.common.config.ABConfig;
import com.melvinbur.archbows.common.config.Config;
import com.melvinbur.archbows.common.util.Logger;
import com.melvinbur.archbows.core.BlockInit;
import com.melvinbur.archbows.core.CompostablesInit;
import com.melvinbur.archbows.core.ItemInit;
import com.melvinbur.archbows.world.ABBiomeModifiers;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;


@Mod(ArchBows.MOD_ID)
@Mod.EventBusSubscriber(modid = ArchBows.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArchBows {
    public static final String MOD_ID = "archbows";
    public static final Logger LOGGER = new Logger(MOD_ID);

    public ArchBows() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //Register config
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ABConfig.CONFIG_SPEC, "archbows-server.toml");
        ABConfig.loadConfig(ABConfig.CONFIG_SPEC,
                FMLPaths.CONFIGDIR.get().resolve("archbows-server.toml").toString());

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.CONFIG);



        ItemInit.register(eventBus);
        BlockInit.register(eventBus);


        ABBiomeModifiers.BIOME_MODIFIER_SERIALIZERS.register(eventBus);



        // EntityInit.ENTITY_TYPES.register(eventBus);
        eventBus.addListener(this::addCreative);
        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::clientSetup);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.COMBAT) {
            event.getEntries().putBefore(new ItemStack(Items.BOW), new ItemStack(ItemInit.SHORT_BOW.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.BOW), new ItemStack(ItemInit.RECURVE_BOW.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(ItemInit.RECURVE_BOW.get()), new ItemStack(ItemInit.FLAT_BOW.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(ItemInit.FLAT_BOW.get()), new ItemStack(ItemInit.LONG_BOW.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries().putBefore(new ItemStack(Items.CROSSBOW), new ItemStack(ItemInit.PISTOL_CROSSBOW.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(Items.CROSSBOW), new ItemStack(ItemInit.HEAVY_CROSSBOW.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(ItemInit.HEAVY_CROSSBOW.get()), new ItemStack(ItemInit.ARBALEST.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
          }

        if (event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.getEntries().putAfter(new ItemStack(Items.LILY_OF_THE_VALLEY), new ItemStack(BlockInit.WILD_FLAX.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(BlockInit.WILD_FLAX.get()), new ItemStack(BlockInit.WILD_FLAX2.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries().putAfter(new ItemStack(Items.BEETROOT_SEEDS), new ItemStack(ItemInit.FLAX_SEEDS.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if (event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.getEntries().putAfter(new ItemStack(Items.WHEAT), new ItemStack(ItemInit.FLAX.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries().putAfter(new ItemStack(Items.STRING), new ItemStack(ItemInit.FLAX_STRING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(ItemInit.FLAX_STRING.get()), new ItemStack(ItemInit.LINEN_STRING.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

        }

    }



    private void clientSetup(final FMLClientSetupEvent event) {
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(CompostablesInit::init);

    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent evt) {
        LOGGER.debug("Debug Log.");
        LOGGER.error("Error Log.");


    }
}
