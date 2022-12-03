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

        public BooleanValue enableFlax;




        public Data(ForgeConfigSpec.Builder builder) {
            builder.push("World Generation");
            config("enableFlax", enableFlax, builder.comment("Enable generation of Flax").comment("For more option see archbows.server.toml").define("enableFlax", true));
            builder.pop();


        }

        private void config(String name, BooleanValue spec, BooleanValue value) {
            configOptions.put(name, value);
        }
    }


}