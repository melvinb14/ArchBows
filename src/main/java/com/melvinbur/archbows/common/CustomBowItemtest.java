package com.melvinbur.archbows.common;


import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import java.util.List;

public class CustomBowItemtest extends BowItem  {

    private final Tiers material;
    private final float maxDrawTime;
    private final double damageModifier;


    private final ParticleOptions type;

    public CustomBowItemtest(Tiers material, Properties settings, float maxDrawTime, double damageModifier) {
        super(settings);
        this.material = material;
        this.maxDrawTime = maxDrawTime;
        this.damageModifier = damageModifier;
        type = null;
    }

    public CustomBowItemtest(Tiers material, Properties settings, float maxDrawTime, double damageModifier, ParticleOptions particles) {
        super(settings);
        this.material = material;
        this.maxDrawTime = maxDrawTime;
        this.damageModifier = damageModifier;
        type = particles;
    }
    public ParticleOptions getArrowParticles() {
        return type;
    }




    public float getMaxDrawTime(ItemStack bow) {
        return Math.max(0, maxDrawTime);
    }






    @Override
    public void releaseUsing( ItemStack stack, Level world,  LivingEntity user, int remainingUseTicks) {
        if (user instanceof Player playerEntity) {
            boolean skipArrowCheck = playerEntity.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0;
            ItemStack arrowStack = playerEntity.getProjectile(stack);

            if (!arrowStack.isEmpty() || skipArrowCheck) {
                if (arrowStack.isEmpty()) {
                    arrowStack = new ItemStack(Items.ARROW);
                }

                int currentUseTime = this.getUseDuration(stack) - remainingUseTicks;
                float pullProgress = getPullProgress(stack, this, currentUseTime);

                if ((double) pullProgress >= 0.1D) {
                    boolean bl2 = skipArrowCheck && arrowStack.getItem() == Items.ARROW;

                    if (!world.isClientSide) {
                        ArrowItem arrowItem = (ArrowItem) (arrowStack.getItem() instanceof ArrowItem ? arrowStack.getItem() : Items.ARROW);
                        AbstractArrow arrowEntity = arrowItem.createArrow(world, arrowStack, playerEntity);
                        arrowEntity.shootFromRotation(playerEntity, playerEntity.getXRot(), playerEntity.getYRot(), 0.0F, pullProgress * 3.0F, 1.0F);


                        // Make Arrow crit if pull progress is fully complete
                        if (pullProgress == 1.0F) {
                            arrowEntity.setCritArrow(true);
                        }

                        // Apply damage from power enchantment
                        int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, stack);
                        if (j > 0) {
                            arrowEntity.setBaseDamage(arrowEntity.getBaseDamage() + (double) j * 0.5D + 0.5D);
                        }

                        // apply damage multiplier
                        arrowEntity.setBaseDamage(arrowEntity.getBaseDamage() * damageModifier);

                        // Apply punch knockback
                        int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, stack);
                        if (k > 0) {
                            arrowEntity.setKnockback(k);
                        }

                        // Apply flame
                        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, stack) > 0) {
                            arrowEntity.setSecondsOnFire(100);
                        }

                        // Damage tool
                        stack.hurtAndBreak(1, playerEntity, (p) -> p.broadcastBreakEvent(playerEntity.getUsedItemHand()));

                        // Set arrow pickup type based on source
                        if (bl2 || playerEntity.getAbilities().instabuild && (arrowStack.getItem() == Items.SPECTRAL_ARROW || arrowStack.getItem() == Items.TIPPED_ARROW)) {
                            arrowEntity.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }

                        world.addFreshEntity(arrowEntity);
                    }

                    world.playSound(null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (world.random.nextFloat() * 0.4F + 1.2F) + pullProgress * 0.5F);

                    // decrement source arrow stack
                    if (!bl2 && !playerEntity.getAbilities().instabuild) {
                        arrowStack.shrink(1);
                        if (arrowStack.isEmpty()) {
                            playerEntity.getInventory().removeItem(arrowStack);
                        }
                    }

                    playerEntity.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    public static float getPullProgress(ItemStack stack, CustomBowItemtest bow, int useTicks) {
        float progress = (float) useTicks / bow.getMaxDrawTime(stack);
        progress = (progress * progress + progress * 2.0F) / 3.0F;

        if (progress > 1.0F) {
            progress = 1.0F;
        }

        return progress;
    }

    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    @Override
    public int getEnchantmentValue() {
        return material.getEnchantmentValue();
    }

    @Override
    public boolean isValidRepairItem(ItemStack stack,  ItemStack ingredient) {
        return this.material.getRepairIngredient().test(ingredient);
    }

    @Override
    public void appendHoverText(ItemStack stack,  Level pLevel, List<Component> pTooltipComponents,
                                 TooltipFlag pIsAdvanced) {
        super.appendHoverText(stack, pLevel, pTooltipComponents, pIsAdvanced);
        pTooltipComponents.add(TextComponent.EMPTY);
        pTooltipComponents.add(new TranslatableComponent("archbows.bow_stats").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(new TextComponent(" ").append(new TranslatableComponent("archbows.bow_damage", damageModifier).withStyle(ChatFormatting.DARK_GREEN)));
        pTooltipComponents.add(new TextComponent(" ").append(new TranslatableComponent("archbows.bow_draw_speed", (double) maxDrawTime / 20).withStyle(ChatFormatting.DARK_GREEN)));
    }
}