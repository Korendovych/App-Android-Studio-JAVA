package com.example.appcita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

public class Actualizar extends AppCompatActivity {

    private EditText edtIdentificadorCita;
    private EditText edtHoraNueva;
    private Button btnCambiarCita;
    private CalendarView calendarView2;
    private String data2;

    //fragment
    private PopUp PopUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);
        getSupportActionBar().hide();

        btnCambiarCita= (Button) findViewById(R.id.btnCambiarCita);
        edtIdentificadorCita=(EditText) findViewById(R.id.edtIdentificadorCita);
        edtHoraNueva= (EditText) findViewById(R.id.edtHoraNueva);
        calendarView2=(CalendarView) findViewById(R.id.calendarView2);

//String sqlCreate = "CREATE TABLE Cita(codCita TEXT, nombre TEXT, apellidos TEXT, nie TEXT, fechaN TEXT, telefono INTEGER, hora TEXT, fechaC TEXT, atencion TEXT)";

        calendarView2.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                String  curDate = String.valueOf(dayOfMonth);
                String  Year = String.valueOf(year);
                String  Month = String.valueOf(month+1);

                data2=Year+"/"+Month+"/"+curDate; // guardamos en variable global
            }
        });

        btnCambiarCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fechaN=data2;
                String horaN= edtHoraNueva.getText().toString();
                String Identificador= edtIdentificadorCita.getText().toString();


                ContentValues valores = new ContentValues();
                valores.put("fechaC",fechaN);
                valores.put("hora",horaN);
                MainActivity.db.update("Cita", valores, "codCita='"+Identificador+"'",null);


                //pop up con codigo identificador de cita
                PopUp=new PopUp();
                getSupportFragmentManager().beginTransaction().add(android.R.id.content, PopUp).commit();

            }
        });




    }
}














