package com.sachitmishra.expresslauncher.adapter;

import android.content.Context;
import android.gesture.GestureLibrary;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sachitmishra.expresslauncher.R;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Created by Sachit on 1/4/2015.
 */
public class GestureAdapter extends BaseAdapter {

    private Context context;
    private GestureLibrary gestureLibrary;
    private ArrayList<String> gestureNames = new ArrayList<>();

    public GestureAdapter(Context context, GestureLibrary gestureLib) {
        this.context = context;
        this.gestureLibrary = gestureLib;
        for (String gestureName: gestureLibrary.getGestureEntries()) {
            gestureNames.add(gestureName);
        }
        Collections.sort(gestureNames);
    }

    @Override
    public int getCount() {
        return gestureNames.size();
    }

    @Override
    public Object getItem(int position) {
        return gestureNames.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ImageView icon;
        TextView label;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.app_drawer_item, null);
            icon = (ImageView) view.findViewById(R.id.app_drawer_item_icon);
            label = (TextView) view.findViewById(R.id.app_drawer_item_label);
        } else {
            view = convertView;
            icon = (ImageView) view.findViewById(R.id.app_drawer_item_icon);
            label = (TextView) view.findViewById(R.id.app_drawer_item_label);
        }

        return view;
    }
}
