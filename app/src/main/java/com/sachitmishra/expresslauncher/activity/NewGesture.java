package com.sachitmishra.expresslauncher.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.gesture.GestureOverlayView;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sachitmishra.expresslauncher.R;

/**
 * Created by Sachit on 1/4/2015.
 */
public class NewGesture extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.new_gesture);

        // Button Clicks
        TextView cancelButton = (TextView) findViewById(R.id.new_gesture_cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewGesture.this, GesturesList.class);
                startActivity(intent);
            }
        });

        TextView saveButton = (TextView) findViewById(R.id.new_gesture_save_button);
        final GestureOverlayView gestureOverlay = (GestureOverlayView) findViewById(R.id.gestures_overlay);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(NewGesture.this, GesturesList.class);
                startActivity(intent);
            }
        });

    }
}
