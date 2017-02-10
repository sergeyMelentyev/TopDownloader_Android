package com.example.melentyev.sergey.topdownloader_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements GetRawData.CallBackWithAppsData{
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        String url = new ConstructFinalString(FeedType.TOP_FREE_APPS, FeedType.SIZE_TEN).getUrl();
        GetRawData getRawData = new GetRawData(this);
        getRawData.execute(url);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh_menu:
                // logic here
                return true;
            case R.id.top_10_apps:
                // logic here
                return true;
            case R.id.top_25_apps:
                // logic here
                return true;
            case R.id.show_paid:
                // logic here
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void callBackWithAppsData(List<ApplicationData> listOfApps) {
        // logic here
    }
}
