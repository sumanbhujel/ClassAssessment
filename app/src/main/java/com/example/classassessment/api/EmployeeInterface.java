package com.example.classassessment.api;

import com.example.classassessment.model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EmployeeInterface {

    //annotation
    @GET("employees")
    //call le request and response tanne kam garcha.
    Call<List<Employee>> getEmps();


    @GET("employee/{id}")
    Call<Employee> getEmployeeById(@Path("id") int id);

    @POST("create")
    Call<Void> addEmployee(@Body Employee employee);

    @PUT("update/{id}")
    Call<Void> updateEmployee(@Path("id") int id, @Body Employee employee);

    @DELETE("delete/{id}")
    Call<Void> deleteEmployee(@Path("id") int id);

}
