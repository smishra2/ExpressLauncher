package com.sachitmishra.expresslauncher.appdrawer;

import android.graphics.drawable.Drawable;

/**
 * Created by Sachit on 1/3/2015.
 */
public class AppDisplay {

    private Drawable icon;
    private String appName;

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
