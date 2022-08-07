package com.melvinbur.archbows.common.bow;


import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;

import java.util.List;


public class ArchCrossbowItem extends CrossbowItem {

    private final Tiers tier;

    public final int drawSpeed;
    public final float range;

    public ArchCrossbowItem(Tiers tier, Properties properties,  int drawSpeed, float range) {
        super(properties);
        this.tier = tier;
        this.drawSpeed = drawSpeed;
        this.range = range;
    }




    public float getProjectileVelocity(ItemStack stack){
        return containsChargedProjectile(stack, Items.FIREWORK_ROCKET) ? 1.6F : 3.20F;
    }



    @Override
    public int getDefaultProjectileRange() { return (int)range; }

    @Override
    public int getEnchantmentValue() {
        return tier.getEnchantmentValue();
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.CROSSBOW;
    }


    public int getDrawSpeed(){
        return this.drawSpeed;
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
        pTooltipComponents.add(Component.literal(" ").append(Component.translatable("archbows.bow_draw_speed", (double) drawSpeed / 20).withStyle(ChatFormatting.DARK_GREEN)));


    }
}