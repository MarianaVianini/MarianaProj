package com.example.alunos.exemplolinearlayoutviaapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.example.alunos.exemplolinearlayoutviaapi.model.Pessoa;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<Pessoa> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayout layout = new LinearLayout(this);
        layout.setPadding(10, 10, 10, 10);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

        layout.setPadding(10, 10, 10, 10);

        final TextView nome = new TextView(this);
        nome.setText("Nome: ");
        nome.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        layout.addView(nome);

        final EditText tnome = new EditText(this);
        tnome.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        layout.addView(tnome);
        tnome.requestFocus();

        final TextView telefone = new TextView(this);
        telefone.setText("Telefone: ");
        telefone.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        layout.addView(telefone);

        final EditText ttelefone = new EditText(this);
        ttelefone.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        layout.addView(ttelefone);

        Button salvar = new Button(this);
        salvar.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        salvar.setText("SALVAR");
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lista.add(new Pessoa(tnome.getText().toString(), ttelefone.getText().toString(), R.mipmap.ic_launcher_round));
                tnome.setText("");
                ttelefone.setText("");
            }
        });
        layout.addView(salvar);

        Button  carregar = new Button(this);
        carregar.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        carregar.setText("CARREGAR");
        carregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getBaseContext(), LayoutLinear.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("contatos", lista);
                it.putExtras(bundle);
                startActivity(it);
            }
        });
        layout.addView(carregar);


        setContentView(layout);
    }

}
