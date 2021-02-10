package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        final String NAME = "name";
        final String MAIN_NAME = "mainName";
        final String ALSO_KNOWN_AS = "alsoKnownAs";
        final String PLACE_OF_ORIGIN = "placeOfOrigin";
        final String DESCRIPTION = "description";
        final String IMAGE = "image";
        final String INGREDIENTS = "ingredients";

        JSONObject sandwichJson = new JSONObject(json);
        JSONObject nameJson = sandwichJson.getJSONObject(NAME);
        JSONArray alsoKnownAsJArray = nameJson.getJSONArray(ALSO_KNOWN_AS);
        List<String> alsoKnownAsList = new ArrayList<>();
        if (alsoKnownAsJArray != null) {
            for (int i = 0; i < alsoKnownAsJArray.length(); i++){
                alsoKnownAsList.add(alsoKnownAsJArray.getString(i));
            }
        }

        JSONArray ingredientsJArray = sandwichJson.getJSONArray(INGREDIENTS);
        List<String> ingredientsList = new ArrayList<>();
        if (ingredientsJArray != null) {
            for (int i = 0; i < ingredientsJArray.length(); i++){
                ingredientsList.add(ingredientsJArray.getString(i));
            }
        }

        return new Sandwich(
            nameJson.getString(MAIN_NAME),
            alsoKnownAsList,
            sandwichJson.getString(PLACE_OF_ORIGIN),
            sandwichJson.getString(DESCRIPTION),
            sandwichJson.getString(IMAGE),
            ingredientsList
        );
    }
}
