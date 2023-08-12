package com.melvinbur.archbows.common.weapons.crossbow;


import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.loading.FMLEnvironment;




public class ArbalestItem extends CrossbowItem  {
    public Tiers material;

    public static float  maxVelocity;
    public static int loadTime;
    public boolean startSoundPlayed = false;
    public boolean midLoadSoundPlayed = false;


    public ArbalestItem(Properties properties,float maxVelocity, int loadTime, Tiers material) {
        super(properties);
        this.maxVelocity = maxVelocity;
        this.loadTime = loadTime;
        this.material = material;
    }
    /* Apotheosis Crescendo of bolts enchantment doesnt work because of the [use]*/

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (isCharged(itemstack)) {
            performShooting(level, player, hand, itemstack, getShootingPower(itemstack), 1.0F);
            setCharged(itemstack, false);
            return InteractionResultHolder.consume(itemstack);
        } else if (!player.getProjectile(itemstack).isEmpty()) {
            if (!isCharged(itemstack)) {
                this.startSoundPlayed = false;
                this.midLoadSoundPlayed = false;
                player.startUsingItem(hand);
            }

            return InteractionResultHolder.consume(itemstack);
        } else {
            return InteractionResultHolder.fail(itemstack);
        }
    }
    public static float getShootingPower(ItemStack crossbowStack) {
        return containsChargedProjectile(crossbowStack, Items.FIREWORK_ROCKET) ? 1.6F : maxVelocity;
    }


    public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        int i = this.getUseDuration(stack) - timeLeft;
        float f = getPowerForTime(i, stack);
        if (f >= 1.0F && !isCharged(stack) && tryLoadProjectiles(entityLiving, stack)) {
            setCharged(stack, true);
            SoundSource soundsource = entityLiving instanceof Player ? SoundSource.PLAYERS : SoundSource.HOSTILE;
            level.playSound((Player)null, entityLiving.getX(), entityLiving.getY(), entityLiving.getZ(), SoundEvents.CROSSBOW_LOADING_END, soundsource, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.5F + 1.0F) + 0.2F);
        }

    }
    public static float getPowerForTime(int useTime, ItemStack crossbowStack) {
        float f = (float)useTime  / (float)getChargeDuration(crossbowStack);
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }
    public static boolean tryLoadProjectiles(LivingEntity shooter, ItemStack crossbowStack) {
        int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.MULTISHOT, crossbowStack);
        int j = i == 0 ? 1 : 3;
        boolean flag = shooter instanceof Player && ((Player)shooter).getAbilities().instabuild;
        ItemStack itemstack = shooter.getProjectile(crossbowStack);
        ItemStack itemstack1 = itemstack.copy();

        for(int k = 0; k < j; ++k) {
            if (k > 0) {
                itemstack = itemstack1.copy();
            }

            if (itemstack.isEmpty() && flag) {
                itemstack = new ItemStack(Items.ARROW);
                itemstack1 = itemstack.copy();
            }

            if (!loadProjectile(shooter, crossbowStack, itemstack, k > 0, flag)) {
                return false;
            }
        }

        return true;
    }

    public static boolean loadProjectile(LivingEntity shooter, ItemStack crossbowStack, ItemStack ammoStack, boolean hasAmmo, boolean isCreative) {
        if (ammoStack.isEmpty()) {
            return false;
        } else {
            boolean flag = isCreative && ammoStack.getItem() instanceof ArrowItem;
            ItemStack itemstack;
            if (!flag && !isCreative && !hasAmmo) {
                itemstack = ammoStack.split(1);
                if (ammoStack.isEmpty() && shooter instanceof Player) {
                    ((Player)shooter).getInventory().removeItem(ammoStack);
                }
            } else {
                itemstack = ammoStack.copy();
            }

            addChargedProjectile(crossbowStack, itemstack);
            return true;
        }
    }

    public  static void addChargedProjectile(ItemStack crossbowStack, ItemStack ammoStack) {
        CompoundTag compoundtag = crossbowStack.getOrCreateTag();
        ListTag listtag;
        if (compoundtag.contains("ChargedProjectiles", 9)) {
            listtag = compoundtag.getList("ChargedProjectiles", 10);
        } else {
            listtag = new ListTag();
        }

        CompoundTag compoundtag1 = new CompoundTag();
        ammoStack.save(compoundtag1);
        listtag.add(compoundtag1);
        compoundtag.put("ChargedProjectiles", listtag);
    }


    public static int getChargeDuration(ItemStack crossbowStack) {
        int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.QUICK_CHARGE, crossbowStack);
        return i == 0 ? loadTime : loadTime - getChargeTimeReductionPerQuickChargeLevel() * i;
    }
    public static int getChargeTimeReductionPerQuickChargeLevel() {
        return loadTime / 5;
    }
    @Override
    public int getUseDuration(ItemStack p_40938_) {
        return getChargeDuration(p_40938_) + 3;
    }

    public int getEnchantmentValue() {
        return this.material.getEnchantmentValue();
    }

    public boolean isValidRepairItem(ItemStack stack, ItemStack ingredient) {
        return this.material.getRepairIngredient().test(ingredient) || super.isValidRepairItem(stack, ingredient);
    }
}

