package com.redfin.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonUtils {
    public static String extractSecondJsonObject(String responseBody) {
        Pattern pattern = Pattern.compile("\\{.*?\\&&(.*)}");
        Matcher matcher = pattern.matcher(responseBody);

        if (matcher.find()) {
            return matcher.group(1) + "}";
        } else {
            throw new IllegalStateException("Unable to extract the second JSON object from response");
        }
    }
    public static JsonObject parseJsonObject(String jsonString){
        Gson gson = new Gson();
        return gson.fromJson(jsonString, JsonObject.class);
    }

}
