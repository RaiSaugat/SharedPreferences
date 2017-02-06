package com.example.rai.sharedpreferencesdemo;

import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import it.sephiroth.android.library.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    String MYPREFERENCES ="ASMT";
    String Name = "user_name";
    String Phone = "user_phone";
    String Email= "user_email";
    EditText name, phone, email;
    Button bset, bget, bclear;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.editName);
        phone = (EditText)findViewById(R.id.editPhone);
        email = (EditText)findViewById(R.id.editEmail);
        bset = (Button) findViewById(R.id.btnSet);
        img = (ImageView)findViewById(R.id.image);
        Picasso.with(this).load("http://vignette2.wikia.nocookie.net/fifa/images/2/26/Manchester_United_logo.png/revision/latest?cb=20120420192747").into(img);

        bset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = name.getText().toString();
                String emailAdd = email.getText().toString();
                String PhoneNo = phone.getText().toString();
                    sharedPreferences = getSharedPreferences(MYPREFERENCES, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(Name, user);
                    editor.putString(Email, emailAdd);
                    editor.putString(Phone, PhoneNo);
                    Toast.makeText(MainActivity.this, "Data Entered Successfully", Toast.LENGTH_SHORT).show();
                    name.setText("");
                    email.setText("");
                    phone.setText("");
                    editor.commit();

            }
        });
        bget = (Button)findViewById(R.id.btnGet);
        bget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences(MYPREFERENCES, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String na = sharedPreferences.getString(Name, "No name");
                String em = sharedPreferences.getString(Email, "No name");
                String ph = sharedPreferences.getString(Phone, "No name");
                name.setText(na);
                phone.setText(ph);
                email.setText(em);
                Toast.makeText(MainActivity.this, "Data Retrived Successfully", Toast.LENGTH_SHORT).show();
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
                name.setText("");
                email.setText("");
                phone.setText("");
                Toast.makeText(MainActivity.this, "Data Cleared", Toast.LENGTH_SHORT).show();
                editor.commit();
            }
        });
    }
}
