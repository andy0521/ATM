package com.example.andy1.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends BasicActivity {
    public  static final  int RC_LOGIN=1;
    boolean login =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView nickText = findViewById(R.id.nickname);
        nickText.setText(user.getNickname());
        if(!login){
            Intent intent = new Intent(this, LoginActivity.class);
//        startActivity(intent);
            startActivityForResult(intent,RC_LOGIN);
        }
        List<String> fruits = Arrays.asList("香蕉" ,"鳳梨","芭樂");
        ArrayAdapter<String> adapter = new
                ArrayAdapter<>(this,android.R.layout.simple_list_item_1,fruits);
        ListView listView =findViewById(R.id.list);
        listView.setAdapter(adapter);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== RC_LOGIN){
            if(resultCode != RESULT_OK){
              finish();
            }else{
                login=true;
                if(user.isValid()){
                    Intent nickname = new Intent(this, NickNameActivity.class);
                    startActivity(nickname);
                }
            }
        }
    }


}
