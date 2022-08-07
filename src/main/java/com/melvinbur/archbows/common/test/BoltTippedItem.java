package com.melvinbur.archbows.common.test;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Iterator;
import java.util.List;
/**
public class BoltTippedItem extends BoltItem {
    protected String baseName;

    public BoltTippedItem(String unlocName, String baseName, float damageModifier, float rangeModifier, float armorPiercingFactor) {
        super(unlocName, damageModifier, rangeModifier, armorPiercingFactor);
        this.baseName = baseName;
    }

    public BoltEntity createBolt(Level world, ItemStack stack, LivingEntity shooter) {
        BoltEntity bolt = new BoltEntity(shooter, world);
        ItemStack boltStack = stack.copy();
        boltStack.setCount(1);
        bolt.initEntity(this.damageModifier, this.rangeModifier, this.armorPiercingFactor, boltStack);
        bolt.setPotionEffect(stack);
        return bolt.isValid() ? bolt : null;
    }

    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if (this.allowedIn(group)) {
            Iterator var3 = ForgeRegistries.POTIONS.iterator();

            while(var3.hasNext()) {
                Potion potion = (Potion)var3.next();
                if (!potion.getEffects().isEmpty()) {
                    ItemStack stack = new ItemStack(this);
                    PotionUtils.setPotion(stack, potion);
                    items.add(stack);
                }
            }
        }

    }

    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(Component.literal(""));
        PotionUtils.addPotionTooltip(stack, tooltip, 0.125F);

    }

    public Component getName(ItemStack stack) {
        Potion potion = PotionUtils.getPotion(stack);
        String transKey = potion.getName("item.archbows.proj_tipped.effect.");
        return Component.translatable(transKey, I18n.get("item.archbows." + this.baseName));
    }
}
**/