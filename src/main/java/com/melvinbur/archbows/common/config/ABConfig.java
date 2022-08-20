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

        public  static final int xzspread = 6;
        public  static final int yspread = 2;
        public  static final int patchtries = 16;
        public  static final int arbalestDurability = 625;
        public  static final int pistolDurability = 415;
        public  static final int shortbowDurability = 360;
        public  static final int recurvebowDurability = 410;
        public  static final int flatbowDurability = 435;
        public  static final int longbowDurability = 455;

        public  static final int arbalestLoadTime = 35;

        public  static final int arbalestAimTime = 10;

        public  static final double arbalestVelocity = 1.6F;

        public  static final int pistolLoadTime = 15;

        public  static final int pistolAimTime = 10;

        public  static final double pistolVelocity = 0.85F;

        public  static final double shortbowSpeed = 10f;

        public  static final double shortbowVelocity = 0.55F;

        public  static final double recurvebowSpeed = 23f;

        public  static final double recurveVelocity = 1.25F;

        public  static final double flatbowSpeed = 31f;

        public  static final double flatbowVelocity = 1.5F;

        public  static final double longbowSpeed = 45f;

        public  static final double longbowVelocity = 1.75F;




        public final ForgeConfigSpec.ConfigValue<Integer> FLAX_PATCH_TRIES;
        public final ForgeConfigSpec.ConfigValue<Integer> FLAX_XZ_SPREAD;
        public final ForgeConfigSpec.ConfigValue<Integer> FLAX_Y_SPREAD;

        public final ForgeConfigSpec.ConfigValue<Integer> shortBowDurability;
        public final ForgeConfigSpec.ConfigValue<Integer> recurveBowDurability;
        public final ForgeConfigSpec.ConfigValue<Integer> flatBowDurability;
        public final ForgeConfigSpec.ConfigValue<Integer> longBowDurability;



        public final ForgeConfigSpec.ConfigValue<Double> shortDrawspeed;
        public final ForgeConfigSpec.ConfigValue<Double> ShortBowProjectileVelocity;
        public final ForgeConfigSpec.ConfigValue<Double> recurveDrawspeed;
        public final ForgeConfigSpec.ConfigValue<Double> RecurveBowProjectileVelocity;
        public final ForgeConfigSpec.ConfigValue<Double> flatDrawspeed;
        public final ForgeConfigSpec.ConfigValue<Double> FlatBowProjectileVelocity;
        public final ForgeConfigSpec.ConfigValue<Double> longDrawspeed;
        public final ForgeConfigSpec.ConfigValue<Double> LongBowProjectileVelocity;







        ArchBowsConfig(final ForgeConfigSpec.Builder BUILDER) {
            BUILDER.push("Arch Bows");

            BUILDER.push("requires-game-restart");

            FLAX_XZ_SPREAD = BUILDER
                    .worldRestart()
                    .comment("Spawn flax on average every 'xz' chunks. Increases spawn frequency")
                    .define("Flax xz spread", xzspread);

            FLAX_Y_SPREAD = BUILDER
                    .worldRestart()
                    .comment("Spawn flax on average every 'y' chunks. Increases spawn frequency")
                    .define("Flax y spread", yspread);

            FLAX_PATCH_TRIES = BUILDER
                    .worldRestart()
                    .comment("How many attempts spawning flax. Increases spawn frequency")
                    .define("Flax attempts_per_patch", patchtries);


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




            shortDrawspeed = BUILDER
                    .comment("Short Bow Drawspeed, Default=10")
                    .defineInRange("Short Bow drawspeed modifier", shortbowSpeed, 0.1D, Float.MAX_VALUE);

            ShortBowProjectileVelocity = BUILDER
                    .comment("Multiplier for the projectile speed for projectiles shot from short bow, Default=0.55")
                    .defineInRange("Short Bow projectile speed multiplier", shortbowVelocity, 0.1D, Float.MAX_VALUE);

            recurveDrawspeed = BUILDER
                    .comment("Recurve Bow Drawspeed, Default=23")
                    .defineInRange("Recurve Bow drawspeed modifier", recurvebowSpeed, 0.1D, Float.MAX_VALUE);

            RecurveBowProjectileVelocity = BUILDER
                    .comment("Multiplier for the projectile speed for projectiles shot from recurve bow, Default=1.25")
                    .defineInRange("Recurve Bow projectile speed multiplier", recurveVelocity, 0.1D, Float.MAX_VALUE);

            flatDrawspeed = BUILDER
                    .comment("Flat Bow Drawspeed, Default=31")
                    .defineInRange("Flat Bow drawspeed modifier", flatbowSpeed, 0.1D, Float.MAX_VALUE);

            FlatBowProjectileVelocity = BUILDER
                    .comment("Multiplier for the projectile speed for projectiles shot from flat bow, Default=1.5")
                    .defineInRange("Flat Bow projectile speed multiplier", flatbowVelocity, 0.1D, Float.MAX_VALUE);

            longDrawspeed = BUILDER
                    .comment("LongBow Drawspeed, Default=45")
                    .defineInRange("Long Bow drawspeed modifier", longbowSpeed, 0.1D, Float.MAX_VALUE);

            LongBowProjectileVelocity = BUILDER
                    .comment("Multiplier for the projectile speed for projectiles shot from long bow, Default=1.75")
                    .defineInRange("Long Bow projectile speed multiplier", longbowVelocity, 0.1D, Float.MAX_VALUE);




            BUILDER.pop();







        }
    }

}