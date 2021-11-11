package com.makotomiyamoto.nt.ntframework.lib.adapters;

import com.google.gson.*;
import com.makotomiyamoto.nt.ntframework.lib.JsonSerializationAdapter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Type;

public class ItemStackSerializationAdapter extends JsonSerializationAdapter<ItemStack> {
    @Override
    public JsonElement serialize(ItemStack src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        // TODO note that there's going to be much more than this and this is just for testing purposes

        jsonObject.addProperty("material", src.getType().toString());
        jsonObject.addProperty("amount", src.getAmount());

        return jsonObject;
    }

    @Override
    public ItemStack deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject itemStackJsonObject = (JsonObject) json;
        return new ItemStack(Material.valueOf(itemStackJsonObject.get("material").getAsString()), itemStackJsonObject.get("amount").getAsInt());
    }
}
