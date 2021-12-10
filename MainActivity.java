package com.example.appcita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {


    private Button btnProgramadas;
    private Button btnPedir;
    private Button btnAnular;
    private Button btnCambiar;

    public static SQLiteDatabase db;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btnProgramadas=(Button) findViewById(R.id.btnProgramadas);
        btnPedir=(Button) findViewById(R.id.btnPedir);
        btnAnular=(Button) findViewById(R.id.btnAnular);
        btnCambiar=(Button) findViewById(R.id.btnCambiar);

        //Abrimos la base de datos "DBCitas" en modo de escritura
        CitasSQLiteHelper usdbh= new CitasSQLiteHelper(this, "DBCita", null, 1);
        db=usdbh.getWritableDatabase();
        //usdbh.onUpgrade(db,1,2);


        btnProgramadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Abrimos otro actividad
                Intent intent = new Intent(MainActivity.this, Consultar.class);
                startActivity(intent);
            }
        });

        btnPedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Abrimos otro actividad
                Intent intent = new Intent(MainActivity.this, Pedir1.class);
                startActivity(intent);
            }
        });


        btnAnular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Abrimos otro actividad
                Intent intent = new Intent(MainActivity.this, Anular.class);
                startActivity(intent);
            }
        });

        btnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Abrimos otro actividad
                Intent intent = new Intent(MainActivity.this, Actualizar.class);
                startActivity(intent);
            }
        });




 /*       calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                String  curDate = String.valueOf(dayOfMonth);
                String  Year = String.valueOf(year);
                String  Month = String.valueOf(month);

                data=Year+"/"+Month+"/"+curDate;


            }
        });*/






    }
}