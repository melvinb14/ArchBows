package com.melvinbur.archbows.common.bow;


import com.melvinbur.archbows.common.config.ABConfig;
import com.melvinbur.archbows.common.config.Config;
import net.minecraft.ChatFormatting;

import net.minecraft.network.chat.Component;
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
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.loading.FMLEnvironment;

import javax.annotation.Nullable;
import java.util.List;

public class ShortbowItem extends BowItem {
    protected Tiers material;

    protected float drawSpeed;
    protected float maxVelocity;
    protected String modId;


    public ShortbowItem(Properties prop, Tiers material) {
        super(prop);
        this.drawSpeed = ABConfig.CONFIG.shortDrawspeed.get().floatValue();
        this.modId = null;
        this.material = material;
        this.maxVelocity = ABConfig.CONFIG.ShortBowProjectileVelocity.get().floatValue();


        if (FMLEnvironment.dist.isClient()) {
            BowProperties.registerShortBowProperties(this);
        }

    }


    public float getDrawSpeed() {
        return Math.max(0, drawSpeed);
    }



    @Override
    public void releaseUsing(ItemStack stack, Level worldIn, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof Player) {
            Player player = (Player) entityLiving;
            boolean flag = player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0;
            ItemStack itemstack = player.getProjectile(stack);
            int i = this.getUseDuration(stack) - timeLeft;
            i = ForgeEventFactory.onArrowLoose(stack, worldIn, (Player) entityLiving, i, itemstack != null || flag);
            if (i < 0) {
                return;
            }

            if (!itemstack.isEmpty() || flag) {
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(Items.ARROW);
                }

                float f = this.getArrowSpeed(i);
                if ((double) f >= 0.1) {
                    boolean flag1 = player.getAbilities().instabuild || itemstack.getItem() instanceof ArrowItem && ((ArrowItem) itemstack.getItem()).isInfinite(itemstack, stack, player);
                    if (!worldIn.isClientSide) {
                        ArrowItem itemarrow = (ArrowItem) (itemstack.getItem() instanceof ArrowItem ? itemstack.getItem() : Items.ARROW);
                        AbstractArrow entityarrow = itemarrow.createArrow(worldIn, itemstack, player);
                        entityarrow.shootFromRotation(player, player.xRotO, player.yRotO, 0.0F, f * 3.0F, 0.5F);


                        if (f == this.maxVelocity) {
                            entityarrow.setCritArrow(true);
                        }

                        int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, stack);
                        if (j > 0) {
                            entityarrow.setBaseDamage(entityarrow.getBaseDamage() + (double) j * 0.5 + 0.5);
                        }

                        int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, stack);
                        if (k > 0) {
                            entityarrow.setKnockback(k);
                        }

                        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, stack) > 0) {
                            entityarrow.setSecondsOnFire(100);
                        }

                        stack.hurtAndBreak(1, player, (playerEntity) -> {
                            playerEntity.broadcastBreakEvent(player.getUsedItemHand());
                        });
                        if (flag1 || player.getAbilities().instabuild && (itemstack.getItem() == Items.SPECTRAL_ARROW || itemstack.getItem() == Items.TIPPED_ARROW)) {
                            entityarrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }

                        worldIn.addFreshEntity(entityarrow);
                    }

                    worldIn.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (worldIn.random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!flag1) {
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

    public float getArrowSpeed(int charge) {
        float f = (float) charge / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > this.maxVelocity) {
            f = this.maxVelocity;
        }

        return f;
    }

    public int getEnchantmentValue() {
        return this.material.getEnchantmentValue();
    }

    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return this.material.getRepairIngredient().test(repair);
    }


    public float getNockProgress(ItemStack stack, LivingEntity shooter) {
        return (float) (stack.getUseDuration() - shooter.getUseItemRemainingTicks()) / (20.0F * this.drawSpeed);
    }

    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
           tooltip.add(Component.literal(""));
           tooltip.add((Component.translatable(String.format("tooltip.%s.modifiers.longbow.draw_length", "archbows"), (Component.translatable(String.format("tooltip.%s.modifiers.longbow.draw_length.value", "archbows"), (double) drawSpeed / 20)).withStyle(ChatFormatting.GRAY))).withStyle(ChatFormatting.DARK_GREEN));
            tooltip.add((Component.translatable(String.format("tooltip.%s.modifiers.longbow.speed_multiplier", "archbows"), (Component.translatable(String.format("tooltip.%s.modifiers.longbow.draw_length.value", "archbows"), this.maxVelocity)).withStyle(ChatFormatting.GRAY))).withStyle(ChatFormatting.DARK_GREEN));
            tooltip.add(Component.literal(""));




    }
}
