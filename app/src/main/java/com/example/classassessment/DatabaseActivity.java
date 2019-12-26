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


public class DatabaseActivity extends AppCompatActivity {

    EditText editTextN, editTextE, editTextP;
    Button buttonAdd, buttonShow;
    DbHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        editTextN = findViewById(R.id.edName);
        editTextE = findViewById(R.id.edEmail);
        editTextP = findViewById(R.id.edPhone);
        buttonAdd = findViewById(R.id.btnAdd);
        buttonShow = findViewById(R.id.btnShow);

        dbHelper = new DbHelper(this);
        addData();


        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DatabaseActivity.this, ShowStudentActivity.class);
                startActivity(intent);
            }
        });

        /*List<Student> students = dbHelper.getStudents();
        for(Student student:students){
            Log.d("ID : ",String.valueOf(student.getId()));
            Log.d("Name: ",student.getName());
            Log.d("Email: ",student.getEmail());
            Log.d("Phone: ",student.getPhone());

        }*/

    }

    public void addData() {
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = editTextN.getText().toString();
                String e = editTextE.getText().toString();
                String p = editTextP.getText().toString();

                Student student = new Student(0, n, e, p);

                if (dbHelper.addStudent(student)) {
                    Toast.makeText(DatabaseActivity.this, "Successfully Added", Toast.LENGTH_SHORT).show();
                    editTextN.setText("");
                    editTextE.setText("");
                    editTextP.setText("");
                }
            }
        });

    }
}
