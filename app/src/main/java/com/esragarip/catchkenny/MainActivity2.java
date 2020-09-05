package com.esragarip.catchkenny;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    TextView timeText;
    TextView scoreText;
    TextView highScoreText;
    int number;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
    ImageView imageArray[];
    Handler handler;
    Runnable runnable;
    SharedPreferences sharedPreferences;
    SharedPreferences sharedPreferences2;
    SharedPreferences sharedPreferences3;
    SharedPreferences sharedPreferences4;
    SharedPreferences sharedPreferences5;
    int score=0;
    int score2=0;
    int score3=0;
    int score4=0;
    int score5=0;
    String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        time=intent.getStringExtra("milisecond");
        number=0;
        timeText = findViewById(R.id.timeText);
        scoreText = findViewById(R.id.scoreText);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageView10 = findViewById(R.id.imageView10);
        imageView11 = findViewById(R.id.imageView11);
        imageView12 = findViewById(R.id.imageView12);
        imageArray = new ImageView[]{imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9,
                imageView10, imageView11, imageView12};

        highScoreText = findViewById(R.id.highScoreText);
        //buradaki name isimlerini aynı verdiğimiz zaman depolanan verilerin degeri eşit oluyor...
        sharedPreferences = this.getSharedPreferences("data1", Context.MODE_PRIVATE);
        sharedPreferences2 = this.getSharedPreferences("data2", Context.MODE_PRIVATE);
        sharedPreferences3= this.getSharedPreferences("data3", Context.MODE_PRIVATE);
        sharedPreferences4= this.getSharedPreferences("data4", Context.MODE_PRIVATE);
        sharedPreferences5= this.getSharedPreferences("data5", Context.MODE_PRIVATE);



        if (Long.parseLong(time)==1000){
            score = sharedPreferences.getInt("highScore", 0);
            highScoreText.setText("High Score: " + score);


        }
        else if(Long.parseLong(time)==500){
            score2=sharedPreferences2.getInt("highScore",0);
            highScoreText.setText("High Score: " + score2);


        }
        else if(Long.parseLong(time)==350){
            score3=sharedPreferences3.getInt("highScore",0);
            highScoreText.setText("High Score: " + score3);

        }
        else if(Long.parseLong(time)==250){
            score4=sharedPreferences4.getInt("highScore",0);
            highScoreText.setText("High Score: " + score4);

        }
        else{
            score5=sharedPreferences5.getInt("highScore",0);
            highScoreText.setText("High Score: " + score5);
        }


//        score = sharedPreferences.getInt("highScore", 0);
  //      highScoreText.setText("High Score: " + score);

        hideImages();

        CountDownTimer countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long l) {
                timeText.setText("Time: " + l / 1000);
            }

            @Override
            public void onFinish() {
               // System.out.println("milisecond: "+time);;
                timeText.setText("Time Off Halil:(");
                //System.out.println(number);

                if (Long.parseLong(time)==1000){

                    if (score < number) {
                        score = number;
                        highScoreText.setText("High Score : " + score);
                        sharedPreferences.edit().putInt("highScore", score).apply();

                    }
                    else{
                        highScoreText.setText("High Score : " + score);
                        sharedPreferences.edit().putInt("highScore", score).apply();

                    }

                }
                else if(Long.parseLong(time)==500){

                    if (score2 < number) {
                        score2 = number;


                    }
                    highScoreText.setText("High Score : " + score2);
                    sharedPreferences2.edit().putInt("highScore", score2).apply();

                }
                else if(Long.parseLong(time)==350){

                    if (score3 < number) {
                        score3 = number;


                    }
                    highScoreText.setText("High Score : " + score3);
                    sharedPreferences3.edit().putInt("highScore", score3).apply();

                }
                else if(Long.parseLong(time)==250){

                    if (score4 < number) {
                        score4 = number;


                    }
                    highScoreText.setText("High Score : " + score4);
                    sharedPreferences4.edit().putInt("highScore", score4).apply();

                }
                else{

                    if (score5 < number) {
                        score5 = number;


                    }
                    highScoreText.setText("High Score : " + score5);
                    sharedPreferences5.edit().putInt("highScore", score5).apply();
                }


    /*

                if (score < number) {
                    score = number;
                    highScoreText.setText("High Score : " + score);
                    sharedPreferences.edit().putInt("highScore", score).apply();


                }
    */
                //handlerin calısmasını durdurmak için  yapıyoruz...
                handler.removeCallbacks(runnable);
                for (ImageView image : imageArray) {
                    image.setVisibility(View.INVISIBLE);

                }
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity2.this);
                alertDialog.setMessage("Are you sure to restart game?");
                alertDialog.setTitle("Restart");
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = getIntent();
                        //tıpkı bir aktiviteden baska bir aktiviteye geçerken ki gibi
                        // burdada restart yaptıgımız zaman kendi aktivitemizi tekrar acanken intent kullanıyoruz..
                        //sistemi yormamak için ilk ilk acılan activity i kapatıp tekrar acıyoruz...
                        finish();
                        startActivity(intent);
                    }
                });
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        System.exit(10);
                    }
                });
                alertDialog.show();
            }
        }.start();

    }

    public void increaseScore(View view) {
        number++;
        scoreText.setText("Score: " + number);
    }

    public void decreaseScore(View view) {
        number--;
        scoreText.setText("Score: " + number);
    }

    public void hideImages() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView image : imageArray) {
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i = random.nextInt(12);
                imageArray[i].setVisibility(View.VISIBLE);
                //parametre olarak thşs vermemizin sebebi runnable in içinde olmamız . runnable da yazabiliriz...
                handler.postDelayed(this,Long.parseLong(time));
            }
        };
        handler.post(runnable);
    }
}
