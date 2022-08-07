package com.melvinbur.archbows.common.test;

import com.melvinbur.archbows.core.CreativeModeTabInit;
import com.melvinbur.archbows.core.ItemInit;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import java.util.List;
/**
public class BoltItem extends Item {
    protected float damageModifier = 4.0F;
    protected float rangeModifier = 1.0F;
    protected float armorPiercingFactor = 0.25F;

    public BoltItem(String unlocName, float damageModifier, float rangeModifier, float armorPiercingFactor) {
        super((new Properties()).tab(CreativeModeTabInit.ARCHBOWS_TAB));
        this.damageModifier = damageModifier;
        this.rangeModifier = rangeModifier;
        this.armorPiercingFactor = armorPiercingFactor;
    }

    public BoltEntity createBolt(Level world, ItemStack stack, LivingEntity shooter) {
        BoltEntity bolt = new BoltEntity(shooter, world);
        ItemStack boltStack = stack.copy();
        boltStack.setCount(1);
        bolt.initEntity(this.damageModifier, this.rangeModifier, this.armorPiercingFactor, boltStack);
        return bolt.isValid() ? bolt : null;
    }

    public boolean isInfinite(ItemStack stack, ItemStack crossbow, Player player) {
        int enchant = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, crossbow);
        return enchant <= 0 ? false : this.getClass() == BoltItem.class;
    }

    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add((Component.translatable("tooltip.archbows.modifiers.projectile.base_damage", (Component.translatable("tooltip.archbows.modifiers.projectile.base_damage.value", this.damageModifier)).withStyle(ChatFormatting.GRAY))).withStyle(ChatFormatting.DARK_GREEN));
        tooltip.add((Component.translatable("tooltip.archbows.modifiers.projectile.range", (Component.translatable("tooltip.archbows.modifiers.projectile.range.value", this.rangeModifier)).withStyle(ChatFormatting.GRAY))).withStyle(ChatFormatting.DARK_GREEN));
        tooltip.add((Component.translatable("tooltip.archbows.modifiers.projectile.armor_piercing_factor", (Component.translatable("tooltip.archbows.modifiers.projectile.armor_piercing_factor.value", this.armorPiercingFactor * 100.0F)).withStyle(ChatFormatting.GRAY))).withStyle(ChatFormatting.DARK_GREEN));

    }

    public void updateFromConfig(float damageModifier, float rangeModifier, float armorPiercingFactor) {
        this.damageModifier = damageModifier;
        this.rangeModifier = rangeModifier;
        this.armorPiercingFactor = armorPiercingFactor;
    }
}
 **/