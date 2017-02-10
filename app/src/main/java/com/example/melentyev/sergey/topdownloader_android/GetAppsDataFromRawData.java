package com.example.melentyev.sergey.topdownloader_android;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

class GetAppsDataFromRawData {
    private List<ApplicationData> appsList;

    GetAppsDataFromRawData() {
        this.appsList = new ArrayList<>();
    }

    List<ApplicationData> parseRawDataToJson (String rawStr) {
        if (rawStr.length() != 0) {
            try {
                JSONObject jsonObj = new JSONObject(rawStr);
                JSONObject feedObj = jsonObj.getJSONObject("feed");
                JSONArray entryArr = feedObj.getJSONArray("entry");
                for (int i = 0; i < entryArr.length(); i++) {
                    JSONObject jsonApp = entryArr.getJSONObject(i);

                    JSONObject name = jsonApp.getJSONObject("im:name");
                    String labelName = name.getString("label");

                    JSONObject summary = jsonApp.getJSONObject("summary");
                    String labelSummary = summary.getString("label");

                    JSONObject category = jsonApp.getJSONObject("category");
                    JSONObject attributes = category.getJSONObject("attributes");
                    String labelCategory = attributes.getString("label");

                    JSONArray pngArray = jsonApp.getJSONArray("im:image");
                    String pngImage = pngArray.getJSONObject(pngArray.length()-1).getString("label");
                    
                }
            } catch (JSONException e) {
                // error logic here
            }
        }


        return this.appsList;
    }
}
