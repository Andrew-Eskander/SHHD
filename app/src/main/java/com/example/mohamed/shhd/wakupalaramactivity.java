package com.example.mohamed.shhd;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.CheckBox;
import android.widget.Toast;


public class wakupalaramactivity extends AppCompatActivity {


    private TimePicker timePicker1;
    private TextView time;
    private Calendar calendar;
    private String format = "";
    int r1=0;
    int r2=0;
    int r3=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wakeupalarm);

        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
        time = (TextView) findViewById(R.id.textView1);
        calendar = Calendar.getInstance();
        final CheckBox room1 = (CheckBox) findViewById(R.id.checkBox);
        room1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)

                    Toast.makeText(wakupalaramactivity.this,"ROOM1Checked", Toast.LENGTH_LONG).show();
            }
        });
        //Toast.makeText(MainActivity.this,"ROOM1Checked", Toast.LENGTH_LONG).show();
        final CheckBox room2 = (CheckBox) findViewById(R.id.checkBox2);
        room2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)

                    Toast.makeText(wakupalaramactivity.this,"ROOM2Checked", Toast.LENGTH_LONG).show();
            }
        });
        final CheckBox room3 = (CheckBox) findViewById(R.id.checkBox3);
        room3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)

                    Toast.makeText(wakupalaramactivity.this,"ROOM3Checked", Toast.LENGTH_LONG).show();
            }
        });
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        showTime(hour, min);
    }

    public void setTime(View view) {
        int hour1 = timePicker1.getCurrentHour();
        int min1 = timePicker1.getCurrentMinute();
        showTime(hour1, min1);
        counter(hour1,min1);
    }
    public void counter(int targeth, int targetm)
    {
        int remaining_hours= targeth-(calendar.get(Calendar.HOUR_OF_DAY));
        int remaining_mins= targetm- (calendar.get(Calendar.MINUTE));
        if (remaining_hours<0  && remaining_mins<0)
            Toast.makeText(this,"Wrong Value",Toast.LENGTH_LONG).show();
        if (remaining_hours>=0  && remaining_mins>=0)
            Toast.makeText(this,"Alarm will be after\n"+remaining_hours+" H:"+remaining_mins+" M",Toast.LENGTH_LONG).show();}

    public void showTime(int hour, int min) {
        if (hour == 0) {
            hour += 12;
            format = "AM";
        } else if (hour == 12) {
            format = "PM";
        } else if (hour > 12) {
            hour -= 12;
            format = "PM";
        } else {
            format = "AM";
        }
        time.setText(new StringBuilder().append(hour).append(" : ").append(min)
                .append(" ").append(format));
    }






}
//@Override
//public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
//getMenuInflater().inflate(R.menu.main, menu);
// return true;
