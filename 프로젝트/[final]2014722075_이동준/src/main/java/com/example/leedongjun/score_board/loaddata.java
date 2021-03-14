package com.example.leedongjun.score_board;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static android.widget.Toast.LENGTH_LONG;

public class loaddata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loaddata);

        final EditText e = (EditText) findViewById(R.id.Sname);
        Button b = (Button) findViewById(R.id.Find);
        Button b2 = (Button) findViewById(R.id.Delete);
        Button b3 = (Button) findViewById(R.id.deleteAll);
        Button b4 = (Button) findViewById(R.id.searchall);
        final TextView r = (TextView) findViewById(R.id.Show);
        r.setMovementMethod(new ScrollingMovementMethod());
        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("share", MODE_PRIVATE);
                if(!sp.contains(e.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"Not Exist Record",Toast.LENGTH_LONG).show();
                }
                String data = sp.getString(e.getText().toString(), "");
                r.setText(data);
                e.setText("");

            }
        });
        b2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("share", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                if(sp.contains(e.getText().toString()))
                {
                    editor.remove(e.getText().toString());
                    editor.commit();
                    Toast.makeText(getApplicationContext(),"Complete Delete",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Not Exist Record",Toast.LENGTH_LONG).show();
                }
                r.setText("");
                e.setText("");


            }
        });

        b3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("share", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.clear();
                editor.commit();
                e.setText("");
                r.setText("");
                Toast.makeText(getApplicationContext(),"Complete Delete All",Toast.LENGTH_LONG).show();

            }
        });

        b4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("share", MODE_PRIVATE);

                String all = "";
                Map<String,?> s = sp.getAll();
                for(Map.Entry<String,?> entry : s.entrySet())
                {
                    String data = sp.getString(entry.getKey(), "");
                    all = all + data;
                }
                e.setText("");
                r.setText(all);

            }
        });
    }
}
