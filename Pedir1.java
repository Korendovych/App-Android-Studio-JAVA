package com.example.appcita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

public class Pedir1 extends AppCompatActivity {

    private Button btnConfirmar;
    public static String data;
    private CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedir1);

        getSupportActionBar().hide();


        btnConfirmar= (Button) findViewById(R.id.btnConfirmar);
        calendarView=(CalendarView) findViewById(R.id.calendarView);


        //sacamos fecha elegida del calendario
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                String  curDate = String.valueOf(dayOfMonth);
                String  Year = String.valueOf(year);
                String  Month = String.valueOf(month+1);

                data=Year+"/"+Month+"/"+curDate; // guardamos en variable global
            }
        });

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Abrimos otro actividad
                Intent intent = new Intent(Pedir1.this, Pedir2.class);

                startActivity(intent);
            }
        });





    }
}