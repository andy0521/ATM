package com.example.andy1.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
    }
    public void next (View view){
        EditText edGender=findViewById(R.id.edGender);
        String gender = edGender.getText().toString();
        getSharedPreferences("info",MODE_PRIVATE)
                .edit()
                .putString("GENDER",gender)
                .apply();
        Intent home = new Intent(this,MainActivity.class);
        startActivity(home);
    }
}
