package com.example.classassessment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.classassessment.fragments.ExampleFragment;
import com.example.classassessment.fragments.SecondFragment;

public class FragmentActivity extends AppCompatActivity {
    Button btnF;
    Boolean check=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        btnF = findViewById(R.id.btnFirstFrag);
        //btnS = findViewById(R.id.btnSecondFrag);





        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check){
                    //fragment manage garna frag manager
                    FragmentManager fm = getSupportFragmentManager();
                    //fragment lyaudai rakhdai garna transaction.
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragHolder, new ExampleFragment());
                    ft.commit();
                    check=false;
                    btnF.setText("Load Second");
                }
                else {
                    //fragment manage garna frag manager
                    FragmentManager fm = getSupportFragmentManager();
                    //fragment lyaudai rakhdai garna transaction.
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragHolder, new SecondFragment());
                    ft.commit();
                    check =true;
                    btnF.setText("Load First");
                }

            }
        });

        /*btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fragment manage garna frag manager
                FragmentManager fm = getSupportFragmentManager();
                //fragment lyaudai rakhdai garna transaction.
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragHolder, new SecondFragment());
                ft.commit();
            }
        });*/
    }
}
