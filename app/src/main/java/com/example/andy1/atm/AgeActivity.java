package com.example.andy1.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AgeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
    }
    public void next (View view){
        EditText edAge=findViewById(R.id.edAge);
        String age = edAge.getText().toString();
        getSharedPreferences("info",MODE_PRIVATE)
                .edit()
                .putString("AGE",age)
                .apply();
        Intent gender = new Intent(this,GenderActivity.class);
        startActivity(gender);
    }
}
