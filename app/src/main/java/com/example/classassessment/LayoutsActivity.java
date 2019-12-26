package com.example.classassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class LayoutsActivity extends AppCompatActivity implements View.OnClickListener {

    //object
    Button buttonLl, buttonGl, buttonRl, buttonCl, buttonTl,
            buttonFl, btnForm, btnRv, btnFrag, btnTb,
            btnFa, btnSPa, btnImp, btnShuf, btnDb, btnRetro, btnFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layouts);

        //referencing
        buttonLl = findViewById(R.id.btnLl);
        buttonGl = findViewById(R.id.btnGl);
        buttonRl = findViewById(R.id.btnRl);
        buttonCl = findViewById(R.id.btnCl);
        buttonTl = findViewById(R.id.btnTl);
        buttonFl = findViewById(R.id.btnFl);
        btnForm = findViewById(R.id.btnForm);
        btnRv = findViewById(R.id.btnRecyclerView);
        btnFrag = findViewById(R.id.btnFragment);
        btnTb = findViewById(R.id.btnTool);
        btnFa = findViewById(R.id.btnFile);
        btnSPa = findViewById(R.id.btnSPA);
        btnImp = findViewById(R.id.buttonImpIntent);
        btnShuf = findViewById(R.id.buttonShuffleWord);
        btnDb =findViewById(R.id.buttonDatabase);
        btnRetro = findViewById(R.id.buttonRetrofit);
        btnFlag = findViewById(R.id.buttonFlag);

        buttonFl.setOnClickListener(this);
        buttonTl.setOnClickListener(this);
        buttonCl.setOnClickListener(this);
        buttonRl.setOnClickListener(this);
        buttonGl.setOnClickListener(this);
        buttonLl.setOnClickListener(this);
        btnForm.setOnClickListener(this);
        btnRv.setOnClickListener(this);
        btnFrag.setOnClickListener(this);
        btnTb.setOnClickListener(this);
        btnFa.setOnClickListener(this);
        btnSPa.setOnClickListener(this);
        btnImp.setOnClickListener(this);
        btnShuf.setOnClickListener(this);
        btnDb.setOnClickListener(this);
        btnRetro.setOnClickListener(this);
        btnFlag.setOnClickListener(this);

    }

    //interface is used so override should be done
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnFl){
            Intent intent = new Intent(this,FrameLayoutActivity.class);
            startActivity(intent);

        }
        if(view.getId() == R.id.btnTl){
            Intent intent = new Intent(this, TableLayoutActivity.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.btnCl){
            Intent intent = new Intent(this, TaskOneActivity.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.btnGl){
            Intent intent = new Intent(this, TaskFourActivity.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.btnLl){
            Intent intent = new Intent(this, TaskTwoActivity.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.btnRl){
            Intent intent = new Intent(this, RelativeActivity.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.btnForm){
            Intent intent = new Intent(this, RegdataActivity.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.btnRecyclerView){
            Intent intent = new Intent(this, RecyclerViewActivity.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.btnFragment){
            Intent intent = new Intent(this, FragmentActivity.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.btnTool){
            Intent intent = new Intent(this, ToolbarActivity.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.btnFile){
            Intent intent = new Intent(this, FileActivity.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.btnSPA){
            Intent intent = new Intent(this, SharedPreActivity.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.buttonImpIntent){
            Intent intent = new Intent(this, ImplicitIntentActivity.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.buttonShuffleWord){
            Intent intent = new Intent(this, ShuffleWordActivity.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.buttonDatabase){
            Intent intent = new Intent(this, DatabaseActivity.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.buttonRetrofit){
            Intent intent = new Intent(this, RetrofitEmpActivity.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.buttonFlag){
            Intent intent = new Intent(this, FlagAppActivity.class);
            startActivity(intent);
        }
    }
}
