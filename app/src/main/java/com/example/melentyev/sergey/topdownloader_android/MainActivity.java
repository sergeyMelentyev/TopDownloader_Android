package com.example.melentyev.sergey.topdownloader_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GetRawData.CallBackWithAppsData{
    private String currentSelection = FeedType.CURRENT_FREE_10;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        getData(FeedType.TOP_FREE_APPS, FeedType.SIZE_TEN);
        this.currentSelection = FeedType.CURRENT_FREE_10;

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewAdapter = new RecyclerViewAdapter(this, new ArrayList<AppData>());
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    void getData(String feed, String size) {
        String url = new ConstructFinalString(feed, size).getUrl();
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
                switch (this.currentSelection) {
                    case "01":
                        getData(FeedType.TOP_FREE_APPS, FeedType.SIZE_TEN);
                        return true;
                    case "02":
                        getData(FeedType.TOP_FREE_APPS, FeedType.SIZE_TWENTY_FIVE);
                        return true;
                    case "03":
                        getData(FeedType.TOP_PAID_APPS, FeedType.SIZE_TEN);
                        return true;
                    case "04":
                        getData(FeedType.TOP_PAID_APPS, FeedType.SIZE_TWENTY_FIVE);
                        return true;
                }
                return true;
            case R.id.top_10_free_apps:
                getData(FeedType.TOP_FREE_APPS, FeedType.SIZE_TEN);
                this.currentSelection = FeedType.CURRENT_FREE_10;
                return true;
            case R.id.top_25_free_apps:
                getData(FeedType.TOP_FREE_APPS, FeedType.SIZE_TWENTY_FIVE);
                this.currentSelection = FeedType.CURRENT_FREE_25;
                return true;
            case R.id.top_10_paid_apps:
                getData(FeedType.TOP_PAID_APPS, FeedType.SIZE_TEN);
                this.currentSelection = FeedType.CURRENT_PAID_10;
                return true;
            case R.id.top_25_paid_apps:
                getData(FeedType.TOP_PAID_APPS, FeedType.SIZE_TWENTY_FIVE);
                this.currentSelection = FeedType.CURRENT_PAID_25;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void callBackWithAppsData(List<AppData> listOfApps) {
        recyclerViewAdapter.loadNewData(listOfApps);
    }
}
