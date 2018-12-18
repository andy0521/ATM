package com.example.andy1.atm;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import javax.xml.validation.ValidatorHandler;

public class AgeActivity extends BasicActivity {
int [] num = {19,20,21,22};
    private EditText edAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter((new AgeAdapter()));
        edAge = findViewById(R.id.edAge);
    }

    public void next (View view){
//        EditText edAge=findViewById(R.id.edAge);
//        String a = edAge.getText().toString();
//        int age = Integer.parseInt(a);
//        user.setAge(age);
        edAge = findViewById(R.id.edAge);
        String a = edAge.getText().toString();
        int age = Integer.parseInt(a);
        user.setAge(age);
        Intent gender = new Intent(this,GenderActivity.class);
        startActivity(gender);
    }
    public void back (View view){
        finish();
    }
    class AgeAdapter extends RecyclerView.Adapter<AgeAdapter.AgeViewHolder>{

        @NonNull
        @Override
        public AgeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view =  getLayoutInflater().inflate(R.layout.age_row,parent,false);

            return (new AgeViewHolder(view));
        }

        @Override
        public void onBindViewHolder(@NonNull AgeViewHolder holder, final int position) {
        holder.ageText.setText(String.valueOf(num[position]));
        if (num[position]==19){
            holder.ageText.setTextColor(Color.RED);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("AgeActivity", "onClick: "+num[position]);

                 edAge.setText(num[position]+"");

              //   int age = Integer.parseInt(((EditText)findViewById(R.id.edAge)).getText().toString());

            }
        });
        }

        @Override
        public int getItemCount() {
            return num.length;
        }

        class AgeViewHolder extends RecyclerView.ViewHolder {
            TextView ageText;

            public AgeViewHolder(View itemView) {

                super(itemView);

                ageText =itemView.findViewById(R.id.tv_age);
            }
        }
    }

}
