package com.melvinbur.archbows.common.config;


import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;



import java.util.HashMap;

public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final Data CONFIG_DATA = new Data(BUILDER);
    public static final ForgeConfigSpec CONFIG = BUILDER.build();

    public static class Data {

        public HashMap<String, BooleanValue> configOptions = new HashMap<>();

        public BooleanValue enablePlainsFlax;
        public BooleanValue enableDesertFlax;




        public Data(ForgeConfigSpec.Builder builder) {
            builder.push("World Generation");
            config("enablePlainsFlax", enablePlainsFlax, builder.comment("Enable generation of Blue Flax in #forge:is_plains").define("enablePlainsFlax", true));
            config("enableDesertFlax", enableDesertFlax, builder.comment("Enable generation of Blue Flax in #forge:is_desert and #forge:is_sandy").define("enableDesertFlax", true));
            builder.pop();


        }

        private void config(String name, BooleanValue spec, BooleanValue value) {
            configOptions.put(name, value);
        }
    }
}