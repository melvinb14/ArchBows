package com.melvinbur.archbows.common.bow;


import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.event.FOVModifierEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;
import java.util.function.Predicate;

public class ArchFlatbowItem extends  BowItem {

    public final Tiers material;
    public final float drawSpeed;
    public static float maxBowRange;
    private final ParticleOptions type;


    public ArchFlatbowItem(Tiers material, Properties properties, float drawSpeed, float maxBowRangePar) {
        super(properties);
        this.material = material;
        this.drawSpeed = drawSpeed;
        maxBowRange = maxBowRangePar;
        type = null;
    }

    public ArchFlatbowItem(Tiers material, Properties properties, float drawSpeed, float maxBowRangePar, ParticleOptions particles) {
        super(properties);
        this.material = material;
        this.drawSpeed = drawSpeed;
        maxBowRange = maxBowRangePar;
        type = particles;
    }




    public float getDrawSpeed() {
        return Math.max(0, drawSpeed);
    }

    public int getRange() {
        return (int) maxBowRange;
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
        pTooltipComponents.add(TextComponent.EMPTY);
        pTooltipComponents.add(new TranslatableComponent("archbows.bow_stats").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(new TextComponent(" ").append(new TranslatableComponent("archbows.bow_range", maxBowRange).withStyle(ChatFormatting.DARK_GREEN)));
        pTooltipComponents.add(new TextComponent(" ").append(new TranslatableComponent("archbows.bow_draw_speed", (double) drawSpeed / 20).withStyle(ChatFormatting.DARK_GREEN)));
    }

    @SubscribeEvent
    public void getFieldOfViewModifier(FOVModifierEvent event) {
        LivingEntity livingEntity = event.getEntity();
        if (livingEntity.isUsingItem()) {
            {
                {

                    int i = livingEntity.getTicksUsingItem();
                    float f1 = (float) i / 20.0F;
                    if (f1 > 1.0F) {
                        f1 = 1.0F;
                    } else {
                        f1 *= f1;
                    }

                    f1 *= 1.0F - f1 * 0.15F;

                    event.setNewfov(Mth.lerp(Minecraft.getInstance().options.fovEffectScale, 1.0F, f1));

                }
            }
        }
    }
}
