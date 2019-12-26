package com.example.classassessment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class FileActivity extends AppCompatActivity {

    EditText editText;
    Button btnSave, btnLoad, btnExSave, btnExLoad;
    HashMap<String, String> myhm = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        editText = findViewById(R.id.etData);
        btnSave = findViewById(R.id.buttonSave);
        btnLoad = findViewById(R.id.buttonLoad);
        btnExLoad = findViewById(R.id.buttonExLoad);
        btnExSave = findViewById(R.id.buttonExSave);


        if (isExWritable()) {
            Toast.makeText(this, "True", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "False", Toast.LENGTH_SHORT).show();
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = editText.getText().toString();
                try {

                    FileOutputStream fileOutputStream = openFileOutput("file_name.txt", MODE_PRIVATE);
                    fileOutputStream.write(data.getBytes());
                    Toast.makeText(FileActivity.this, "Saved Successfully"
                            + getFilesDir(), Toast.LENGTH_SHORT).show();
                    editText.getText().clear();

                } catch (Exception e) {
                    //e.printStackTrace();
                    Log.d("Exception:", e.toString());
                }
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //data taneko
                    FileInputStream fileInputStream = openFileInput("file_name.txt");

                    //file lai read garna
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

                    //byte to byte read garcha
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                    //data save garna
                    String data;
                    String alldata = "";
                    while ((data = bufferedReader.readLine()) != null) {
                        alldata += data + "\n";
                        String[] wm = data.split("|");
                        myhm.put(wm[0], wm[1]);
                    }
                    editText.setText(alldata);



                    /*//multiline data print garna
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((data = bufferedReader.readLine()) != null){
                        stringBuilder.append(data+"\n");
                    }*/

                } catch (Exception e) {
                    Log.d("Exception:", e.toString());

                }
            }
        });
    }

    private boolean isExWritable() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            return true;
        } else
            return false;
    }

    public void askPermission(View view) {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            saveExternal();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                saveExternal();
            } else {
                Toast.makeText(this, "No Permission", Toast.LENGTH_SHORT).show();
            }
        }

        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void saveExternal() {


        if (isExWritable()) {
            String data = editText.getText().toString();

            try {
                File myDir = new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "Mytemp");
                myDir.mkdir();
                File myFile = new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS),"Mytemp/newfile.txt");

                myFile.createNewFile();
                FileOutputStream fos = new FileOutputStream(myFile);
                fos.write(data.getBytes());
                editText.getText().clear();
                Toast.makeText(this, "Saved to" + myDir, Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Log.d("myeerrr", e.toString());
            }
        }

    }


}
