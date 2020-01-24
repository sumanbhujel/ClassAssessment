package com.example.classassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import com.example.classassessment.services.BoardcastReceiverExample;

public class BoardcastActivity extends AppCompatActivity {

    BoardcastReceiverExample boardcastReceiverExample = new BoardcastReceiverExample();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boardcast);
    }

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(boardcastReceiverExample,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();

        unregisterReceiver(boardcastReceiverExample);
    }
}
