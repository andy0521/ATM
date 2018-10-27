package com.example.andy1.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public  static final  int RC_LOGIN=1;
    boolean login =false;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!login){
        Intent intent = new Intent(this, LoginActivity.class);
//        startActivity(intent);
            startActivityForResult(intent,RC_LOGIN);
        }
    }
}
