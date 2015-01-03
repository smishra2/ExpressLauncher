package com.sachitmishra.expresslauncher.appdrawer;

import android.content.Intent;
import android.graphics.drawable.Drawable;

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
}
