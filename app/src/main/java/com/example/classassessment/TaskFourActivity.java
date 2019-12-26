package com.example.classassessment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TaskFourActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnClear, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnEqual, btnAdd, btnSubtract, btnMultiply, btnDivide;
    EditText editText;
    String displayNum = "";
    String op;
    float num1, num2, res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_four);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        editText = findViewById(R.id.result);
        btnEqual = findViewById(R.id.btnEqual);
        btnAdd = findViewById(R.id.btnPlus);
        btnSubtract = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnClear = findViewById(R.id.btnClear);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                displayNum += 1;
                editText.setText(displayNum);
                break;

            case R.id.btn2:
                displayNum += 2;
                editText.setText(displayNum);
                break;

            case R.id.btn3:
                displayNum += 3;
                editText.setText(displayNum);
                break;

            case R.id.btn4:
                displayNum += 4;
                editText.setText(displayNum);
                break;

            case R.id.btn5:
                displayNum += 5;
                editText.setText(displayNum);
                break;

            case R.id.btn6:
                displayNum += 6;
                editText.setText(displayNum);
                break;

            case R.id.btn7:
                displayNum += 7;
                editText.setText(displayNum);
                break;

            case R.id.btn8:
                displayNum += 8;
                editText.setText(displayNum);
                break;

            case R.id.btn9:
                displayNum += 9;
                editText.setText(displayNum);
                break;

            case R.id.btn0:
                displayNum += 0;
                editText.setText(displayNum);
                break;

            case R.id.btnClear:
                displayNum = "";
                editText.setText(displayNum);
                break;

            case R.id.btnPlus:
                if (TextUtils.isEmpty(editText.getText())) {
                    editText.setError("Enter a number first");
                } else {
                    editText.setError(null);
                    num1 = Float.parseFloat(displayNum);
                    displayNum = "";
                    op = "+";
                }
                break;

            case R.id.btnMinus:
                if (TextUtils.isEmpty(editText.getText())) {
                    editText.setError("Enter a number");
                } else {
                    editText.setError(null);
                    num1 = Float.parseFloat(displayNum);
                    displayNum = "";
                    op = "-";
                }
                break;

            case R.id.btnMultiply:
                if (TextUtils.isEmpty(editText.getText())) {
                    editText.setError("enter number");
                } else {
                    editText.setError(null);
                    num1 = Float.parseFloat(displayNum);
                    displayNum = "";
                    op = "*";
                }
                break;

            case R.id.btnDivide:
                if (TextUtils.isEmpty(editText.getText())) {
                    editText.setError("enter number");
                } else {
                    editText.setError(null);
                    num1 = Float.parseFloat(displayNum);
                    displayNum = "";
                    op = "/";
                }
                break;

            case R.id.btnEqual:
                num2 = Float.parseFloat(displayNum);
                res = getResult(op, num1, num2);
                editText.setText(String.valueOf(res));
                displayNum = "";
                break;
        }
    }

    private float getResult(String op, float n1, float n2) {
        switch (op) {
            case "+":
                return n1 + n2;

            case "-":
                return n1 - n2;

            case "*":
                return n1 * n2;

            case "/":
                if (num2 == 0) {
                    Toast.makeText(this, "Cannot divide 0!", Toast.LENGTH_SHORT).show();
                } else {
                    return n1 / n2;
                }

            default:
                return 0;
        }
    }

}

