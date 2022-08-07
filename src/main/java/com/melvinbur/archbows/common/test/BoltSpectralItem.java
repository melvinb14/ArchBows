package com.melvinbur.archbows.common.test;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;
/**
public class BoltSpectralItem extends BoltItem {
    public BoltSpectralItem(String unlocName, float damageModifier, float rangeModifier, float armorPiercingFactor) {
        super(unlocName, damageModifier, rangeModifier, armorPiercingFactor);
    }

    public BoltEntity createBolt(Level world, ItemStack stack, LivingEntity shooter) {
        BoltEntity bolt = new BoltSpectralEntity(shooter, world);
        bolt.initEntity(this.damageModifier, this.rangeModifier, this.armorPiercingFactor, ItemStack.EMPTY);
        return bolt;
    }

    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(Component.literal(""));
        tooltip.add((Component.translatable("tooltip.archbows.modifiers.projectile.impact.glowing")).withStyle(ChatFormatting.BLUE));

    }
}
**/