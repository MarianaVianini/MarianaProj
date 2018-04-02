package com.example.alunos.novoapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    public int x, y, tentativas;
    TextView numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jogar(View args) {
        tentativas --;
        numero = findViewById(R.id.numero);
        y = Integer.parseInt(numero.getText().toString());
        if  (x == y) {
            this.notificacao("Você ganhou!", String.format("O número era: %d. Deseja jogar novamente?", x));
        } else {
            Toast.makeText(getApplicationContext(),"Você errou, tente novamente!", Toast.LENGTH_SHORT).show();
        }
        if (tentativas<0) {
            this.notificacao("Você perdeu!", String.format("O número era: %d. Deseja jogar novamente?", x));
        }
    }

    public void gerador() {
        Random ran = new Random();
        x = ran.nextInt(11);
        numero.setText("");
        tentativas = 2;
    }

    public void notificacao(String title, String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(title);
        builder.setMessage(msg);

        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                gerador();
            }
        });

        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
                System.exit(0);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

