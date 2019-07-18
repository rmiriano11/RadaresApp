package com.example.radaresapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button solicitacao = (Button) findViewById(R.id.buttonSolicitacao);
        solicitacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, SolicitacaoViagens.class);
                startActivity(it);
            }
        });

        Button pendentes = (Button) findViewById(R.id.buttonPendentes);
        pendentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent is = new Intent(MainActivity.this, ViagensPendentes.class);
                startActivity(is);
            }
        });

    }

}
