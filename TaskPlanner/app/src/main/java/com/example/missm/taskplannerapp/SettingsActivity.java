package com.example.missm.taskplannerapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.missm.taskplannerapp.utilities.InterfaceUtils;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // TODO: Eventually set the theme for the whole application using preferences
        //set the status color
        InterfaceUtils.setTranslucentStatusBar(getWindow());

        Toolbar myChildToolbar = (Toolbar) findViewById(R.id.setting_toolbar);
        setSupportActionBar(myChildToolbar);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

    }
}
