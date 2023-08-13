package com.melvinbur.archbows.core;



import com.google.common.collect.ImmutableList;
import com.melvinbur.archbows.ArchBows;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.world.level.storage.loot.LootPool;

import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


import java.util.List;


import static com.melvinbur.archbows.common.util.ResourceLocationHelper.prefix;

@Mod.EventBusSubscriber(modid = ArchBows.MOD_ID)
public final class LootInit{

    //TODO: Update LootInit
    private static final List<String> CHEST_TABLES = ImmutableList.of("abandoned_mineshaft", "desert_pyramid", "end_city_treasure", "igloo_chest", "jungle_temple", "nether_bridge", "simple_dungeon", "stronghold_corridor", "stronghold_crossing", "stronghold_library", "village_blacksmith" , "ancient_city" , "bastion_treasure" , "spawn_bonus_chest" , "treasure");


    @SuppressWarnings("unused") //used in event
    @SubscribeEvent
    public static void lootLoad(LootTableLoadEvent evt) {
        String chestsPrefix = "minecraft:chests/";
        String name = evt.getName().toString();

        if ((name.startsWith(chestsPrefix) && CHEST_TABLES.contains(name.substring(chestsPrefix.length()))))
                 {
            String file = name.substring("minecraft:".length());
           // evt.getTable().addPool(getInjectPool(file));
        }
    }


    public static LootPool getInjectPool(String entryName) {
        return LootPool.lootPool()
                .add(getInjectEntry(entryName))
                .setBonusRolls(UniformGenerator.between(0, 1))
                .build();
    }

    private static LootPoolEntryContainer.Builder<?> getInjectEntry(String name) {
        ResourceLocation table = prefix("inject/" + name);
        return LootTableReference.lootTableReference(table)
                .setWeight(1);
    }


}