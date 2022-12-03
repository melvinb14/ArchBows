package com.melvinbur.archbows.api;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tiers;

public class RarityHelper {
    public static Rarity fromToolMaterial(Tiers material){
        return
                material == Tiers.NETHERITE ? Rarity.EPIC :
                        material == Tiers.DIAMOND ? Rarity.RARE :
                                material == Tiers.GOLD ? Rarity.UNCOMMON :
                                        material == Tiers.IRON ? Rarity.UNCOMMON : Rarity.COMMON;
    }
}