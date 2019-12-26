package com.example.classassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    TextView textViewName, textViewGender, textViewState, textViewHobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        textViewName= findViewById(R.id.name);
        textViewGender=findViewById(R.id.gender);
        textViewState= findViewById(R.id.state);
        textViewHobby= findViewById(R.id.hobbies);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String rdValue=intent.getStringExtra("radio_value");
        String state = intent.getStringExtra("state");

        // final String myRadio = intent.getStringExtra("radio_button");
        String[] hob=intent.getStringArrayExtra("hob");

        textViewName.setText("Name :  "+ name);
        textViewGender.setText("Gender :  "+rdValue);
        textViewState.setText("State :  "+state);
        textViewHobby.setText("Hobbies : "+hob[0]+" , "+hob[1]+" & "+ hob[2]);
    }



}
