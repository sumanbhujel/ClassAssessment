package com.example.classassessment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.classassessment.adapter.MyRvFoodAdapter;
import com.example.classassessment.model.Food;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List <Food> foods = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = findViewById(R.id.rvFoods);

        foods.add(new Food( "Mo:Mo", "Chicken","Rs.120",R.drawable.momo));
        foods.add(new Food( "Chowmein", "Buff","Rs.110",R.drawable.chowmein));
        foods.add(new Food( "Fried Rice", "Chicken","Rs.130",R.drawable.friedrice));

        foods.add(new Food( "Pizza", "Mixed","Rs.200",R.drawable.momo));
        foods.add(new Food( "Burger", "Chicken Crunchy","Rs.140",R.drawable.chowmein));
        foods.add(new Food( "Choupsy", "American","Rs.150",R.drawable.friedrice));

        MyRvFoodAdapter adapter = new MyRvFoodAdapter(foods, this);

        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        //recyclerView.setLayoutManager(layoutManager);

        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(adapter);


    }
}
