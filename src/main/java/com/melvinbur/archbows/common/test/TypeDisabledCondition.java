package com.melvinbur.archbows.common.test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TypeDisabledCondition implements ICondition {
    public static final List<String> disabledRecipeTypes = new ArrayList();

    public static final String LONGBOW = "longbow";
    public static final String HEAVY_CROSSBOW = "heavy_crossbow";
    public static final String BOLTS = "bolts";

    public static final String LEAD = "lead";
    private static final ResourceLocation NAME = new ResourceLocation("archbows", "type_disabled");
    private final List<String> types;

    public TypeDisabledCondition(List<String> types) {
        this.types = types;
    }

    public ResourceLocation getID() {
        return NAME;
    }



    public boolean test(IContext context) {
        Iterator var1 = this.types.iterator();

        String type;
        do {
            if (!var1.hasNext()) {
                return true;
            }

            type = (String)var1.next();
        } while(!disabledRecipeTypes.contains(type));

        return false;
    }

    public static class Serializer implements IConditionSerializer<TypeDisabledCondition> {
        public static final Serializer INSTANCE = new Serializer();

        public Serializer() {
        }

        public void write(JsonObject json, TypeDisabledCondition value) {
            JsonArray array = new JsonArray();
            Iterator var4 = value.types.iterator();

            while(var4.hasNext()) {
                String type = (String)var4.next();
                array.add(type);
            }

            json.add("disabled", array);
        }

        public TypeDisabledCondition read(JsonObject json) {
            JsonArray array = GsonHelper.getAsJsonArray(json, "disabled");
            List<String> typeList = new ArrayList();

            for(int i = 0; i < array.size(); ++i) {
                String str = array.get(i).getAsString();
                typeList.add(str);
            }

            return new TypeDisabledCondition(typeList);
        }

        public ResourceLocation getID() {
            return TypeDisabledCondition.NAME;
        }
    }
}
