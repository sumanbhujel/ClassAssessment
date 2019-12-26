package com.example.classassessment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classassessment.R;
import com.example.classassessment.model.Food;

import java.util.ArrayList;
import java.util.List;

public class MyRvFoodAdapter extends RecyclerView.Adapter<MyRvFoodAdapter.MyHolder> {

    List<Food> foodList = new ArrayList<>();
    private Context context;

    public MyRvFoodAdapter(List<Food> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //layout bind garne...inflater le
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_food_rv, parent, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        //data bind garne after view is created
        final Food food = foodList.get(position);

        holder.imageView.setImageResource(food.getImg());
        holder.tvName.setText(food.getName());
        holder.tvCategory.setText(food.getCategory());
        holder.tvRate.setText(food.getRate());
        //holder.imageView.setImageResource(food.getImg());

        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, food.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {

        //kati ota item cha vanera length dine
        return foodList.size();
    }

    //resource file ko reference lina.....view hold garcha
    //inner class= myholder
    public class MyHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvName, tvCategory, tvRate;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.foodImage);
            tvName = itemView.findViewById(R.id.foodName);
            tvCategory = itemView.findViewById(R.id.foodCategory);
            tvRate = itemView.findViewById(R.id.foodRate);
        }
    }
}
