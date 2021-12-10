package com.example.appcita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Medidas extends AppCompatActivity {

    private ImageButton ibtnVolverMedidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medidas);
        getSupportActionBar().hide();

        ibtnVolverMedidas=(ImageButton) findViewById(R.id.ibtnVolverMedidas);


        ibtnVolverMedidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Abrimos otro actividad
                Intent intent = new Intent(Medidas.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}