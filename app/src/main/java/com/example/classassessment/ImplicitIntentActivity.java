package com.example.classassessment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class ImplicitIntentActivity extends AppCompatActivity {

    Button buttonCamera, buttonWebsite, buttonGallery;
    ImageView imageView;
    Bitmap image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        buttonCamera = findViewById(R.id.btnCamera);
        buttonWebsite = findViewById(R.id.btnURL);
        buttonGallery = findViewById(R.id.btnGallery);
        imageView = findViewById(R.id.imgGallery);


        buttonCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.btnCamera) {

                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, 1);
                }
            }
        });


        buttonWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.btnURL) {
                    Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com"));
                    startActivity(intent2);

                }
            }
        });

        buttonGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.btnGallery) {
                    Intent intent3 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent3, 2);
                }
            }
        });


    }

    public void askPermission(View view) {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            savCapImg();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                savCapImg();
            } else {
                Toast.makeText(this, "No Permission", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            image = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(image);
        }


        if (requestCode == 2) {
            Uri url = data.getData();
            imageView.setImageURI(url);
        }
    }

    private void savCapImg() {
        imageView.setImageBitmap(image);

        try {

            File mydir = new File(Environment.getExternalStoragePublicDirectory
                    (Environment.DIRECTORY_PICTURES), "Myapp");
            mydir.mkdir();
            Random random = new Random();
            int a = random.nextInt(1000);
            File file = new File(mydir, "myimg" + a + ".jpg");
            FileOutputStream fos = new FileOutputStream(file);
            image.compress(Bitmap.CompressFormat.PNG, 100, fos);
            Toast.makeText(this, "Saved To" + mydir, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.d("myerror", e.toString());

        }

    }
}
