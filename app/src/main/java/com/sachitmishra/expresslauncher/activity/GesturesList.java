package com.sachitmishra.expresslauncher.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.os.Bundle;
import android.widget.ListView;

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

        ListView gesturesList = (ListView) findViewById(R.id.gestures_listview);
        gesturesList.setEmptyView(findViewById(R.id.empty_gestures));
        File gesfile = new File(this.getFilesDir() + File.separator + "GestureLibrary");
        GestureLibrary gestureLibrary = GestureLibraries.fromFile(gesfile);
        gesturesList.setAdapter(new GestureAdapter(this, gestureLibrary));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
