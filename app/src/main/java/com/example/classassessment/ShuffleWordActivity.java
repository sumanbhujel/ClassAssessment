package com.example.classassessment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class ShuffleWordActivity extends AppCompatActivity {

    String[] words = {"APPLE", "ORANGE", "GRAPES"};
    ListView listView;
    TextView textView;
    Button btnClear, btnCheck;
    //boolean check = false;
    int level = 0;
    SharedPreferences sp;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuffle_word);


        textView = findViewById(R.id.textWord);
        btnCheck = findViewById(R.id.buttonSubmit);
        btnClear = findViewById(R.id.buttonClear);
        listView = findViewById(R.id.wordList);

        sp = getApplicationContext().getSharedPreferences("myword", MODE_PRIVATE);
        editor = sp.edit();

        int lastlevel = sp.getInt("level", 0);
        level = lastlevel;

        showWord(level);


        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
            }
        });

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String w = textView.getText().toString();

                if (w.equals(words[level])) {
                    level++;
                    showWord(level);
                    textView.setText("");

                    editor.putInt("level", level);
                    editor.commit();
                } else {
                    Toast.makeText(ShuffleWordActivity.this, "Not Matched", Toast.LENGTH_SHORT).show();

                }

                /*for (int y=0;y<words.length;y++){
                    if (words[y] == w) {
                        check = true;
                        break;
                    }
                }

                if (check) {
                    //true
                    Toast.makeText(ShuffleWordActivity.this, w+" is Matched",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    //false
                    Toast.makeText(ShuffleWordActivity.this, w+" is Not Matched",
                            Toast.LENGTH_SHORT).show();
                }*/


            }
        });

    }

    public void showWord(int i) {

        final Character[] word = shuffleWord(words[i]);
        final ArrayAdapter<Character> adapter = new ArrayAdapter<Character>(ShuffleWordActivity.this,
                R.layout.spinner_values, word);
        listView.setAdapter(adapter);
        //Toast.makeText(this, shuffleWord(), Toast.LENGTH_SHORT).show();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapterView.getItemAtPosition(i).toString();
                textView.append(selectedItem);
                //adapter.remove(selectedItem);
            }
        });
    }


    private Character[] shuffleWord(String word) {
        ArrayList<Character> chars = new ArrayList<>(word.length());
        for (char c : word.toCharArray()) {
            chars.add(c);

        }
        Collections.shuffle(chars);
        Character[] shuffeled = new Character[chars.size()];
        for (int i = 0; i < shuffeled.length; i++) {
            shuffeled[i] = chars.get(i);
        }

        //char[] shuffeledword = new char[0];
        return shuffeled;

    }
}
