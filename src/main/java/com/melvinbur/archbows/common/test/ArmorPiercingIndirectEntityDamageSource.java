package com.melvinbur.archbows.common.test;


import net.minecraft.world.damagesource.IndirectEntityDamageSource;
import net.minecraft.world.entity.Entity;

public class ArmorPiercingIndirectEntityDamageSource extends IndirectEntityDamageSource implements IArmorPiercingDamageSource {
    protected final float armorPiercingPercentage;

    public ArmorPiercingIndirectEntityDamageSource(String damageTypeIn, Entity source, Entity indirectEntityIn, float armorPiercingPercentageIn) {
        super(damageTypeIn, source, indirectEntityIn);
        this.armorPiercingPercentage = armorPiercingPercentageIn;
    }

    public float getArmorPiercingPercentage() {
        return this.armorPiercingPercentage;
    }
}
