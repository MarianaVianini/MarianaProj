package com.example.alunos.exemplorecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.alunos.exemplorecyclerview.adapter.LivroAdapter;
import com.example.alunos.exemplorecyclerview.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private ArrayList<Livro> listaLivros;
    RecyclerView rview;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rview = findViewById(R.id.recyclerView);
        listaLivros = new ArrayList<>();

        listaLivros.add(new Livro ("Capitães da Areia", "Jorge Amado",
                "Grupo de menores abandonados que crescem nas ruas..."));
        listaLivros.add(new Livro ("Jogos Vorazes", "Suzanne Collins",
                "Distopia de jovens pobres que lutam até a morte em um jogo..."));
        listaLivros.add(new Livro ("Revolução dos Bichos", "George Orwell",
                "Romance satírico no qual os animais de uma granja decidem fazer uma revolução..."));

        rview.setAdapter(new LivroAdapter(listaLivros, this));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        rview.setLayoutManager(layout);
    }
}
