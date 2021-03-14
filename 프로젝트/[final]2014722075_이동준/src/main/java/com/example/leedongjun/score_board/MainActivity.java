package com.example.leedongjun.score_board;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TextView textView1 = (TextView) findViewById(R.id.maintext);


        ImageButton b1 = (ImageButton) findViewById(R.id.basket);
        b1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext()
                ,Basketball.class);
                startActivity(intent);
            }
        });
        Button Nsport = (Button) findViewById(R.id.naver);
        Nsport.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String url = "https://m.sports.naver.com/basketball/index.nhn";
                Intent intent4 = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
                startActivity(intent4);
            }
        });
        Button KBL = (Button) findViewById(R.id.kbl);
        KBL.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String url2 = "http://m.kbl.or.kr/main.asp";
                Intent intent5 = new Intent(Intent.ACTION_VIEW,Uri.parse(url2));
                startActivity(intent5);
            }
        });
        Button NBA = (Button) findViewById(R.id.nba);
        NBA.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String url3 = "http://mw.nba.com/feature/index.html?tz=GMT+9&dst=0&locale=en_US";
                Intent intent6 = new Intent(Intent.ACTION_VIEW,Uri.parse(url3));
                startActivity(intent6);
            }
        });

        Button Load = (Button) findViewById(R.id.load);
        Load.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent7 = new Intent(getApplicationContext()
                        ,loaddata.class);
                startActivity(intent7);
            }
        });

    }
}
