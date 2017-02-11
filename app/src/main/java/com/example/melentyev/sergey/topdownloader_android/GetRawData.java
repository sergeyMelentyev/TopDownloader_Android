package com.example.melentyev.sergey.topdownloader_android;

import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

class GetRawData extends AsyncTask<String, Void, String> {
    private final String TAG = "GetRawData";
    private final CallBackWithAppsData mCallBack;

    interface CallBackWithAppsData {
        void callBackWithAppsData(List<AppData> listOfApps);
    }

    GetRawData(CallBackWithAppsData callBack) {
        this.mCallBack = callBack;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        GetAppsDataFromRawData getAppsDataFromRawData = new GetAppsDataFromRawData();
        mCallBack.callBackWithAppsData(getAppsDataFromRawData.parseRawDataToJson(s));
    }

    @Override
    protected String doInBackground(String... params) {
        StringBuilder strFromUrl = new StringBuilder();
        URL url;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL(params[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            int data = inputStreamReader.read();
            while (data != -1) {
                char current = (char) data;
                strFromUrl.append(current);
                data = inputStreamReader.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        if (strFromUrl.length() > 0)
            return strFromUrl.toString();
        return null;
    }
}
