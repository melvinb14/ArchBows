package com.melvinbur.archbows.common.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;

public class ABConfig {
    public static final ArchBowsConfig CONFIG;
    public static final ForgeConfigSpec CONFIG_SPEC;
    static {
        final Pair<ArchBowsConfig, ForgeConfigSpec> serverSpecPair = new ForgeConfigSpec.Builder().configure(ArchBowsConfig::new);
        CONFIG = serverSpecPair.getLeft();
        CONFIG_SPEC = serverSpecPair.getRight();
    }

    public static void loadConfig(ForgeConfigSpec config, String path) {
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave()
                .writingMode(WritingMode.REPLACE).build();
        file.load();
        config.setConfig(file);
    }

    public static class ArchBowsConfig {


        public  static final int arbalestDurability = 625;
        public  static final int pistolDurability = 415;
        public  static final int shortbowDurability = 360;
        public  static final int recurvebowDurability = 410;
        public  static final int flatbowDurability = 435;
        public  static final int longbowDurability = 455;

        public  static final int xzspread = 6;
        public  static final int yspread = 2;
        public  static final int patchtries = 16;


        public final ForgeConfigSpec.ConfigValue<Integer> heavyCrossbowDurability;
        public final ForgeConfigSpec.ConfigValue<Integer> pistolCrossbowDurability;
        public final ForgeConfigSpec.ConfigValue<Integer> shortBowDurability;
        public final ForgeConfigSpec.ConfigValue<Integer> recurveBowDurability;
        public final ForgeConfigSpec.ConfigValue<Integer> flatBowDurability;
        public final ForgeConfigSpec.ConfigValue<Integer> longBowDurability;


        public final ForgeConfigSpec.ConfigValue<Integer> heavyLoadTime;
        public final ForgeConfigSpec.ConfigValue<Integer> heavyAimTime;
        public final ForgeConfigSpec.ConfigValue<Float> HeavyCrossbowProjectileVelocity;
        public final ForgeConfigSpec.ConfigValue<Integer> smallLoadTime;
        public final ForgeConfigSpec.ConfigValue<Integer> smallAimTime;
        public final ForgeConfigSpec.ConfigValue<Float> PistolCrossbowProjectileVelocity;
        public final ForgeConfigSpec.ConfigValue<Float> shortDrawspeed;
        public final ForgeConfigSpec.ConfigValue<Float> ShortBowProjectileVelocity;
        public final ForgeConfigSpec.ConfigValue<Float> recurveDrawspeed;
        public final ForgeConfigSpec.ConfigValue<Float> RecurveBowProjectileVelocity;
        public final ForgeConfigSpec.ConfigValue<Float> flatDrawspeed;
        public final ForgeConfigSpec.ConfigValue<Float> FlatBowProjectileVelocity;
        public final ForgeConfigSpec.ConfigValue<Float> longDrawspeed;
        public final ForgeConfigSpec.ConfigValue<Float> LongBowProjectileVelocity;

        public final ForgeConfigSpec.ConfigValue<Integer> FLAX_PATCH_TRIES;
        public final ForgeConfigSpec.ConfigValue<Integer> FLAX_XZ_SPREAD;
        public final ForgeConfigSpec.ConfigValue<Integer> FLAX_Y_SPREAD;





        ArchBowsConfig(final ForgeConfigSpec.Builder BUILDER) {
            BUILDER.push("Arch Bows");

            BUILDER.push("requires-game-restart");

            FLAX_XZ_SPREAD = BUILDER
                    .worldRestart()
                    .comment("Spawn flax on average every 'xz' chunks. Increases spawn frequency")
                    .define("xz spread", xzspread);

            FLAX_Y_SPREAD = BUILDER
                    .worldRestart()
                    .comment("Spawn flax on average every 'y' chunks. Increases spawn frequency")
                    .define("y spread", yspread);

            FLAX_PATCH_TRIES = BUILDER
                    .worldRestart()
                    .comment("How many attempts spawning flax. Increases spawn frequency")
                    .define("attempts_per_patch", patchtries);

            heavyCrossbowDurability  = BUILDER
                    .worldRestart()
                    .define("Arbalest durability",  arbalestDurability);

            pistolCrossbowDurability = BUILDER
                    .worldRestart()
                    .define("Pistol Crossbow durability", pistolDurability);

            shortBowDurability = BUILDER
                    .worldRestart()
                    .define("Short Bow durability", shortbowDurability);

            recurveBowDurability = BUILDER
                    .worldRestart()
                    .define("Recurve Bow durability", recurvebowDurability);

            flatBowDurability = BUILDER
                    .worldRestart()
                    .define("Flat Bow durability", flatbowDurability);

            longBowDurability = BUILDER
                    .worldRestart()
                    .define("Long Bow durability", longbowDurability);


            BUILDER.pop();
            heavyLoadTime = BUILDER
                    .comment("Arbalest Load Time, Default=35")
                    .define("Arbalest load-time modifier", 35);

            heavyAimTime = BUILDER
                    .comment("Arbalest Aim Time, Default=10")
                    .define("Arbalest aim-time modifier", 10);

            HeavyCrossbowProjectileVelocity = BUILDER
                    .comment("Multiplier for the projectile speed for projectiles shot from arbalest, Default=1.6")
                    .define("Arbalest projectile speed multiplier", 1.6F);

            smallLoadTime = BUILDER
                    .comment("Pistol Crossbow Load Time, Default=15")
                    .define("Pistol Crossbow load-time modifier", 15);

            smallAimTime = BUILDER
                    .comment("Pistol Crossbow Aim Time, Default=10")
                    .define("Pistol Crossbow aim-time modifier", 10);

            PistolCrossbowProjectileVelocity = BUILDER
                    .comment("Multiplier for the projectile speed for projectiles shot from  pistol crossbow, Default=0.85")
                    .define("Pistol Crossbow projectile speed multiplier", 0.85F);


            shortDrawspeed = BUILDER
                    .comment("Short Bow Drawspeed, Default=10")
                    .define("Short Bow drawspeed modifier", 10f);

            ShortBowProjectileVelocity = BUILDER
                    .comment("Multiplier for the projectile speed for projectiles shot from short bow, Default=1.6")
                    .define("Short Bow projectile speed multiplier", 0.55F);

            recurveDrawspeed = BUILDER
                    .comment("Recurve Bow Drawspeed, Default=23")
                    .define("Recurve Bow drawspeed modifier", 23f);

            RecurveBowProjectileVelocity = BUILDER
                    .comment("Multiplier for the projectile speed for projectiles shot from recurve bow, Default=1.6")
                    .define("Recurve Bow projectile speed multiplier", 1.25F);

            flatDrawspeed = BUILDER
                    .comment("Flat Bow Drawspeed, Default=31")
                    .define("Flat Bow drawspeed modifier", 31f);

            FlatBowProjectileVelocity = BUILDER
                    .comment("Multiplier for the projectile speed for projectiles shot from flat bow, Default=1.6")
                    .define("Flat Bow projectile speed multiplier", 1.5F);

            longDrawspeed = BUILDER
                    .comment("LongBow Drawspeed, Default=45")
                    .define("Long Bow drawspeed modifier", 45f);

            LongBowProjectileVelocity = BUILDER
                    .comment("Multiplier for the projectile speed for projectiles shot from long bow, Default=1.6")
                    .define("Long Bow projectile speed multiplier", 1.75F);




            BUILDER.pop();







        }
    }

}

