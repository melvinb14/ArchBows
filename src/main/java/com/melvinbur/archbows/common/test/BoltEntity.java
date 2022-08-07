package com.melvinbur.archbows.common.test;

import com.google.common.collect.Lists;

import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Iterator
        ;
import java.util.List;
/**
public class BoltEntity extends AbstractArrow implements IEntityAdditionalSpawnData {
    protected final String NBT_BOLT;
    protected final String NBT_POTION;
    protected final String NBT_POTION_COLOUR;
    protected static final EntityDataAccessor<Integer> DATA_COLOUR;
    protected static final EntityDataAccessor<ItemStack> DATA_BOLT;
    protected Potion potion;
    protected float baseDamage;
    protected float rangeMultiplier;
    protected float armorPiercingFactor;
    @Nullable
    private IntOpenHashSet piercingIgnoreEntityIds;
    @Nullable
    private List<Entity> piercedAndKilledEntities;

    public BoltEntity(EntityType<? extends BoltEntity> type, Level worldIn) {
        super(type, worldIn);
        this.NBT_BOLT = "Bolt";
        this.NBT_POTION = "Potion";
        this.NBT_POTION_COLOUR = "PotionColour";
        this.potion = Potions.EMPTY;
        this.baseDamage = 1.0F;
        this.rangeMultiplier = 1.0F;
        this.armorPiercingFactor = 0.0F;
    }

    public BoltEntity(EntityType<? extends BoltEntity> type, double x, double y, double z, Level worldIn) {
        super(type, x, y, z, worldIn);
        this.NBT_BOLT = "Bolt";
        this.NBT_POTION = "Potion";
        this.NBT_POTION_COLOUR = "PotionColour";
        this.potion = Potions.EMPTY;
        this.baseDamage = 1.0F;
        this.rangeMultiplier = 1.0F;
        this.armorPiercingFactor = 0.0F;
    }

    public BoltEntity(EntityType<? extends BoltEntity> type, LivingEntity shooter, Level Level) {
        super(type, shooter, Level);
        this.NBT_BOLT = "Bolt";
        this.NBT_POTION = "Potion";
        this.NBT_POTION_COLOUR = "PotionColour";
        this.potion = Potions.EMPTY;
        this.baseDamage = 1.0F;
        this.rangeMultiplier = 1.0F;
        this.armorPiercingFactor = 0.0F;
    }

    public BoltEntity(LivingEntity shooter, Level Level) {
        this(EntityInit.BOLT.get(), shooter, Level);
    }



    public BoltEntity(PlayMessages.SpawnEntity spawnEntity, Level Level) {
        this(EntityInit.BOLT.get(), Level);
    }

    public void initEntity(float baseDamage, float rangeMultiplier, float armorPiercingFactor, ItemStack boltStack) {
        this.baseDamage = baseDamage;
        this.rangeMultiplier = rangeMultiplier;
        this.armorPiercingFactor = armorPiercingFactor;
        this.setBaseDamage((double)baseDamage);
        this.getEntityData().set(DATA_BOLT, boltStack);
    }

    public void shootFromRotation(Entity shooter, float pitch, float yaw, float p_184547_4_, float velocity, float inaccuracy) {
        super.shootFromRotation(shooter, pitch, yaw, p_184547_4_, velocity * this.rangeMultiplier, inaccuracy);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_COLOUR, -1);
        this.entityData.define(DATA_BOLT, ItemStack.EMPTY);
    }

    public void  tick() {
        super. tick();
        if (this.level.isClientSide) {
            if (this.inGround) {
                if (this.inGroundTime % 5 == 0) {
                    this.spawnPotionParticles(1);
                }
            } else {
                this.spawnPotionParticles(2);
            }
        } else if (this.inGround && this.inGroundTime != 0 && this.inGroundTime >= 600) {
            this.level.broadcastEntityEvent(this, (byte)0);
            this.potion = Potions.EMPTY;
            this.entityData.set(DATA_COLOUR, -1);
        }

    }

    protected DamageSource causeArmorPiercingDamage(Entity sourceEntity, Entity indirectEntity) {
        return (new ArmorPiercingIndirectEntityDamageSource("arrow", sourceEntity, indirectEntity, this.armorPiercingFactor)).setProjectile();
    }

    protected void onHitEntity(EntityHitResult result) {
        Entity entity = result.getEntity();
        float velocity = (float)this.getDeltaMovement().length();
        int damage = Mth.ceil(Mth.clamp((double)velocity * this.getBaseDamage(), 0.0, 2.147483647E9));
        if (this.getPierceLevel() > 0) {
            if (this.piercingIgnoreEntityIds == null) {
                this.piercingIgnoreEntityIds = new IntOpenHashSet(5);
            }

            if (this.piercedAndKilledEntities == null) {
                this.piercedAndKilledEntities = Lists.newArrayListWithCapacity(5);
            }

            if (this.piercingIgnoreEntityIds.size() >= this.getPierceLevel() + 1) {
                this.remove();
                return;
            }

            this.piercingIgnoreEntityIds.add(entity.getId());
        }

        if (this.isCritArrow()) {
            long critDamageBonus = (long)this.random.nextInt(damage / 2 + 2);
            damage = (int)Math.min(critDamageBonus + (long)damage, 2147483647L);
        }

        Entity shooter = this.getOwner();
        DamageSource source;
        if (shooter == null) {
            source = this.causeArmorPiercingDamage(this, this);
        } else {
            source = this.causeArmorPiercingDamage(this, shooter);
            if (shooter instanceof LivingEntity) {
                ((LivingEntity)shooter).setLastHurtMob(entity);
            }
        }

        boolean isEnderman = entity.getType() == EntityType.ENDERMAN;
        int fireTimer = entity.getRemainingFireTicks();
        if (this.isOnFire() && !isEnderman) {
            entity.setSecondsOnFire(5);
        }

        if (entity.hurt(source, (float)damage)) {
            if (isEnderman) {
                return;
            }

            if (entity instanceof LivingEntity) {
                LivingEntity livingentity = (LivingEntity)entity;
                if (!this.level.isClientSide && this.getPierceLevel() <= 0) {
                    livingentity.setArrowCount(livingentity.getArrowCount() + 1);
                }

                if (this.getKnockback() > 0) {
                    Vec3 vector3d = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale((double) this.getKnockback() * 0.6);
                    if (vector3d.lengthSqr() > 0.0) {
                        livingentity.push(vector3d.x, 0.1, vector3d.z);
                    }
                }

                if (!this.level.isClientSide && shooter instanceof LivingEntity) {
                    EnchantmentHelper.doPostHurtEffects(livingentity, shooter);
                    EnchantmentHelper.doPostDamageEffects((LivingEntity)shooter, livingentity);
                }

                this.doPostHurtEffects(livingentity);
                if (shooter != null && livingentity != shooter && livingentity instanceof Player && shooter instanceof ServerPlayer && !this.isSilent()) {
                    ((ServerPlayer)shooter).connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.ARROW_HIT_PLAYER, 0.0F));
                }

                if (!entity.isAlive()) {
                    this.piercedAndKilledEntities.add(livingentity);
                }

                if (!this.level.isClientSide && shooter instanceof ServerPlayer) {
                    ServerPlayer serverplayerentity = (ServerPlayer)shooter;
                    if (this.piercedAndKilledEntities != null && this.shotFromCrossbow()) {
                        CriteriaTriggers.KILLED_BY_CROSSBOW.trigger(serverplayerentity, this.piercedAndKilledEntities);
                    } else if (!entity.isAlive() && this.shotFromCrossbow()) {
                        CriteriaTriggers.KILLED_BY_CROSSBOW.trigger(serverplayerentity, Arrays.asList(entity));
                    }
                }
            }

            this.playSound(this.getHitGroundSoundEvent(), 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
            if (this.getPierceLevel() <= 0) {
                this.remove();
            }
        } else {
            entity.setRemainingFireTicks(fireTimer);
            this.setDeltaMovement(this.getDeltaMovement().scale(-0.1));
            this.yRotO += 180.0F;
            this.yRotO += 180.0F;
            if (!this.level.isClientSide && this.getDeltaMovement().lengthSqr() < 1.0E-7) {
                if (this.pickup == pickup.ALLOWED) {
                    this.spawnAtLocation(this.getPickupItem(), 0.1F);
                }

                this.remove();
            }
        }

    }

    private void remove() {

    }

    protected void doPostHurtEffects(LivingEntity living) {
        super.doPostHurtEffects(living);
        Iterator var2 = this.potion.getEffects().iterator();

        while(var2.hasNext()) {
            MobEffectInstance effect = (MobEffectInstance)var2.next();
            living.addEffect(new MobEffectInstance(effect.getEffect(), Math.max(effect.getDuration() / 8, 1), effect.getAmplifier(), effect.isAmbient(), effect.isVisible()));
        }

    }

    protected ItemStack getPickupItem() {
        return (ItemStack)this.getEntityData().get(DATA_BOLT);
    }

    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public void readSpawnData(FriendlyByteBuf buffer) {
        double x = buffer.readDouble();
        double y = buffer.readDouble();
        double z = buffer.readDouble();
        this.setDeltaMovement(x, y, z);
    }

    public void func_70037_a(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Potion", 8)) {
            this.potion = PotionUtils.getPotion(compound);
        }

        this.entityData.set(DATA_COLOUR, compound.contains("PotionColour") ? compound.getInt("PotionColour") : -1);
    }

    public void writeSpawnData(FriendlyByteBuf buffer) {
        buffer.writeDouble(this.getDeltaMovement().x());
        buffer.writeDouble(this.getDeltaMovement().y());
        buffer.writeDouble(this.getDeltaMovement().z());
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        if (this.potion != null && this.potion != Potions.EMPTY) {
            compound.putString("Potion", ForgeRegistries.POTIONS.getKey(this.potion).toString());
        }

        compound.putInt("PotionColour", (Integer)this.entityData.get(DATA_COLOUR));
    }

    public void setPotionEffect(ItemStack stack) {
        this.potion = PotionUtils.getPotion(stack);
        this.entityData.set(DATA_COLOUR, PotionUtils.getColor(stack));
    }

    private void spawnPotionParticles(int particleCount) {
        int colour = (Integer)this.entityData.get(DATA_COLOUR);
        if (colour != -1 && particleCount > 0) {
            double cR = (double)(colour >> 16 & 255) / 255.0;
            double cG = (double)(colour >> 8 & 255) / 255.0;
            double cB = (double)(colour >> 0 & 255) / 255.0;

            for(int i = 0; i < particleCount; ++i) {
                this.level.addParticle(ParticleTypes.ENTITY_EFFECT, this.getX() + (this.random.nextDouble() - 0.5) * (double)this.getBbWidth(),
                        this.getY() + this.random.nextDouble() * (double)this.getBbHeight(),
                        this.getZ() + (this.random.nextDouble() - 0.5) * (double)this.getBbWidth(), cR, cG, cB);
            }
        }

    }

    public boolean isValid() {
        return !this.getPickupItem().isEmpty();
    }

    public ResourceLocation getTexture() {
        ItemStack boltStack = this.getPickupItem();
        if (boltStack.isEmpty()) {
            return new ResourceLocation("archbows", "missing_stack");
        } else {
            String boltRegName = String.valueOf(boltStack.getItem().getDefaultInstance());
            if (this.potion.toString().isEmpty()) {
                int idx = boltRegName.indexOf("_tipped");
                if (idx != -1) {
                    boltRegName = boltRegName.substring(0, idx);
                }
            }

            return new ResourceLocation("archbows", "textures/entity/projectiles/" + boltRegName + ".png");
        }
    }






    static {
        DATA_COLOUR = SynchedEntityData.defineId(BoltEntity.class, EntityDataSerializers.INT);
        DATA_BOLT = SynchedEntityData.defineId(BoltEntity.class, EntityDataSerializers.ITEM_STACK);
    }
}
**/