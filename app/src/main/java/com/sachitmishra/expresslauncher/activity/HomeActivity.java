package com.sachitmishra.expresslauncher.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sachitmishra.expresslauncher.R;

/**
 * Created by Sachit on 1/2/2015.
 */
public class HomeActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.home_layout);

        // Button clicks
        TextView gestureMenuButton = (TextView) findViewById(R.id.menu_button);
        gestureMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        TextView appDrawerButton = (TextView) findViewById(R.id.apps_button);
        appDrawerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, AppDrawer.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
            }
        });
    }

    // Override back button so it does nothing, probably not the right way to do things?
    @Override
    public void onBackPressed() {
        // do nothing
    }

}
