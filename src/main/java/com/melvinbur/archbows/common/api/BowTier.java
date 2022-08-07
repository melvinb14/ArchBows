package com.melvinbur.archbows.common.api;


import net.minecraft.world.item.crafting.Ingredient;

public interface BowTier {

        float getAttackDamageBonus();

        int getEnchantmentValue();

        Ingredient getRepairIngredient();
    }

