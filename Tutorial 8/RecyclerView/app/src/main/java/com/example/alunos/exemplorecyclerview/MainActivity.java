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

        listaLivros.add(new Livro ("Harry Potter e a Pedra Filosofal", "J. K. Rowling",
                "Fantasia sobre um mundo onde bruxos e pessoas normais coexistem"));
        listaLivros.add(new Livro ("Prelúdio de Sangue", "Jean Plaudy",
                "Romance narrativo sobre a família Plantageneta, a que mais durou no trono inglês"));
        listaLivros.add(new Livro ("O Cortiço", "Aluíso Azevedo",
                "Naturalismo no Brasil, em especial no Rio de Janeiro"));

        rview.setAdapter(new LivroAdapter(listaLivros, this));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        rview.setLayoutManager(layout);
    }
}
