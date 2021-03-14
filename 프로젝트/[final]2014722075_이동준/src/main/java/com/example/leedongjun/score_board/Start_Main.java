package com.example.leedongjun.score_board;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Start_Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__main);

        startLoading();
    }
    private void startLoading()       {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable()       {
            public void run()
            {
                Intent s = new Intent(getApplicationContext()
                        , MainActivity.class);
                startActivity(s);
                finish();
            }
        },2000);

    }
}
