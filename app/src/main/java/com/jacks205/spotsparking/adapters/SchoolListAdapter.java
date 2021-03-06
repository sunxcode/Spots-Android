package com.jacks205.spotsparking.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jacks205.spotsparking.R;

/**
 * Created by markjackson on 11/21/15.
 */
public class SchoolListAdapter extends BaseAdapter {

    Context context;
    String[] schools;
    Typeface openSans;

    private static LayoutInflater inflater;

    public SchoolListAdapter(Context context, String[] schools) {
        this.schools = schools;
        this.context = context;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        openSans = Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Regular.ttf");
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View schoolView;
        schoolView = inflater.inflate(R.layout.choose_school_layout, parent, false);
        
        TextView name = (TextView)schoolView.findViewById(R.id.schoolNameTextView);
        name.setTypeface(openSans);
        name.setText(schools[position]);

        return schoolView;
    }

    @Override
    public int getCount() {
        return schools.length;
    }

}
