package com.jacks205.spots.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.jacks205.spots.R;
import com.jacks205.spots.adapters.SchoolListAdapter;

public class ChooseSchoolActivity extends AppCompatActivity {

    SharedPreferences preferences;
    Button letsGoBtn;
    ListView listview;

    String[] schools = new String[]{ "Chapman University" };
    int schoolIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_school);

        setActionBar();

        letsGoBtn = (Button)findViewById(R.id.button);
        listview = (ListView)findViewById(R.id.schoolListView);
        SchoolListAdapter schoolListAdapter = new SchoolListAdapter(this, schools);
        listview.setAdapter(schoolListAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setBackgroundColor(getResources().getColor(R.color.black));
                TextView name = (TextView) findViewById(R.id.schoolNameTextView);
                name.setTextColor(Color.WHITE);
                ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
                imageView.setImageResource(R.drawable.check);
            }
        });

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
//        preferences.edit().putString("school", "Chapman University");

//        finish();
    }

    public void letsGoOnClick(View v){

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }

    private void setActionBar(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.actionbar_layout);
        TextView title = (TextView)findViewById(R.id.actionBarTitle);
        title.setText("");
        actionBar.setElevation(0);
    }
}
