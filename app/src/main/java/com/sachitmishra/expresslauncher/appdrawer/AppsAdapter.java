package com.sachitmishra.expresslauncher.appdrawer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sachitmishra.expresslauncher.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sachit on 1/3/2015.
 */
public class AppsAdapter extends BaseAdapter {

    private List<AppDisplay> apps;
    private Activity activity;

    public AppsAdapter(Activity activity) {
        this.activity = activity;

        Intent mainIntent = new Intent(Intent.ACTION_MAIN);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> appResolveInfos = activity.getPackageManager().queryIntentActivities(mainIntent, 0);
        apps = new ArrayList<>();
        for (ResolveInfo appInfo : appResolveInfos) {
            Drawable icon = appInfo.activityInfo.loadIcon(activity.getPackageManager());
            String label = appInfo.activityInfo.loadLabel(activity.getPackageManager()).toString();
            AppDisplay app = new AppDisplay(icon, label);
            apps.add(app);
        }
        Collections.sort(apps);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ImageView icon;
        TextView label;

        if (convertView == null) {
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

        icon.setImageDrawable(apps.get(position).getIcon());
        label.setText(apps.get(position).getLabel());

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
