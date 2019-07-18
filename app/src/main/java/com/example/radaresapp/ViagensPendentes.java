package com.example.radaresapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ViagensPendentes extends AppCompatActivity {
    @Override
    protected void onCreate (Bundle savedIntanceSatate){
        super.onCreate(savedIntanceSatate);
        setContentView(R.layout.activity_pendentes);

        Button homePendentes = (Button)findViewById(R.id.voltarPendentes);
        homePendentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent that = new Intent(ViagensPendentes.this, MainActivity.class);
                startActivity(that);
            }
        });
    }
}
