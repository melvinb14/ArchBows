package com.melvinbur.archbows.common.bow;


import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.function.Predicate;

import static com.melvinbur.archbows.api.RangedAttackHelper.getVanillaBowChargeTime;

public class ArchBowItem extends BowItem  {

    public final Tiers material;
    public final float drawSpeed;
    public static float maxBowRange;
    private final ParticleOptions type;


    public ArchBowItem (Tiers material, Properties properties, float drawSpeed, float maxBowRangePar) {
        super(properties);
        this.material = material;
        this.drawSpeed = drawSpeed;
        maxBowRange = maxBowRangePar;
        type = null;
    }

    public ArchBowItem (Tiers material, float drawSpeed,Properties properties, float maxBowRangePar,ParticleOptions particles) {
        super(properties);
        this.material = material;
        this.drawSpeed = drawSpeed;
        maxBowRange = maxBowRangePar;
        type = particles;
    }


    public float getDrawSpeed() {
        return Math.max(0, drawSpeed);
    }

    public static float getBowArrowVelocity(ItemStack stack, int charge) {
        float bowChargeTime = getVanillaBowChargeTime(stack);
        if (bowChargeTime <= 0){
            bowChargeTime = 1;
        }

        float arrowVelocity = (float) charge / 30;
        arrowVelocity = (arrowVelocity * arrowVelocity + arrowVelocity * 2.0F) / 3.0F;
        if (arrowVelocity > 1.0F) {
            arrowVelocity = 1.0F;
        }

        return arrowVelocity;
    }


    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_ONLY;
    }

    @Override
    public int getDefaultProjectileRange() {
        return (int) maxBowRange;
    }

    @Override
    public int getEnchantmentValue() {
        return material.getEnchantmentValue();
    }

    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack ingredient) {
        return this.material.getRepairIngredient().test(ingredient) || super.isValidRepairItem(stack, ingredient);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level pLevel, List<Component> pTooltipComponents,
                                TooltipFlag pIsAdvanced) {
        super.appendHoverText(stack, pLevel, pTooltipComponents, pIsAdvanced);
        pTooltipComponents.add(Component.empty());
        pTooltipComponents.add(Component.translatable("archbows.bow_stats").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.literal(" ").append(Component.translatable("archbows.bow_range", maxBowRange).withStyle(ChatFormatting.DARK_GREEN)));
        pTooltipComponents.add(Component.literal(" ").append(Component.translatable("archbows.bow_draw_speed", (double) drawSpeed / 20).withStyle(ChatFormatting.DARK_GREEN)));
    }
}