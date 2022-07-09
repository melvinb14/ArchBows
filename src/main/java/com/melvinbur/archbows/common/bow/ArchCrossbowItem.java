package com.melvinbur.archbows.common.bow;


import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;


public class ArchCrossbowItem extends CrossbowItem {

    public final Tiers material;
    public final int drawSpeed;
    public final float range;

    public ArchCrossbowItem(Tiers material,Properties properties, int drawSpeed, float range) {
        super(properties);
        this.material = material;
        this.drawSpeed = drawSpeed;
        this.range = range;
    }

    public float getProjectileVelocity(ItemStack stack){
        return containsChargedProjectile(stack, Items.FIREWORK_ROCKET) ? 1.6F : 3.2F;
    }

    @Override
    public int getDefaultProjectileRange() { return (int)range; }

    @Override
    public int getEnchantmentValue() {
        return material.getEnchantmentValue();
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.CROSSBOW;
    }


    public int getDrawSpeed(){
        return this.drawSpeed;
    }

    @Override
    public void appendHoverText(ItemStack stack, Level pLevel, List<Component> pTooltipComponents,
                                TooltipFlag pIsAdvanced) {
        super.appendHoverText(stack, pLevel, pTooltipComponents, pIsAdvanced);
        pTooltipComponents.add(TextComponent.EMPTY);
        pTooltipComponents.add(new TranslatableComponent("archbows.bow_stats").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(new TextComponent(" ").append(new TranslatableComponent("archbows.bow_range", range).withStyle(ChatFormatting.DARK_GREEN)));
        pTooltipComponents.add(new TextComponent(" ").append(new TranslatableComponent("archbows.bow_draw_speed", (double) drawSpeed / 20).withStyle(ChatFormatting.DARK_GREEN)));
    }
}