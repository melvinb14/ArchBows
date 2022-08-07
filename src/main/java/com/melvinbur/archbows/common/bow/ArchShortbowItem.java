package com.melvinbur.archbows.common.bow;

import com.melvinbur.archbows.common.api.BowTier;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.function.Predicate;



public class ArchShortbowItem extends BowItem {

    private final BowTier tier;
    public final float drawSpeed;
    public static float maxBowRange;
    private final ParticleOptions type;

    public ArchShortbowItem (BowTier tier,Properties properties, float drawSpeed, float maxBowRangePar) {
        super(properties);
        this.tier = tier;
        this.drawSpeed = drawSpeed;
        maxBowRange = maxBowRangePar;
        type = null;
    }

    public ArchShortbowItem (BowTier tier,Properties properties, float drawSpeed, float maxBowRangePar, ParticleOptions particles) {
        super(properties);
        this.tier = tier;
        this.drawSpeed = drawSpeed;
        maxBowRange = maxBowRangePar;
        type = particles;
    }
    @Override
    public AbstractArrow customArrow(AbstractArrow arrow) {
        arrow.setBaseDamage(arrow.getBaseDamage() + this.tier.getAttackDamageBonus());
        return arrow;
    }

    public float getDrawSpeed() {
        return Math.max(0, drawSpeed);
    }




    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user,
                                                  InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        boolean bl = !user.getProjectile(itemStack).isEmpty();
        if (!user.getAbilities().instabuild && !bl) {
            return InteractionResultHolder.fail(itemStack);
        } else {
            user.startUsingItem(hand);
            return InteractionResultHolder.consume(itemStack);
        }
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
        return tier.getEnchantmentValue();
    }

    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack ingredient) {
        return this.tier.getRepairIngredient().test(ingredient) || super.isValidRepairItem(stack, ingredient);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level pLevel, List<Component> pTooltipComponents,
                                TooltipFlag pIsAdvanced) {
        super.appendHoverText(stack, pLevel, pTooltipComponents, pIsAdvanced);
        pTooltipComponents.add(Component.empty());
        pTooltipComponents.add(Component.translatable("archbows.bow_stats").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.literal("" + Float.toString(this.tier.getAttackDamageBonus()) + " ")
                .append(Component.translatable("archbows.bow_damage"))
                .withStyle(ChatFormatting.DARK_GREEN));
        pTooltipComponents.add(Component.literal(" ").append(Component.translatable("archbows.bow_draw_speed", (double) drawSpeed / 20).withStyle(ChatFormatting.DARK_GREEN)));


    }
}