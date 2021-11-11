package com.makotomiyamoto.nt.ntframework.lib.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.makotomiyamoto.nt.ntframework.lib.JsonSerializationAdapter;
import com.makotomiyamoto.nt.ntframework.quest.objective.ActionQuestObjective;

import java.lang.reflect.Type;

public class ActionQuestObjectiveSerializationAdapter extends JsonSerializationAdapter<ActionQuestObjective> {
    @Override
    public JsonElement serialize(ActionQuestObjective src, Type typeOfSrc, JsonSerializationContext context) {
        return super.serialize(src, typeOfSrc, context);
    }

    @Override
    public ActionQuestObjective deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return super.deserialize(json, typeOfT, context);
    }
}
