package com.example.classassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class RegdataActivity extends AppCompatActivity {

    EditText editText;
    RadioGroup rgG;
    RadioButton rbM, rbF, rbO;
    Spinner spinner;
    CheckBox cbM, cbD, cbO;
    Button button;
    String[] hob = new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regdata);

        editText = findViewById(R.id.editText);
        rgG = findViewById(R.id.radioGroup);
        rbM = findViewById(R.id.btnMale);
        rbF = findViewById(R.id.btnFemale);
        rbO = findViewById(R.id.btnOthers);
        spinner = findViewById(R.id.spinner1);
        cbM = findViewById(R.id.chkBox);
        cbD = findViewById(R.id.chkBox2);
        cbO = findViewById(R.id.chkBox3);
        button = findViewById(R.id.btnSubmit);

        onCbSelect();
        onSpinnerSelect();


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(RegdataActivity.this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(RegdataActivity.this, "Select One", Toast.LENGTH_SHORT).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name, state, hob;
                name = editText.getText().toString();
                state = spinner.getSelectedItem().toString();
                String r_value = ((RadioButton) findViewById(rgG.getCheckedRadioButtonId()))
                        .getText().toString();

                hob = editText.getText().toString();
                Intent intent = new Intent(RegdataActivity.this, ShowActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("state", state);
                intent.putExtra("hob", hob);
                intent.putExtra("radio_value",r_value);
                startActivity(intent);
            }
        });

        rgG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.btnMale) {
                    Toast.makeText(RegdataActivity.this, "Male", Toast.LENGTH_SHORT).show();
                }
                if (i == R.id.btnFemale) {
                    Toast.makeText(RegdataActivity.this, "Female", Toast.LENGTH_SHORT).show();
                }

                if (i == R.id.btnOthers) {
                    Toast.makeText(RegdataActivity.this, "Others", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void onCbSelect() {

        cbM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    hob[0] = cbM.getText().toString();


                } else {
                    hob[0] = "";
                }
            }
        });

        cbD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    hob[1] = cbD.getText().toString();
                } else {
                    hob[1] = "";
                }
            }
        });

        cbO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    hob[2] = cbO.getText().toString();
                } else {
                    hob[2] = "";
                }
            }
        });

    }


    private void onSpinnerSelect() {


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(RegdataActivity.this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(RegdataActivity.this, "Select One", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
