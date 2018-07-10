package com.example.alunos.exemplolinearlayoutviaapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_main);
        LinearLayout layout = findViewById(R.id.layout1);
        for(int i = 0; i < 100; i++){
            LayoutInflater inflater = LayoutInflater.from(this);
            TextView text = (TextView) inflater.inflate(R.layout.inflate_textview, layout, false);
            text.setText("Texto : "+ i);
            layout.addView(text);
        }
    }
}
