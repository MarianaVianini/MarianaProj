package com.example.alunos.random;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public int x, y, tentativas;
    TextView numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random ran = new Random();
        x = ran.nextInt(1001);
    }

    public void jogar(View args) {
        tentativas++;
        numero = findViewById(R.id.numero);
        y = Integer.parseInt(numero.getText().toString());
        if (x!=y) {
            if (x>y) {
                Toast.makeText(getApplicationContext(), "Você errou! O número é maior", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Você errou! O número é menor", Toast.LENGTH_SHORT).show();
            }
        } else {
            this.notificacao("Você ganhou!", String.format("Você acertou em: %d tentativas. Deseja jogar novamente?", tentativas));
        }
    }

    public void gerador() {
        Random ran = new Random();
        x = ran.nextInt(101);
        numero.setText("");
        tentativas = 0;
    }

    public void notificacao(String title, String msg) {
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
