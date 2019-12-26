package com.example.classassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class SharedPreActivity extends AppCompatActivity {

    SharedPreferences sp;
    SharedPreferences.Editor editor; //write garna editor ko object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pre);

        //getcontext for current activity  and variable is saved in mysp
        sp = getApplicationContext().getSharedPreferences("mysp", MODE_PRIVATE);

        editor = sp.edit();
        editor.commit(); //commit garnu parcha
       /*
        editor.putString("name", "Suman");
        editor.putInt("age", 30);
        editor.putLong("phone",982317160);
        editor.putBoolean("isMember", true);*/


        String n = sp.getString("name", "");
        int a = sp.getInt("age", 0);
        Long p = sp.getLong("phone", 0);
        boolean im = sp.getBoolean("isMember", false);
        int b = sp.getInt("zip", 0);

        Toast.makeText(this, "Name:" + n + "\n" +
                "Age: " + a + "\n" +
                "Phone: " + p + "\n" +
                "Is Member: " + im + "\n" +
                "Zip: " + b, Toast.LENGTH_SHORT).show();

    }
}
