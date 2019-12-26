package com.example.classassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UserDetailActivity extends AppCompatActivity {
    TextView tvN, tvG, tvD, tvC, tvE, tvP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        tvN = findViewById(R.id.tvName);
        tvG = findViewById(R.id.tvGender);
        tvD = findViewById(R.id.tvDob);
        tvC = findViewById(R.id.tvCountry);
        tvE = findViewById(R.id.tvEmail);
        tvP = findViewById(R.id.tvPhone);

        Intent intent = getIntent();
        String n = intent.getStringExtra("name");
        String g = intent.getStringExtra("gender");
        String c = intent.getStringExtra("country");
        String d = intent.getStringExtra("dob");
        String e = intent.getStringExtra("email");
        String p = intent.getStringExtra("phone");

        tvN.setText("Name:"+n);
        tvG.setText("Gender:"+g);
        tvD.setText("Date:"+d);
        tvC.setText("Flag:"+c);
        tvE.setText("Email:"+e);
        tvP.setText("Phone:"+p);


    }
}
