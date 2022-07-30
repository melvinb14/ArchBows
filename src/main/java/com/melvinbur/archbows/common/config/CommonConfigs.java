package com.melvinbur.archbows.common.config;

import net.minecraftforge.common.ForgeConfigSpec;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class CommonConfigs {/*




    public static ForgeConfigSpec SERVER_SPEC;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        spawn.init(builder);
        SERVER_SPEC = builder.build();
    }


    public static class spawn {
        public static ForgeConfigSpec.BooleanValue FLAX_ENABLED;
        public static ForgeConfigSpec.IntValue FLAX_PATCH_TRIES;
        public static ForgeConfigSpec.IntValue FLAX_AVERAGE_EVERY;





        private static void init(ForgeConfigSpec.Builder builder) {

            builder.comment("Configure spawning conditions")
                    .push("spawns");

            builder.push("flax");
            FLAX_ENABLED = builder.define("enabled", true);
            FLAX_AVERAGE_EVERY = builder.comment("Spawn wild flax on average every 'x' chunks. Increases spawn frequency")
                    .defineInRange("rarity", 6, 1, 100);
            FLAX_PATCH_TRIES = builder.comment("Attempts at every patch to spawn 1 block. Increases average patch size")
                    .defineInRange("attempts_per_patch", 35, 1, 100);
            builder.pop();
        }
    }
*/
}