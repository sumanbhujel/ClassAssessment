package com.example.classassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.classassessment.model.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


public class TableLayoutActivity extends AppCompatActivity
        implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    EditText editTextN, editTextD, editTextP, editTextE;
    RadioGroup radioGroup;
    Spinner spinner;
    //CalendarView calendarView;
    Button btnSubmit, btnView;
    String name, gender, dob, phone, email, country;
    String[] countries = {"Select Flag", "Nepal", "India", "Sri Lanka", "Bhutan", "Pakistan", "Afghanistan", "Maldives"};

    //userdefined datatype = class
    List<User> userList = new ArrayList<>();


    Calendar calendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener mydatepicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            calendar.set(Calendar.YEAR, i);
            calendar.set(Calendar.MONTH, i1);
            calendar.set(Calendar.DAY_OF_MONTH, i2);
            String mydateFormat = "y-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(mydateFormat, Locale.getDefault());
            editTextD.setText(simpleDateFormat.format(calendar.getTime()));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);

        editTextN = findViewById(R.id.etName);
        editTextD = findViewById(R.id.etDate);
        editTextE = findViewById(R.id.etEmail);
        editTextP = findViewById(R.id.etPhone);
        radioGroup = findViewById(R.id.rgGender);
        spinner = findViewById(R.id.spCountry);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnView = findViewById(R.id.btnView);
        //calendarView = findViewById(R.id.calenderView);


        radioGroup.setOnCheckedChangeListener(this);


        //adapter arko layout ko value tanne
        //array values are set to another layout.
        //recyclerview adapter is used for images.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_values, countries);
        spinner.setAdapter(adapter);
        setSpinnerValue();
        btnSubmit.setOnClickListener(this);
        editTextD.setOnClickListener(this);
        btnView.setOnClickListener(this);


//        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
//                Toast.makeText(TableLayoutActivity.this, String.valueOf(i) + "-" +
//                        String.valueOf(i1) + "-" + String.valueOf(i2), Toast.LENGTH_SHORT).show();
//            }
//        });

    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.rbMale) {
            //Toast.makeText(this, "Male", Toast.LENGTH_SHORT).show();
            gender = "Male";
        }
        if (i == R.id.rbFemale) {
            gender = "Female";
        }
        if (i == R.id.rbOther) {
            gender = "Other";
        }
    }


    private void setSpinnerValue() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                country = adapterView.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(TableLayoutActivity.this, "Please Select Flag", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {

        name = editTextN.getText().toString();
        dob = editTextD.getText().toString();
        email = editTextE.getText().toString();
        phone = editTextP.getText().toString();

        //drawable resource


        if (view.getId() == R.id.etDate) {
            new DatePickerDialog(this, mydatepicker, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)).show();

        }

        if (view.getId() == R.id.btnSubmit) {
            if (validate()) {
                userList.add(new User(name, gender, country, dob, email, phone));
                Toast.makeText(this, "User added", Toast.LENGTH_SHORT).show();
            }
        }

        if (view.getId() == R.id.btnView) {
            //for all user object in userlist
            /*for (User user : userList) {
                Log.d("Name: ", user.getName());
                Log.d("Gender: ", user.getGender());
                Log.d("Flag: ", user.getCountry());
                Log.d("Date of Birth: ", user.getDob());
                Log.d("Email: ", user.getEmail());
                Log.d("Phone: ", user.getPhone());
            }*/
            //data persistency is needed to store data

            Intent intent = new Intent(this,UserListView.class);
            //serializable(interface ) = object lai byte string ma convert garcha
            intent.putExtra("allusers",(Serializable) userList);
            startActivity(intent);

        }
    }

    private boolean validate() {
        Calendar minAge = Calendar.getInstance();
        minAge.add(Calendar.YEAR,-18);

        if(minAge.before((dob))){
            Toast.makeText(this, "Age should be 18+", Toast.LENGTH_SHORT).show();
        }


        if (TextUtils.isEmpty(name)) {
            editTextN.setError("Enter Name");
            editTextN.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(gender)) {
            Toast.makeText(this, "Please select gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(country)) {
            Toast.makeText(this, "Please select country", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (spinner.getSelectedItem().toString().trim().equals("Select Flag")) {
            Toast.makeText(this, "Please Select Flag", Toast.LENGTH_SHORT).show();
            spinner.setFocusable(true);
            return false;
        }

        if (TextUtils.isEmpty(dob)) {
            editTextD.setError("Enter dob");
            editTextD.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(email)) {
            editTextE.setError("Enter Email");
            editTextE.requestFocus();
            return false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextE.setError("Invalid Email");
            editTextE.requestFocus();
            return false;

        }
        if (TextUtils.isEmpty(phone)) {
            editTextP.setError("Enter Phone");
            editTextP.requestFocus();
            return false;
        }
        if (!TextUtils.isDigitsOnly(phone)) {
            editTextP.setError("Invalid Number");
            editTextP.requestFocus();
            return false;
        }
        return true;
    }
}
