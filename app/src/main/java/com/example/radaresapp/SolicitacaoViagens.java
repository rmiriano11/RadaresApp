package com.example.radaresapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SolicitacaoViagens extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanseState){
        super.onCreate(savedInstanseState);
        setContentView(R.layout.activity_solicitacao);

        Button homeSolicitacao = (Button)findViewById(R.id.solicitacaoVolta);
        homeSolicitacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent that = new Intent(SolicitacaoViagens.this, MainActivity.class);
                startActivity(that);
            }
        });
    }
}
