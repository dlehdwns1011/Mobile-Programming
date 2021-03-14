package com.example.leedongjun.score_board;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Basketball extends AppCompatActivity {


    private TextView HomeScore, HomeFour;
    private TextView AwayScore, AwayFour;

    Button H2,H3,H1,Hf;
    Button A2,A3,A1,Af;
    Button Reset,Start,Stop,Buzzer,Save;
    Chronometer c;
    int FS = 0; int GS = 0; long i;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball);



        TextView HomeText = (TextView) findViewById(R.id.Home);
        TextView AwayText = (TextView) findViewById(R.id.Away);

        HomeScore = (TextView) findViewById(R.id.HomeS);
        AwayScore = (TextView) findViewById(R.id.AwayS);
        HomeFour = (TextView) findViewById(R.id.HomeFour);
        AwayFour = (TextView) findViewById(R.id.AwayFour);


        H2 = (Button) findViewById(R.id.Home2);
        A2 = (Button) findViewById(R.id.Away2);
        H3 = (Button) findViewById(R.id.Home3);
        A3 = (Button) findViewById(R.id.Away3);
        H1 = (Button) findViewById(R.id.Home1);
        A1 = (Button) findViewById(R.id.Away1);
        Hf = (Button) findViewById(R.id.HomeF);
        Af = (Button) findViewById(R.id.AwayF);
        Reset = (Button) findViewById(R.id.Reset);
        Buzzer = (Button) findViewById(R.id.Buzzer);
        final SoundPool pool;
        pool = new SoundPool(1,AudioManager.STREAM_MUSIC,0);
        final int ddok = pool.load(this, R.raw.buzzer, 1);
        Start = (Button) findViewById(R.id.Start);
        c = (Chronometer) findViewById(R.id.timer);
        Stop = (Button) findViewById(R.id.Stop);

        Save = (Button) findViewById(R.id.save);



        H2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(HomeScore.getText().toString());
                a+=2;
                HomeScore.setText(Integer.toString(a));
            }
        });
        A2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(AwayScore.getText().toString());
                a+=2;
                AwayScore.setText(Integer.toString(a));
            }
        });
        H3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(HomeScore.getText().toString());
                a+=3;
                HomeScore.setText(Integer.toString(a));
            }
        });
        A3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(AwayScore.getText().toString());
                a+=3;
                AwayScore.setText(Integer.toString(a));
            }
        });
        H1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(HomeScore.getText().toString());
                a++;
                HomeScore.setText(Integer.toString(a));
            }
        });
        A1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(AwayScore.getText().toString());
                a++;
                AwayScore.setText(Integer.toString(a));
            }
        });
        Hf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(HomeFour.getText().toString());
                a++;
                HomeFour.setText(Integer.toString(a));
            }
        });
        Af.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(AwayFour.getText().toString());
                a++;
                AwayFour.setText(Integer.toString(a));
            }
        });

        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeScore.setText("0");
                AwayScore.setText("0");
                HomeFour.setText("0");
                AwayFour.setText("0");
                c.setBase(SystemClock.elapsedRealtime());
                c.stop();
                FS = 0; GS = 0;
            }
        });

        Buzzer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(ddok, 1, 1, 0, 0, 1);
            }
        });

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(GS == 0) {
                    if (FS == 0) {
                        c.setBase(SystemClock.elapsedRealtime());
                        c.start();
                        GS = 1;
                        pool.play(ddok, 1, 1, 0, 0, 1);
                    } else {
                        c.setBase(SystemClock.elapsedRealtime() + i);
                        c.start();
                        FS = 0;
                        GS = 1;
                    }
                }
            }
        });

        Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(GS == 1)
                {
                    if(FS == 0)//stop
                    {
                        c.stop();
                        i = c.getBase() - SystemClock.elapsedRealtime();
                        FS = 1;
                        GS = 0;
                    }
                }

            }
        });

        Save.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                AlertDialog.Builder dlg = new AlertDialog.Builder(Basketball.this);
                dlg.setTitle("Save Score");

                final EditText name = new EditText(Basketball.this);

                dlg.setView(name);

                dlg.setPositiveButton("Save",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences share = getSharedPreferences("share", MODE_PRIVATE);
                                SharedPreferences.Editor editor = share.edit();
                                editor.putString(name.getText().toString(), "<"+name.getText().toString()
                                        +">\nHOME  "+HomeScore.getText().toString()+" : "+AwayScore.getText().toString()+"  AWAY\n");
                                editor.commit();
                                Toast.makeText(getApplicationContext(),"Complete Save",Toast.LENGTH_LONG).show();
                            }
                        });
                dlg.show();

            }

        });


    }
}
