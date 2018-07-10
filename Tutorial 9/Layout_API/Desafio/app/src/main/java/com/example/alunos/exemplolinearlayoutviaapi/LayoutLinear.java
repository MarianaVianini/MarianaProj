package com.example.alunos.exemplolinearlayoutviaapi;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.alunos.exemplolinearlayoutviaapi.model.Pessoa;

import java.util.ArrayList;

import static java.lang.String.format;

public class LayoutLinear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayout layout = new LinearLayout(this);
        layout.setPadding(10, 10, 10, 10);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

        layout.setPadding(10, 10, 10, 10);

        try {
            Intent intent = getIntent();
            Bundle bundle = intent.getExtras();

            ArrayList<Pessoa> lista = bundle.getParcelableArrayList("contatos");

            int tam = lista.size();

            for (int i = 0; i < tam; i++) {
                final TextView text = new TextView(this);
                text.setText(format("Contato %s %s", lista.get(i).getNome(), lista.get(i).getTelefone()));
                text.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

                layout.addView(text);
            }

        }catch (Exception e){
            Log.d("erro", e.getMessage());
        }
        setContentView(layout);
    }

}
