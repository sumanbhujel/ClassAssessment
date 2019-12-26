package com.example.classassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.classassessment.database.DbHelper;
import com.example.classassessment.model.Student;

public class UpdateActivity extends AppCompatActivity {

    EditText editTextN, editTextE, editTextP;
    Button buttonUpdate;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        editTextN = findViewById(R.id.edName);
        editTextE = findViewById(R.id.edEmail);
        editTextP = findViewById(R.id.edPhone);
        buttonUpdate = findViewById(R.id.btnUpdate);
        dbHelper = new DbHelper(this);

        Intent intent = getIntent();
        final int i = intent.getIntExtra("id", 0);
        String n = intent.getStringExtra("name");
        String e = intent.getStringExtra("email");
        String p = intent.getStringExtra("phone");


        editTextN.setText(n);
        editTextE.setText(e);
        editTextP.setText(p);

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n1 = editTextN.getText().toString();
                String e1 = editTextE.getText().toString();
                String p1 = editTextP.getText().toString();

                Student s = new Student(i, n1, e1, p1);

                if (dbHelper.updateStudent(s)) {
                    Toast.makeText(UpdateActivity.this, "Update Successfully", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}
