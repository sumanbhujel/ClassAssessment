package com.example.classassessment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.classassessment.api.FlagInterface;
import com.example.classassessment.model.Flag;
import com.squareup.picasso.Picasso;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FlagAppActivity extends AppCompatActivity {

    ImageView imageView, selectedImage;
    EditText editText;
    TextView textView;
    Retrofit retrofit;
    FlagInterface flagInter;
    Button buttonChoose, buttonUpload, buttonAdd;
    Uri uri;
    MultipartBody.Part image;
    String file_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag_app);

        //imageView = findViewById(R.id.imageFlag);
        //textView = findViewById(R.id.nameCountry);
        selectedImage = findViewById(R.id.selectedImage);
        editText = findViewById(R.id.etCountry);
        buttonChoose = findViewById(R.id.btnChoose);
        buttonUpload = findViewById(R.id.btnUpload);
        buttonAdd = findViewById(R.id.addCountry);

        getInstance();
        //getCountryById(4);


        buttonChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);
            }
        });
        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadImage(image);
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c = editText.getText().toString();
                addCountry(c, file_name);
            }
        });


    }

    private void getInstance() {

        retrofit = new Retrofit.Builder()
                .baseUrl("http://sujitg.com.np/api/").addConverterFactory(GsonConverterFactory.create()).build();
        flagInter = retrofit.create(FlagInterface.class);
    }

    private void getCountryById(int id) {

        Call<Flag> flagCall = flagInter.getCountryById(id);

        flagCall.enqueue(new Callback<Flag>() {
            @Override
            public void onResponse(Call<Flag> call, Response<Flag> response) {
                textView.setText(response.body().getCountry());
                Picasso.with(FlagAppActivity.this)
                        .load("http://sujitg.com.np/wc/teams/" + response.body().getFile()).into(imageView);
            }

            @Override
            public void onFailure(Call<Flag> call, Throwable t) {
                Log.d("Ex", t.getMessage());

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            uri = data.getData();
            selectedImage.setImageURI(uri);
            askPermission();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getImageReady();
            } else {
                Toast.makeText(this, "No Permission", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void askPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            getImageReady();
        }
    }

    private void getImageReady() {
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, filePathColumn, null, null, null);
        assert cursor != null;
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String imgPath = cursor.getString(columnIndex);
        File file = new File(imgPath);
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/"), file);

        image = MultipartBody.Part.createFormData("file", file.getName(), requestBody);

    }

    private void uploadImage(MultipartBody.Part image) {
        Call<Flag> flagUpload = flagInter.uploadFlag(image);

        flagUpload.enqueue(new Callback<Flag>() {
            @Override
            public void onResponse(Call<Flag> call, Response<Flag> response) {
                Toast.makeText(FlagAppActivity.this, response.body().getFile() + "uploaded", Toast.LENGTH_SHORT).show();
                file_name = response.body().getFile();
                Log.d("File Name", file_name);
            }

            @Override
            public void onFailure(Call<Flag> call, Throwable t) {
                Log.d("uploadImage Error", t.getMessage());
            }
        });
    }

    private void addCountry(String country, String file) {

        Call<Void> addCon = flagInter.adCountry(country, file);
        addCon.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(FlagAppActivity.this, "Addedd", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("AddConEx", t.getMessage());

            }
        });

    }
}
