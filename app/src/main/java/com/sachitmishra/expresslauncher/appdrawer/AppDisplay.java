package com.sachitmishra.expresslauncher.appdrawer;

import android.graphics.drawable.Drawable;

/**
 * Created by Sachit on 1/3/2015.
 */
public class AppDisplay implements Comparable<AppDisplay> {

    private Drawable icon;
    private String label;

    public AppDisplay(Drawable icon, String label) {
        this.icon = icon;
        this.label = label;
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

    @Override
    public int compareTo(AppDisplay otherApp) {
        return label.compareToIgnoreCase(otherApp.label);
    }
}
