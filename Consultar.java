package com.example.appcita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

public class Consultar extends AppCompatActivity {


    private Button btnConsultar;
    private TextView tvCitasProgramadas;
    private EditText edtNIE2;
    private ImageButton btnVolverP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);
        getSupportActionBar().hide();

        btnConsultar=(Button) findViewById(R.id.btnConsultar);
        tvCitasProgramadas = (TextView) findViewById(R.id.tvCitasProgramadas);
        edtNIE2= (EditText) findViewById(R.id.edtNIE2);
        btnVolverP= (ImageButton) findViewById(R.id.btnVolverP);

        btnVolverP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Abrimos otro actividad
                Intent intent = new Intent(Consultar.this, MainActivity.class);
                startActivity(intent);

            }
        });

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String niee = edtNIE2.getText().toString();
                //Metodo1 -- rowQuery()
                Cursor c = MainActivity.db.rawQuery("SELECT * FROM Cita WHERE nie='"+niee+"'", null);
               // Cursor c = MainActivity.db.rawQuery("SELECT * FROM Cita", null);

                //Reccorremos los resultados para mostrarlos en pantalla
                tvCitasProgramadas.setText("");
                if(c.moveToFirst()){

                    //Recorremos al cursor hasta que no haya más registros
                    do{
//String sqlCreate = "CREATE TABLE Citas(codCita TEXT, nombre TEXT, apellidos TEXT, nie TEXT, fechaN TEXT, telefono INTEGER, hora TEXT, atencion TEXT)";
                        String codCitaP = c.getString(0);
                        String nombreP = c.getString(1);
                        String apellidosP = c.getString(2);
                        String nieP = c.getString(3);
                        String fechaNP = c.getString(4);
                        int telefonoP = c.getInt(5);
                        String horaP = c.getString(6);
                        String fechaCP = c.getString(7);
                        String atencionP = c.getString(8);

                        tvCitasProgramadas.append("Paciente:         "+nombreP+ " "+apellidosP+"\n");
                        tvCitasProgramadas.append("NIE/DNI:          "+nieP+"\n");
                        tvCitasProgramadas.append("Cita:                  "+fechaCP+" "+horaP+"\n");
                        tvCitasProgramadas.append("Identificador:  "+codCitaP+"\n");

                        if(atencionP.equalsIgnoreCase("ENFERMERO")){
                            atencionP="Personal de enfermería";
                            tvCitasProgramadas.append("Atención:          "+atencionP+"\n");
                        }

                        if(atencionP.equalsIgnoreCase("MEDICO")) {
                            atencionP="Médico de familia";
                            tvCitasProgramadas.append("Atención:          "+atencionP+"\n");
                        }
                        if(atencionP.equalsIgnoreCase("VACUNA")) {
                            atencionP="Vacunación del COVID-19";
                            tvCitasProgramadas.append("Atención:          "+atencionP+"\n");
                        }

                    }while(c.moveToNext());

                }
            }
        });







    }
}