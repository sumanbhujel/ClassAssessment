package com.example.classassessment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.classassessment.services.CreateChannel;
import com.example.classassessment.services.MyService;

public class NotificationActivity extends AppCompatActivity {

    Button btn1, btn2;
    Button btnStart, btnStop;
    NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        btn1 = findViewById(R.id.btnNot1);
        btn2 = findViewById(R.id.btnNot2);
        btnStart = findViewById(R.id.btnStartService);
        btnStop = findViewById(R.id.btnStopService);

        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel channel = new CreateChannel(this);
        channel.createChannel();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification1();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification2();
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMyService();

            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopMyService();
            }
        });
    }

    private void startMyService() {
        startService(new Intent(this, MyService.class));
    }

    private void stopMyService() {
        stopService(new Intent(this, MyService.class));
    }


    private void displayNotification1() {

        Notification notification = new NotificationCompat
                .Builder(this, CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.first_icon)
                .setContentTitle("First Notification")
                .setContentText("This is first Notification")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE).build();

        notificationManagerCompat.notify(1, notification);

    }

    private void displayNotification2() {

        Notification notification = new NotificationCompat
                .Builder(this, CreateChannel.CHANNEL_2)
                .setSmallIcon(R.drawable.first_icon)
                .setContentTitle("Second Notification")
                .setContentText("This is second Notification")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE).build();

        notificationManagerCompat.notify(2, notification);
    }
}
