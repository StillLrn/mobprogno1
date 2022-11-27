package com.example.pert3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView output = findViewById(R.id.textView);
        Intent getIntent = getIntent();

        String name = getIntent.getStringExtra("name");
        String gender = getIntent.getStringExtra("gender");
        String city = getIntent.getStringExtra("city");
        String hobby = getIntent.getStringExtra("hobby");
        String agree = getIntent.getStringExtra("agree");

        output.setText(
                name + "\n" +
                gender + "\n" +
                city + "\n" +
                hobby + "\n" +
                agree + "\n"
        );
    }
}