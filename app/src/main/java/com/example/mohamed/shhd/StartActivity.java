package com.example.mohamed.shhd;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

/*import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;*/

public class StartActivity extends AppCompatActivity {
    Button Start_Home_handler, Start_Disabled_people, Start_security, Start_mission_history;
    private WifiManager wifiManager;
    private boolean wifi_checker;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    //private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        Start_Home_handler = (Button) findViewById(R.id.Home_Handler);
        Start_Disabled_people = (Button) findViewById(R.id.Diasbled_people);
        Start_security = (Button) findViewById(R.id.Security);
        Start_mission_history = (Button) findViewById(R.id.Mission_history);
        wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        if (wifiManager.isWifiEnabled())
            wifi_checker = true;
        else {
            wifi_checker = false;
            wifiManager.setWifiEnabled(true);
        }
        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

                if (!mWifi.isConnected()) {
                    startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
                }
            }
        }.start();

        // startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));


        Start_Home_handler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), homehandlerActivity.class);
                startActivity(i);
            }
        });
        Start_Disabled_people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DisabledpeopleActivity.class);
                startActivity(i);
            }
        });
        Start_security.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);
                Notification n = new Notification.Builder(getApplicationContext())
                        .setContentTitle("Smart Home handler ")
                        .setContentText("you are now in security mode")
                        .setSmallIcon(R.drawable.notify)
                        .setContentIntent(pIntent)
                        //.setColor(getResources().getColor(R.color.blue))
                        .setAutoCancel(true)
                        .build();
                NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0, n);
                Intent i = new Intent(getApplicationContext(), SecurityActivity.class);
                startActivity(i);
            }
        });
        Start_mission_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), missionhistoryActivity.class);
                startActivity(i);
            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Handle the back button
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //Ask the user if they want to quit
            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.aa_app_logo)
                    .setTitle("Exit")
                    .setMessage("Are you sure you want to exit?")
                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Stop the activity
                            if (!wifi_checker)
                                wifiManager.setWifiEnabled(false);
                            StartActivity.this.finish();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();


            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
  /* public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Start Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }*/
}


