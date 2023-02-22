package com.example.practice_demo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class ImageButton_Activity extends AppCompatActivity {
    CheckBox simpleCheckBox;
    String[] name = {"sama", "rahul", "yash", "shivani", "himmat", "prajwal", "kalpesh"};
    int i = 0;
    AutoCompleteTextView simpleAutoCompleteTextView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagebutton_layout);

        allowPermission();

        simpleAutoCompleteTextView = findViewById(R.id.simpleAutoCompleteTextView);

        simpleAutoCompleteTextView.setThreshold(1);
        simpleAutoCompleteTextView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, name));
        simpleCheckBox = findViewById(R.id.simpleCheckBox);
        for (i = 0; i < name.length; i++) {
            simpleCheckBox.setText(name[i]);
        }
        ToggleButton simpleToggleButton = (ToggleButton) findViewById(R.id.simpleToggleButton); // initiate a toggle button
        Boolean ToggleButtonState = simpleToggleButton.isChecked();

    }

    private void allowPermission() {
        if(ContextCompat.checkSelfPermission(ImageButton_Activity.this, Manifest.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(ImageButton_Activity.this,new String[]{Manifest.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS},111);
        }
        PowerManager powerManager = (PowerManager) getApplicationContext().getSystemService(POWER_SERVICE);
        String packageName = getApplicationContext().getPackageName();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Intent i = new Intent();

            if (!powerManager.isIgnoringBatteryOptimizations(packageName)) {
                i.setAction(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                i.setData(Uri.parse("package:" + packageName));
                startActivity(i);
            }
        }
    }
}
