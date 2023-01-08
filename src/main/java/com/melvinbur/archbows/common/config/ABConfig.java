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


        public final ForgeConfigSpec.ConfigValue<Integer> arbalestDurability;
        public final ForgeConfigSpec.ConfigValue<Integer> pistolCrossbowDurability;
        public final ForgeConfigSpec.ConfigValue<Integer> heavyCrossbowDurability;
        public final ForgeConfigSpec.ConfigValue<Integer> shortBowDurability;
        public final ForgeConfigSpec.ConfigValue<Integer> recurveBowDurability;
        public final ForgeConfigSpec.ConfigValue<Integer> flatBowDurability;
        public final ForgeConfigSpec.ConfigValue<Integer> longBowDurability;




        public final ForgeConfigSpec.ConfigValue<Integer> arbalestLoadTime;
        public final ForgeConfigSpec.ConfigValue<Integer> arbalestAimTime;
        public final ForgeConfigSpec.ConfigValue<Double> ArbalestProjectileVelocity;
        public final ForgeConfigSpec.ConfigValue<Integer> pistolcrossbowLoadTime;
        public final ForgeConfigSpec.ConfigValue<Integer> pistolcrossbowAimTime;
        public final ForgeConfigSpec.ConfigValue<Double> PistolCrossbowProjectileVelocity;

        public final ForgeConfigSpec.ConfigValue<Integer> heavycrossbowLoadTime;
        public final ForgeConfigSpec.ConfigValue<Integer> heavycrossbowAimTime;
        public final ForgeConfigSpec.ConfigValue<Double> HeavyCrossbowProjectileVelocity;
        public final ForgeConfigSpec.ConfigValue<Double> shortbowDrawspeed;
        public final ForgeConfigSpec.ConfigValue<Double> ShortBowProjectileVelocity;
        public final ForgeConfigSpec.ConfigValue<Double> recurvebowDrawspeed;
        public final ForgeConfigSpec.ConfigValue<Double> RecurveBowProjectileVelocity;
        public final ForgeConfigSpec.ConfigValue<Double> flatbowDrawspeed;
        public final ForgeConfigSpec.ConfigValue<Double> FlatBowProjectileVelocity;
        public final ForgeConfigSpec.ConfigValue<Double> longbowDrawspeed;
        public final ForgeConfigSpec.ConfigValue<Double> LongBowProjectileVelocity;

        public final ForgeConfigSpec.ConfigValue<Integer> flax1Tries;
        public final ForgeConfigSpec.ConfigValue<Integer> flax1XZspread;
        public final ForgeConfigSpec.ConfigValue<Integer> flax1Yspread;
        public final ForgeConfigSpec.ConfigValue<Integer> flax2Tries;
        public final ForgeConfigSpec.ConfigValue<Integer> flax2XZspread;
        public final ForgeConfigSpec.ConfigValue<Integer> flax2Yspread;


        ArchBowsConfig(final ForgeConfigSpec.Builder BUILDER) {


            BUILDER.comment("Configure weapons conditions")
                    .push("weapons");

            arbalestLoadTime = BUILDER.comment("Arbalest Load Time, Default=35")
                    .define("arbalest_load-time_modifier", 35);

            arbalestAimTime = BUILDER.comment("Arbalest Aim Time, Default=10")
                    .define("arbalest_aim-time_modifier", 10);

            ArbalestProjectileVelocity = BUILDER.comment("Multiplier for the projectile speed for projectiles shot from Arbalest, Default=1.6")
                    .defineInRange("arbalest_projectile_speed_multiplier", 1.6F, 0.1D, Float.MAX_VALUE);

            pistolcrossbowLoadTime = BUILDER.comment("Pistol Crossbow Load Time, Default=15")
                    .define("pistol_crossbow_load-time_modifier", 15);

            pistolcrossbowAimTime = BUILDER.comment("Pistol Crossbow Aim Time, Default=10")
                    .define("pistol_crossbow_aim-time_modifier", 10);

            PistolCrossbowProjectileVelocity = BUILDER.comment("Multiplier for the projectile speed for projectiles shot from  Pistol Crossbow, Default=0.85")
                    .defineInRange("pistol_crossbow_projectile_speed_multiplier", 0.85F, 0.1D, Float.MAX_VALUE);

            heavycrossbowLoadTime = BUILDER.comment("Heavy Crossbow Load Time, Default=25")
                    .define("heavy_crossbow_load-time_modifier", 25);

            heavycrossbowAimTime = BUILDER.comment("Heavy Crossbow Aim Time, Default=10")
                    .define("heavy_crossbow_aim-time_modifier", 10);

            HeavyCrossbowProjectileVelocity = BUILDER.comment("Multiplier for the projectile speed for projectiles shot from  Heavy Crossbow, Default=1.45")
                    .defineInRange("heavy_crossbow_projectile_speed_multiplier", 1.45F, 0.1D, Float.MAX_VALUE);

            shortbowDrawspeed = BUILDER.comment("Short Bow Drawspeed, Default=10")
                    .defineInRange("short_bow_drawspeed_modifier", 10f, 0.1D, Float.MAX_VALUE);

            ShortBowProjectileVelocity = BUILDER.comment("Multiplier for the projectile speed for projectiles shot from Short Bow, Default=0.55")
                    .defineInRange("short_bow_projectile_speed_multiplier", 0.55F, 0.1D, Float.MAX_VALUE);

            recurvebowDrawspeed = BUILDER.comment("Recurve Bow Drawspeed, Default=23")
                    .defineInRange("recurve_bow_drawspeed_modifier", 23f, 0.1D, Float.MAX_VALUE);

            RecurveBowProjectileVelocity = BUILDER.comment("Multiplier for the projectile speed for projectiles shot from Recurve Bow, Default=1.25")
                    .defineInRange("recurve_bow_projectile_speed_multiplier", 1.25F, 0.1D, Float.MAX_VALUE);

            flatbowDrawspeed = BUILDER.comment("Flat Bow Drawspeed, Default=31")
                    .defineInRange("flat_bow_drawspeed_modifier", 31f, 0.1D, Float.MAX_VALUE);

            FlatBowProjectileVelocity = BUILDER.comment("Multiplier for the projectile speed for projectiles shot from Flat Bow, Default=1.35")
                    .defineInRange("flat_bow_projectile_speed_multiplier", 1.35F, 0.1D, Float.MAX_VALUE);

            longbowDrawspeed = BUILDER.comment("Long Bow Drawspeed, Default=45")
                    .defineInRange("long_bow_drawspeed_modifier", 45f, 0.1D, Float.MAX_VALUE);

            LongBowProjectileVelocity = BUILDER.comment("Multiplier for the projectile speed for projectiles shot from Long Bow, Default=1.6")
                    .defineInRange("long_bow_projectile_speed_multiplier", 1.6F, 0.1D, Float.MAX_VALUE);

            BUILDER.pop();

            BUILDER.push("requires-game-restart");
            arbalestDurability = BUILDER
                    .worldRestart()
                    .define("arbalest_durability", 825);

            pistolCrossbowDurability = BUILDER
                    .worldRestart()
                    .define("pistol_crossbow_durability", 415);

            heavyCrossbowDurability = BUILDER
                    .worldRestart()
                    .define("heavy_crossbow_durability", 625);

            shortBowDurability = BUILDER
                    .worldRestart()
                    .define("short_bow_durability", 360);

            recurveBowDurability = BUILDER
                    .worldRestart()
                    .define("recurve_bow_durability", 410);

            flatBowDurability = BUILDER
                    .worldRestart()
                    .define("flat_bow_durability", 435);

            longBowDurability = BUILDER
                    .worldRestart()
                    .define("long_bow_durability", 455);

            BUILDER.pop();
            BUILDER.push("World-Generation");

            flax1Tries = BUILDER.comment("#forge:is_plains, Default=15")
                    .worldRestart()
                    .define("flax1Tries", 15);
            flax1XZspread =  BUILDER.comment("#forge:is_plains, Default=7")
                    .worldRestart()
                    .define("flax1XZspread", 7);
            flax1Yspread =  BUILDER.comment("#forge:is_plains, Default=4")
                    .worldRestart()
                    .define("flax1Yspread", 4);
            flax2Tries = BUILDER.comment("#forge:is_desert and #forge:is_sandy, Default=15")
                    .worldRestart()
                    .define("flax2Tries", 15);
            flax2XZspread =  BUILDER.comment("#forge:is_desert and #forge:is_sandy, Default=7")
                    .worldRestart()
                    .define("flax2XZspread", 7);
            flax2Yspread =  BUILDER.comment("#forge:is_desert and #forge:is_sandy, Default=4")
                    .worldRestart()
                    .define("flax2Yspread", 4);
            BUILDER.pop();




        }
    }
}




