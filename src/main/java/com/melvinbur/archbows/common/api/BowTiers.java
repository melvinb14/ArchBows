package com.melvinbur.archbows.common.api;

import java.util.function.Supplier;

import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyLoadedValue;

import net.minecraft.world.item.crafting.Ingredient;

public enum BowTiers implements BowTier {

    SHORTBOW(-0.75f, 1, () -> {
        return Ingredient.of(ItemTags.PLANKS);
    }),
    BOW(1.0f, 1, () -> {
        return Ingredient.of(ItemTags.PLANKS);
    }),
    FLATBOW(2.5f, 1, () -> {
        return Ingredient.of(ItemTags.PLANKS);
    }),
    LONGBOW(5.0f, 1, () -> {
        return Ingredient.of(ItemTags.PLANKS);
    });



    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    private BowTiers( float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }


    public float getAttackDamageBonus() {
        return this.damage;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}