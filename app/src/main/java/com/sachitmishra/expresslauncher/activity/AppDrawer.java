package com.sachitmishra.expresslauncher.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.GridView;

import com.sachitmishra.expresslauncher.R;
import com.sachitmishra.expresslauncher.adapter.AppsAdapter;

/**
 * Created by Sachit on 1/3/2015.
 */
public class AppDrawer extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.app_drawer);

        GridView appsGrid = (GridView) findViewById(R.id.apps_grid);
        appsGrid.setAdapter(new AppsAdapter(this));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
    }

}
