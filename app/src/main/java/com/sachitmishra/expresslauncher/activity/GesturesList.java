package com.sachitmishra.expresslauncher.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.sachitmishra.expresslauncher.R;
import com.sachitmishra.expresslauncher.adapter.GestureAdapter;

import java.io.File;

/**
 * Created by Sachit on 1/4/2015.
 */
public class GesturesList extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.gestures_list);

        // Load the gesture library
        ListView gesturesList = (ListView) findViewById(R.id.gestures_listview);
        gesturesList.setEmptyView(findViewById(R.id.empty_gestures));
        File gesfile = new File(this.getFilesDir() + File.separator + "GestureLibrary");
        GestureLibrary gestureLibrary = GestureLibraries.fromFile(gesfile);
        gesturesList.setAdapter(new GestureAdapter(this, gestureLibrary));

        // Button Clicks
        TextView newGestureButton = (TextView) findViewById(R.id.new_gesture_button);
        newGestureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GesturesList.this, NewGesture.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
    }
}
