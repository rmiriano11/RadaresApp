package com.example.radaresapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.radaresapp.webservice.Api;

import java.util.HashMap;

public class SolicitacaoViagens extends AppCompatActivity {

    private static final int CODE_GET_REQUEST = 1020;
    private static final int CODE_POST_REQUEST = 1025;

    //estanciando os edit e botões
    EditText editTextnomeColab;
    EditText editTextdestinoColab;
    EditText editTextpartidaColab;
    EditText editTextretornoColab;
    EditText editTextterrestreColab;
    EditText editTextaereoColab;
    EditText editTextsolicitanteColab;
    EditText editTextrazaoColab;
    Button buttonenviarSolicit;

    @Override
    protected void onCreate(Bundle savedInstanseState)
    {
        super.onCreate(savedInstanseState);
        setContentView(R.layout.activity_solicitacao);

        //chamando os itens estanciados
        editTextrazaoColab = findViewById(R.id.razaoColab);
        buttonenviarSolicit = findViewById(R.id.enviarSolicit);

        //botão para voltar a tela de inicio
        Button homeSolicitacao = (Button)findViewById(R.id.solicitacaoVolta);
        homeSolicitacao.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent that = new Intent(SolicitacaoViagens.this, MainActivity.class);
                startActivity(that);
            }
        });

       buttonenviarSolicit.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View view) {
               salvarRadaresApp();
           }
       });
    }

    private void salvarRadaresApp()
    {
        String nomeColab = editTextnomeColab.getText().toString().trim();
        String destinoColab = editTextdestinoColab.getText().toString().trim();
        String partidaColab = editTextpartidaColab.getText().toString().trim();
        String retornoColab = editTextretornoColab.getText().toString().trim();
        String terrestreColab = editTextterrestreColab.getText().toString().trim();
        String aereoColab = editTextaereoColab.getText().toString().trim();
        String solicitanteColab = editTextsolicitanteColab.getText().toString().trim();
        String razaoColab = editTextrazaoColab.getText().toString().trim();

        if (TextUtils.isEmpty(nomeColab))
        {
            editTextnomeColab.setError("digite seu nome");
            editTextnomeColab.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(destinoColab))
        {
            editTextdestinoColab.setError("digite seu nome");
            editTextdestinoColab.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(partidaColab))
        {
            editTextpartidaColab.setError("digite seu nome");
            editTextpartidaColab.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(retornoColab))
        {
            editTextretornoColab.setError("digite seu nome");
            editTextretornoColab.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(terrestreColab))
        {
            editTextterrestreColab.setError("digite seu nome");
            editTextterrestreColab.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(aereoColab))
        {
            editTextaereoColab.setError("digite seu nome");
            editTextaereoColab.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(solicitanteColab))
        {
            editTextsolicitanteColab.setError("digite seu nome");
            editTextsolicitanteColab.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(razaoColab))
        {
            editTextrazaoColab.setError("digite seu nome");
            editTextrazaoColab.requestFocus();
            return;
        }
        else
        {
            editTextnomeColab.setText("");
            editTextdestinoColab.setText("");
            editTextpartidaColab.setText("");
            editTextretornoColab.setText("");
            editTextterrestreColab.setText("");
            editTextaereoColab.setText("");
            editTextsolicitanteColab.setText("");
            editTextrazaoColab.setText("");

            Toast.makeText(SolicitacaoViagens.this, "sua solicitação de viagem foi enviada com sucesso",
                    Toast.LENGTH_LONG).show();
        }

        HashMap<String, String> params = new HashMap<>();
        params.put("nome", nomeColab);
        params.put("destino", destinoColab);
        params.put("partida", partidaColab);
        params.put("retorno", retornoColab);
        params.put("terrestre", terrestreColab);
        params.put("aero", aereoColab);
        params.put("solicitante", solicitanteColab);
        params.put("razao", razaoColab);

        /*PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_CREATE_RADARES, params, CODE_POST_REQUEST);
        request.execute();*/
    }
}
