package com.example.carehub.models;

import org.json.JSONException;
import org.json.JSONObject;

public class DailyQuote {

    private static String quote;

    public DailyQuote(JSONObject jsonObject) throws JSONException {

        quote = jsonObject.getString("quote");


    }


    public static String getQuote() {
        return quote;
    }
}
