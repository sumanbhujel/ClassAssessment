package com.example.classassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.classassessment.model.User;

import java.util.List;

public class UserListView extends AppCompatActivity {

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list_view);

        listView = findViewById(R.id.userListView);

        Intent intent = getIntent();
        final List<User> userList = (List<User>) intent.getSerializableExtra("allusers");
        String[] userNames = new String[userList.size()];

        int i=0 ;
        for (User user:userList){
            userNames[i] = user.getName();
            i++;
        }

        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.spinner_values,userNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(UserListView.this, ""+i, Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(UserListView.this,UserDetailActivity.class);
                intent1.putExtra("name", userList.get(i).getName());
                intent1.putExtra("gender", userList.get(i).getGender());
                intent1.putExtra("country", userList.get(i).getCountry());
                intent1.putExtra("dob", userList.get(i).getDob());
                intent1.putExtra("email", userList.get(i).getEmail());
                intent1.putExtra("phone", userList.get(i).getPhone());
                startActivity(intent1);


            }
        });
    }
}
