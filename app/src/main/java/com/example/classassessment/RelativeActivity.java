package com.example.classassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class RelativeActivity extends AppCompatActivity implements View.OnClickListener {

    int clickCount;
    Button btnClick;
    ImageView imageView1, imageView2, imageView3, imageView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);

        btnClick = findViewById(R.id.btnClick);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);

        btnClick.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        clickCount = clickCount + 1;
        switch (clickCount) {
            case 1:
                imageView4.setVisibility(View.INVISIBLE);
                imageView1.setVisibility(View.VISIBLE);
                break;
            case 2:
                imageView1.setVisibility(View.INVISIBLE);
                imageView2.setVisibility(View.VISIBLE);
                break;
            case 3:
                imageView2.setVisibility(View.INVISIBLE);
                imageView3.setVisibility(View.VISIBLE);
                break;
            case 4:
                imageView3.setVisibility(View.INVISIBLE);
                imageView4.setVisibility(View.VISIBLE);
                break;
            case 5:
                imageView4.setVisibility(View.INVISIBLE);
                imageView1.setVisibility(View.VISIBLE);
                clickCount = 1;
                break;
        }
    }
}
