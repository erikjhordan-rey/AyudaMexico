package io.github.erikcaffrey.ayudamexico.support.model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by silmood on 9/24/17.
 */

public class SupportSpotDeserializer implements JsonDeserializer<List<SupportSpot>> {

    private static final String KEY_RECORDS = "records";
    public static final String KEY_FIELDS = "fields";

    @Override
    public List<SupportSpot> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        List<SupportSpot> spots = new ArrayList<>();

        JsonArray array = json.getAsJsonObject()
                .get(KEY_RECORDS)
                .getAsJsonArray();

        for (JsonElement item : array) {
            JsonObject data = item.getAsJsonObject().getAsJsonObject(KEY_FIELDS);
            SupportSpot spot = gson.fromJson(data, SupportSpot.class);
            spots.add(spot);
        }

        return spots;
    }
}
