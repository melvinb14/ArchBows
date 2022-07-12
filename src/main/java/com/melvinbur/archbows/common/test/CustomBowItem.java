package com.melvinbur.archbows.common.test;







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

public class CustomBowItem extends BowItem  {

    private final Tiers material;
    private final float maxDrawTime;
    private final double damageModifier;
    private final ParticleOptions type;

    public CustomBowItem(Tiers material, Properties properties, float maxDrawTime, double damageModifier) {
        super(properties);
        this.material = material;
        this.maxDrawTime = maxDrawTime;
        this.damageModifier = damageModifier;
        type = null;
    }

    public CustomBowItem(Tiers material, Properties properties, float maxDrawTime, double damageModifier, ParticleOptions particles) {
        super(properties);
        this.material = material;
        this.maxDrawTime = maxDrawTime;
        this.damageModifier = damageModifier;
        type = particles;
    }
    public ParticleOptions getArrowParticles() {
        return type;
    }




    public float getMaxDrawTime() {
        return Math.max(0, maxDrawTime);
    }






    @Override
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int remainingUseTicks) {
        if (pEntityLiving instanceof Player) {
            Player player = (Player)pEntityLiving;
            boolean flag = player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, pStack) > 0;
            ItemStack itemstack = player.getProjectile(pStack);

            int currentUseTime = this.getUseDuration(pStack) - remainingUseTicks;
            float pullProgress = getPullProgress(pStack, this, currentUseTime);
            currentUseTime = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(pStack, pLevel, player,currentUseTime, !itemstack.isEmpty() || flag);
            if (currentUseTime < 0) return;


            if (!itemstack.isEmpty() || flag) {
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(Items.ARROW);
                }



                if ((double) pullProgress >= 0.1D) {
                    boolean bl2 = player.getAbilities().instabuild || (itemstack.getItem() instanceof ArrowItem && ((ArrowItem)itemstack.getItem()).isInfinite(itemstack, pStack, player));

                    if (!pLevel.isClientSide) {
                        ArrowItem arrowItem = (ArrowItem) (itemstack.getItem() instanceof ArrowItem ? itemstack.getItem() : Items.ARROW);
                        AbstractArrow abstractarrow  = arrowItem.createArrow(pLevel, itemstack, player);
                        abstractarrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, pullProgress * 3.0F, 1.0F);



                        // Make Arrow crit if pull progress is fully complete
                        if (pullProgress == 1.0F) {
                            abstractarrow .setCritArrow(true);
                        }

                        // Apply damage from power enchantment
                        int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, pStack);
                        if (j > 0) {
                            abstractarrow .setBaseDamage(abstractarrow .getBaseDamage() + (double) j * 0.5D + 0.5D);
                        }

                        // apply damage multiplier
                        abstractarrow .setBaseDamage(abstractarrow .getBaseDamage() * damageModifier);

                        // Apply punch knockback
                        int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, pStack);
                        if (k > 0) {
                            abstractarrow .setKnockback(k);
                        }

                        // Apply flame
                        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, pStack) > 0) {
                            abstractarrow .setSecondsOnFire(100);
                        }

                        // Damage tool
                        pStack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(player.getUsedItemHand()));

                        // Set arrow pickup type based on source
                        if (bl2 || player.getAbilities().instabuild && (itemstack.getItem() == Items.SPECTRAL_ARROW || itemstack.getItem() == Items.TIPPED_ARROW)) {
                            abstractarrow .pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }

                        pLevel.addFreshEntity(abstractarrow );
                    }

                    pLevel.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (pLevel.random.nextFloat() * 0.4F + 1.2F) + pullProgress * 0.5F);

                    // decrement source arrow stack
                    if (!bl2 && !player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            player.getInventory().removeItem(itemstack);
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    public static float getPullProgress(ItemStack pStack, CustomBowItem bow, int useTicks) {
        float progress = (float) useTicks / bow.getMaxDrawTime();
        progress = (progress * progress + progress * 2.0F) / 3.0F;

        if (progress > 1.0F) {
            progress = 1.0F;
        }

        return progress;
    }


    @Override
    public int getEnchantmentValue() {
        return material.getEnchantmentValue();
    }

    @Override
    public boolean isValidRepairItem(ItemStack pStack,  ItemStack ingredient) {
        return this.material.getRepairIngredient().test(ingredient);
    }

    @Override
    public void appendHoverText(ItemStack pStack,  Level pLevel, List<Component> pTooltipComponents,
                                 TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        pTooltipComponents.add(TextComponent.EMPTY);
        pTooltipComponents.add(new TranslatableComponent("archbows.bow_stats").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(new TextComponent(" ").append(new TranslatableComponent("archbows.bow_damage", damageModifier).withStyle(ChatFormatting.DARK_GREEN)));
        pTooltipComponents.add(new TextComponent(" ").append(new TranslatableComponent("archbows.bow_draw_speed", (double) maxDrawTime / 20).withStyle(ChatFormatting.DARK_GREEN)));
    }
}