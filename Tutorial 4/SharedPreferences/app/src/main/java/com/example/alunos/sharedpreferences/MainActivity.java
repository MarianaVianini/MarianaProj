package com.example.alunos.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {

    EditText valor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valor = (EditText) findViewById(R.id.txtValor);
    }

    public void salvar(View v) {
        SharedPreferences arquivo = getPreferences(Context.MODE_PRIVATE);
        String oValor = valor.getText().toString();
        if(oValor.matches("")) {
            Toast toast = Toast.makeText(MainActivity.this,
                    "Digite algo...", Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        SharedPreferences.Editor editor = arquivo.edit();
        editor.putString("valor", oValor);
        editor.commit();
    }

    public void carregar(View v) {
        SharedPreferences arquivo = getPreferences(Context.MODE_PRIVATE);
        String oValor = arquivo.getString("valor", "");
        valor.setText(oValor);
        Log.i("oValor:", oValor);
    }
}
