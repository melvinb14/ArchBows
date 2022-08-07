package com.melvinbur.archbows.common.test;


import com.melvinbur.archbows.core.ItemInit;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.PlayMessages;
/**
public class BoltSpectralEntity extends BoltEntity {
    private int duration;
    private final String NBT_DURATION;

    public BoltSpectralEntity(EntityType<? extends BoltEntity> type, Level worldIn) {
        super(type, worldIn);
        this.duration = 200;
        this.NBT_DURATION = "Duration";
    }

    public BoltSpectralEntity(EntityType<? extends BoltEntity> type, double x, double y, double z, Level worldIn) {
        super(type, x, y, z, worldIn);
        this.duration = 200;
        this.NBT_DURATION = "Duration";
    }

    public BoltSpectralEntity(LivingEntity shooter, Level world) {
        super(EntityInit.BOLT_SPECTRAL.get(), shooter, world);
        this.duration = 200;
        this.NBT_DURATION = "Duration";
    }

    public BoltSpectralEntity(PlayMessages.SpawnEntity spawnEntity, Level world) {
        this(EntityInit.BOLT_SPECTRAL.get(), world);
    }

    public void tick() {
        super.tick();
        if (this.level.isClientSide && !this.inGround) {
            this.level.addParticle(ParticleTypes.INSTANT_EFFECT, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
        }

    }

    protected ItemStack getPickupItem() {
        return new ItemStack(ItemInit.spectralBolt);
    }

    protected void doPostHurtEffects(LivingEntity living) {
        super.doPostHurtEffects(living);
        MobEffectInstance effect = new MobEffectInstance(MobEffects.GLOWING, this.duration, 0);
        living.addEffect(effect);
    }

    public ResourceLocation getTexture() {
        return new ResourceLocation("archbows", "textures/entity/projectiles/bolt_spectral.png");
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.func_70037_a(compound);
        if (compound.contains("Duration")) {
            this.duration = compound.getInt("Duration");
        }

    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Duration", this.duration);
    }
}
 **/