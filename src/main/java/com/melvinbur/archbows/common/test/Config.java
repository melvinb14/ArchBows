package com.melvinbur.archbows.common.test;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.google.common.base.Defaults;
import com.google.common.collect.ImmutableList;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import com.melvinbur.archbows.core.ItemInit;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.commons.lang3.tuple.Pair;
/**
@EventBusSubscriber(
        bus = Bus.MOD
)
public class Config {
    public static final Config INSTANCE;
    public static final ForgeConfigSpec CONFIG_SPEC;





    public ForgeConfigSpec.BooleanValue disableRecipesExplosives;
    public ForgeConfigSpec.BooleanValue disableTerrainDamage;

    public BoltCategory bolt;






    private Config(ForgeConfigSpec.Builder builder) {

        builder.pop();
        builder.push("projectiles");
        this.bolt = new BoltCategory(builder, "", "bolt", 4.0F, 1.0F, 0.25F);



    }


    public static void onConfigLoad(ForgeConfigSpec config, String path) {

       ItemInit.bolt.updateFromConfig(((Double)INSTANCE.bolt.baseDamage.get()).floatValue(), ((Double)INSTANCE.bolt.rangeMultiplier.get()).floatValue(), ((Double)INSTANCE.bolt.armorPiercingFactor.get()).floatValue());
        ItemInit.tippedBolt.updateFromConfig(((Double)INSTANCE.bolt.baseDamage.get()).floatValue(), ((Double)INSTANCE.bolt.rangeMultiplier.get()).floatValue(), ((Double)INSTANCE.bolt.armorPiercingFactor.get()).floatValue());
        ItemInit.spectralBolt.updateFromConfig(((Double)INSTANCE.bolt.baseDamage.get()).floatValue(), ((Double)INSTANCE.bolt.rangeMultiplier.get()).floatValue(), ((Double)INSTANCE.bolt.armorPiercingFactor.get()).floatValue());

        APIConfigValues.damageBonusCheckArmorValue = (Boolean)INSTANCE.damageBonusCheckArmorValue.get();
        APIConfigValues.damageBonusMaxArmorValue = ((Double)INSTANCE.damageBonusMaxArmorValue.get()).floatValue();

    }




  

    static {
        Pair<Config, ForgeConfigSpec> specPair = (new ForgeConfigSpec.Builder()).configure(Config::new);
        INSTANCE = (Config)specPair.getLeft();
        CONFIG_SPEC = (ForgeConfigSpec)specPair.getRight();
    }

    public class BoltCategory {
        public ForgeConfigSpec.DoubleValue baseDamage;
        public ForgeConfigSpec.DoubleValue rangeMultiplier;
        public ForgeConfigSpec.DoubleValue armorPiercingFactor;

        protected BoltCategory(ForgeConfigSpec.Builder builder, String materialName, String projectileName, float baseDamage, float rangeMultiplier, float armorPiercingFactor) {
            String projName = materialName != null && materialName != "" ? materialName + " " + projectileName : projectileName;
            String category = materialName != null && materialName != "" ? materialName + "_" + projectileName : projectileName;
            builder.push(category);
            this.baseDamage = builder.comment("Base damage for " + projName + "s").translation("config.archbows.arrow.base_damage").defineInRange("base_damage", (double)baseDamage, 0.1, 100.0);
            this.rangeMultiplier = builder.comment("Range muliplier for " + projName + "s").translation("config.archbows.arrow.range_multiplier").defineInRange("range_multiplier", (double)rangeMultiplier, 0.1, 100.0);
            this.armorPiercingFactor = builder.comment("Armor Piercing factor for " + projName + "s").translation("config.archbows.bolt.armor_piercing_factor").defineInRange("armor_piercing_factor", (double)armorPiercingFactor, 0.0, 1.0);
            builder.pop();
        }
    }

    public class ProjectileCategory {
        public ForgeConfigSpec.DoubleValue baseDamage;
        public ForgeConfigSpec.DoubleValue rangeMultiplier;

        private ProjectileCategory(ForgeConfigSpec.Builder builder, String materialName, String projectileName, float baseDamage, float rangeMultiplier) {
            String projName = materialName != null && materialName != "" ? materialName + " " + projectileName : projectileName;
            String category = materialName != null && materialName != "" ? materialName + "_" + projectileName : projectileName;
            builder.push(category);
            this.baseDamage = builder.comment("Base damage for " + projName + "s").translation("config.archbows.arrow.base_damage").defineInRange("base_damage", (double)baseDamage, 0.1, 100.0);
            this.rangeMultiplier = builder.comment("Range muliplier for " + projName + "s").translation("config.archbows.arrow.range_multiplier").defineInRange("range_multiplier", (double)rangeMultiplier, 0.1, 100.0);
            builder.pop();
        }
    }



}
**/