package com.sachitmishra.expresslauncher.appdrawer;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sachit on 1/3/2015.
 */
public class AppDisplay implements Comparable<AppDisplay> {

    private Drawable icon;
    private String label;
    private Intent launchIntent;

    public AppDisplay(Drawable icon, String label, Intent launchIntent) {
        this.icon = icon;
        this.label = label;
        this.launchIntent = launchIntent;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Intent getLaunchIntent() {
        return launchIntent;
    }

    @Override
    public int compareTo(AppDisplay otherApp) {
        return label.compareToIgnoreCase(otherApp.label);
    }

    /**
     * Method returns an UNSORTED list of AppDisplays
     * @param context
     * @return List<AppDisplay>
     */
    public static List<AppDisplay> getAllApps(Context context) {
        Intent mainIntent = new Intent(Intent.ACTION_MAIN);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> appResolveInfos = context.getPackageManager().queryIntentActivities(mainIntent, 0);
        ArrayList<AppDisplay> apps = new ArrayList<>();
        for (ResolveInfo appInfo : appResolveInfos) {
            Drawable icon = appInfo.loadIcon(context.getPackageManager());
            String label = appInfo.loadLabel(context.getPackageManager()).toString();
            Intent intent = new Intent();
            intent.setClassName(appInfo.activityInfo.applicationInfo.packageName,
                    appInfo.activityInfo.name);
            AppDisplay app = new AppDisplay(icon, label, intent);
            apps.add(app);
        }
        return apps;
    }
}
