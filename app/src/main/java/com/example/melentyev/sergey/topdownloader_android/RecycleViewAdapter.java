package com.example.melentyev.sergey.topdownloader_android;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.List;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.AppViewHolder> {
    private Context context;
    private List<AppData> appList;

    RecyclerViewAdapter(Context context, List<AppData> appList) {
        this.context = context;
        this.appList = appList;
    }

    @Override
    public AppViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflate xml layout into view holder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.browse, parent, false);
        return new AppViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return ((appList != null) && (appList.size() != 0) ? appList.size() : 0);
    }

    public AppData getPhoto(int pos) {
        return ((appList != null) && (appList.size() != 0) ? appList.get(pos) : null);
    }

    @Override
    public void onBindViewHolder(AppViewHolder holder, int position) {
        // called by the layout manager when it wants new data in an existing row
        AppData appItem = appList.get(position);
        Picasso.with(context).load(appItem.getAppImage()).error(R.drawable.image_thumb)
                .placeholder(R.drawable.image_thumb).into(holder.thumbnail);
        holder.appName.setText(appItem.getAppName());
        holder.appCategory.setText(appItem.getAppCategory());
        holder.appSummary.setText(appItem.getAppSummary());
    }

    void loadNewData(List<AppData> newApps) {
        this.appList = newApps;
        notifyDataSetChanged();
    }

    // describe each view holder, bind each field with items id from xml
    static class AppViewHolder extends RecyclerView.ViewHolder {
        ImageView thumbnail = null;
        TextView appName = null;
        TextView appCategory = null;
        TextView appSummary = null;

        AppViewHolder(View itemView) {
            super(itemView);
            this.thumbnail = (ImageView) itemView.findViewById(R.id.image_thumb);
            this.appName = (TextView) itemView.findViewById(R.id.app_name);
            this.appCategory = (TextView) itemView.findViewById(R.id.app_category);
            this.appSummary = (TextView) itemView.findViewById(R.id.app_summary);
        }
    }
}
