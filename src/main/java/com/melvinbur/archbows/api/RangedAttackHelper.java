package com.melvinbur.archbows.api;

import com.melvinbur.archbows.common.bow.ArchBowItem;
import com.melvinbur.archbows.common.bow.ArchCrossbowItem;
import com.melvinbur.archbows.common.bow.ArchShortbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;

import static net.minecraft.world.item.CrossbowItem.containsChargedProjectile;

public class RangedAttackHelper {

    public static float getVanillaArrowVelocity(ItemStack stack, int charge){
        float bowChargeTime = getVanillaBowChargeTime(stack);
        if (bowChargeTime <= 0){
            bowChargeTime = 1;
        }
        float arrowVelocity = (float) charge / bowChargeTime;
        arrowVelocity = (arrowVelocity * arrowVelocity + arrowVelocity * 2.0F) / 3.0F;
        if (arrowVelocity > 1.0F){
            arrowVelocity = 1.0F;
        }
        return arrowVelocity;
    }

    public static float getVanillaBowChargeTime(ItemStack stack){
        int quickChargeLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.QUICK_CHARGE, stack);


        float bowChargeTime = 30 * (Math.max(20.0F - 5 * quickChargeLevel, 0));
        long lastFiredtime = (long)(ArchBowItem.getPowerForTime(22) * (Math.max(20.0F - 5 * quickChargeLevel, 0)));

        if (lastFiredtime > 0){
            return Math.max(bowChargeTime - 5 * quickChargeLevel, 0);
        } else {
            return Math.max(20.0F - 5 * quickChargeLevel, 0);
        }
    }

    public static float getShortBowChargeTime(ItemStack stack){
        int quickChargeLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.QUICK_CHARGE, stack);


        float bowChargeTime = 15 * (Math.max(10.0F - 5 * quickChargeLevel, 0));
        long lastFiredtime = (long)(ArchShortbowItem.getPowerForTime(11) * (Math.max(10.0F - 5 * quickChargeLevel, 0)));

        if (lastFiredtime > 0){
            return Math.max(bowChargeTime - 5 * quickChargeLevel, 0);
        } else {
            return Math.max(10.0F - 5 * quickChargeLevel, 0);
        }
    }


    public static float getVanillaOrModdedCrossbowArrowVelocity(ItemStack stack){
        float arrowVelocity;
        if (stack.getItem() instanceof ArchCrossbowItem){
            arrowVelocity = ((ArchCrossbowItem)stack.getItem()).getProjectileVelocity(stack);
        } else {
            arrowVelocity = containsChargedProjectile(stack, Items.FIREWORK_ROCKET) ? 1.6F : 3.15F;
        }
        return arrowVelocity;
    }

    public static float getVanillaOrModdedBowArrowVelocity(ItemStack stack, int charge){
        float arrowVelocity;
        if (stack.getItem() instanceof ArchBowItem){
            arrowVelocity = ArchBowItem.getBowArrowVelocity(stack, charge);
        } else {
            arrowVelocity = getVanillaArrowVelocity(stack, charge);
        }
        return arrowVelocity;
    }
}