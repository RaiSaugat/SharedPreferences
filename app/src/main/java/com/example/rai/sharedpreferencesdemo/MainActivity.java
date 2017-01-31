package com.example.rai.sharedpreferencesdemo;

import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    String MYPREFERENCES ="ASMT";
    String Name = "user_name";
    EditText edit1;
    Button bset, bget, bclear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = (EditText)findViewById(R.id.editText);
        bset = (Button) findViewById(R.id.btnSet);

        bset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String user = edit1.getText().toString();
                sharedPreferences = getSharedPreferences(MYPREFERENCES, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Name, user);
                editor.commit();

            }
        });
        bget = (Button)findViewById(R.id.btnGet);
        bget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences(MYPREFERENCES, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String msg = sharedPreferences.getString(Name, "No name");
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                editor.commit();
            }
        });

        bclear = (Button) findViewById(R.id.btnClear);
        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences(MYPREFERENCES, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
            }
        });
    }
}
