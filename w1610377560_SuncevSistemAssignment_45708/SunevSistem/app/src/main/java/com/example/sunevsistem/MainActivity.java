package com.example.sunevsistem;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Paint paint;
    Canvas canvas;

    ImageView imageView;
    int[] screenDimensions;

    Timer timer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screenDimensions = getDisplayDimensions();


        Bitmap bitmap = Bitmap.createBitmap(1000,1000, Bitmap.Config.ARGB_8888);

        canvas = new Canvas();
        paint = new Paint();
        canvas.setBitmap(bitmap);


        imageView = (ImageView) findViewById(R.id.imageViewSuncevSistem);
        imageView.setImageBitmap(bitmap);


        timer = new Timer();
        timer.schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        renderFrame();
                                    }
                                }
                        );
                    }
                }, 200, 40);
    }

    private int[] getDisplayDimensions() {
        DisplayMetrics displayMetrics = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        return new int[]{width, height};
    }



private void renderFrame() {

    canvas.drawColor(Color.parseColor("#EBEBEB"));


   paint.setColor(Color.YELLOW);
   canvas.drawCircle(500, 500, 50, paint);


    paint.setColor(Color.BLUE);
    canvas.drawCircle(300,300,30,paint);
    canvas.rotate(10f,500,500);

    paint.setColor(Color.RED);
    canvas.drawCircle(200,200,20,paint);
    canvas.rotate(-15f,500,500);

    paint.setColor(Color.GREEN);
    canvas.drawCircle(400,400,30,paint);
    canvas.rotate(-360f,500,500);

    paint.setColor(Color.GRAY);
    canvas.drawCircle(350,350,10,paint);
    canvas.rotate(-20f,500,500);


         imageView.invalidate();
    }


}