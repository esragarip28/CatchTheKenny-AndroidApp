package com.esragarip.catchkenny;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void level1(View view){

        Intent intent =new Intent(MainActivity.this,MainActivity2.class);
         intent.putExtra("milisecond","1000");
        startActivity(intent);
    }

    public void level2(View view){
        Intent intent =new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("milisecond","500");
        startActivity(intent);

    }
    public void level3(View view){
        Intent intent =new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("milisecond","350");
        startActivity(intent);

    }
    public void level4(View view){
        Intent intent =new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("milisecond","250");
        startActivity(intent);

    }
    public void level5(View view){
        Intent intent =new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("milisecond","100");
        startActivity(intent);

    }


}