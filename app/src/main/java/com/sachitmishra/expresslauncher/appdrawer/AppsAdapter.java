package com.sachitmishra.expresslauncher.appdrawer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sachitmishra.expresslauncher.R;

import java.util.List;

/**
 * Created by Sachit on 1/3/2015.
 */
public class AppsAdapter extends BaseAdapter {

    private List<ResolveInfo> apps;
    private Activity activity;

    public AppsAdapter(Activity activity) {
        this.activity = activity;

        Intent mainIntent = new Intent(Intent.ACTION_MAIN);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        apps = activity.getPackageManager().queryIntentActivities(mainIntent, 0);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ImageView icon;
        TextView label;

        if (convertView == null) {
//            view = new RelativeLayout(activity);
//            view.setGravity(RelativeLayout.CENTER_IN_PARENT);
//            icon = new ImageView(activity);
//            icon.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
//            icon.setLayoutParams(new GridView.LayoutParams(110, 150));
//            icon.setPadding(8, 8, 8, 8);
//            view.addView(icon);
//            label = new TextView(activity);
//            label.setGravity(RelativeLayout.ALIGN_BOTTOM);
//            label.setText("App name");
//            view.addView(label);
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.app_drawer_item, null);
            icon = (ImageView) view.findViewById(R.id.app_drawer_item_icon);
            label = (TextView) view.findViewById(R.id.app_drawer_item_label);
        } else {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.app_drawer_item, null);
            icon = (ImageView) view.findViewById(R.id.app_drawer_item_icon);
            label = (TextView) view.findViewById(R.id.app_drawer_item_label);
        }

        ResolveInfo info = apps.get(position);
        icon.setImageDrawable(info.activityInfo.loadIcon(activity.getPackageManager()));
        label.setText(info.activityInfo.loadLabel(activity.getPackageManager()));

        return view;
    }

    public final int getCount() {
        return apps.size();
    }

    public final long getItemId(int position) {
        return position;
    }

    public final Object getItem(int position) {
        return apps.get(position);
    }
}
