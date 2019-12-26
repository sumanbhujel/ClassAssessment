package com.example.classassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.classassessment.api.EmployeeInterface;
import com.example.classassessment.model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitEmpActivity extends AppCompatActivity {
    TextView textView;
    EditText etName, etSalary, etAge;
    Button btnAdd;
    Retrofit retrofit;
    EmployeeInterface empInter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_emp);

        textView = findViewById(R.id.showEmp);
        etName = findViewById(R.id.empName);
        etSalary = findViewById(R.id.empSalary);
        etAge = findViewById(R.id.empAge);
        btnAdd = findViewById(R.id.addButton);

        getInstance();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String salary = etSalary.getText().toString();
                String age = etAge.getText().toString();

                Employee emp = new Employee(0, name, salary, age);
                //addEmployee(emp);
                updateEmployee(1,emp);
            }
        });

    }

    private void getInstance() {

        //retrofit ko object banako
        retrofit = new Retrofit.Builder()
                .baseUrl("http://dummy.restapiexample.com/api/v1/").addConverterFactory(GsonConverterFactory.create()).build();
        //interface ko object banako through retrofit
        empInter = retrofit.create(EmployeeInterface.class);
    }

    private void showEmployeeById() {

        Call<Employee> employee = empInter.getEmployeeById(1);

        employee.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                Toast.makeText(RetrofitEmpActivity.this, response.body().getEmployee_name(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {

            }
        });
    }

    private void getAllEmployees() {
        Call<List<Employee>> employeeList = empInter.getEmps();

        //enqueue is used for extract call type object
        employeeList.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                List<Employee> empList = response.body();
                for (Employee emp : empList) {
                    Log.d("name", emp.getEmployee_name());
//                    Log.d("salary", String.valueOf(emp.getEmployee_salary()));
//                    Log.d("name", String.valueOf(emp.getEmployee_age()));
                }
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Log.d("ApiEx", t.getMessage());
            }
        });
    }

    private void addEmployee(Employee employee) {

        Call<Void> empAdd = empInter.addEmployee(employee);

        empAdd.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(RetrofitEmpActivity.this, "Added", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });

    }

    private void updateEmployee(int id, Employee employee) {
        
        Call<Void> empUpdate = empInter.updateEmployee(id, employee);
        
        empUpdate.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(RetrofitEmpActivity.this, "Updated", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {


            }
        });
    }
}
