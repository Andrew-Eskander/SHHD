package com.example.mohamed.shhd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homehandlerActivity extends AppCompatActivity {
Button Handler_light_control,Handler_alarm,Handler_take_photo,Handler_battery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homehandler);
        Handler_light_control = (Button) findViewById(R.id.Light_control);
        Handler_alarm = (Button) findViewById(R.id.Wake_up_alarm);
        Handler_take_photo = (Button) findViewById(R.id.Take_photos);
        Handler_battery = (Button) findViewById(R.id.Battery_level);

        Handler_light_control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), lightcontrolActivity.class);
                startActivity(i);
            }
        });
        Handler_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), wakupalaramactivity.class);
                startActivity(i);
            }
        });
        Handler_take_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), takephotoActivity.class);
                startActivity(i);
            }
        });

        Handler_battery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), batterylevelActivity.class);
                startActivity(i);
            }
        });
    }
}
