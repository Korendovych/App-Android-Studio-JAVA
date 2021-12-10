package com.example.appcita;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Pedir2 extends AppCompatActivity {

    private EditText edtNombre;
    private EditText edtApellidos;
    private EditText edtNIE;
    private EditText edtFechaN;
    private EditText edtTelefono;
    private EditText edtHora;
    private RadioGroup rgAtencion;
    private RadioButton rbMedico;
    private RadioButton rbEnfermero;
    private RadioButton rbVacuna;
    private ImageButton btnVolverP2;
    private Button btnConfirmar;

    //info de radio buttons
    private String atencion;
    //variables globales
    public static String codCita;

    //fragment
    private PopUp PopUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedir2);
        getSupportActionBar().hide();


        edtNombre=(EditText) findViewById(R.id.edtNombre);
        edtApellidos=(EditText) findViewById(R.id.edtApellidos);
        edtNIE=(EditText) findViewById(R.id.edtNIE);
        edtFechaN=(EditText) findViewById(R.id.edtFechaN);
        edtTelefono=(EditText) findViewById(R.id.edtTelefono);
        edtHora=(EditText) findViewById(R.id.edtHora);

        rgAtencion=(RadioGroup) findViewById(R.id.rgAtencion);
        rbMedico=(RadioButton) findViewById(R.id.rbMedico);
        rbEnfermero=(RadioButton) findViewById(R.id.rbEnfermero);
        rbVacuna=(RadioButton) findViewById(R.id.rbVacuna);

        btnVolverP2=(ImageButton) findViewById(R.id.btnVolverP2);
        btnConfirmar=(Button) findViewById(R.id.btnConfirmar);

        //Asignamos valor de check button
        rgAtencion.setOnCheckedChangeListener((group, checkedId) -> {
            if(checkedId==R.id.rbMedico){
                atencion="MEDICO";
            }

            if(checkedId==R.id.rbEnfermero){
                atencion="ENFERMERO";
            }

            if(checkedId==R.id.rbVacuna){
                atencion="VACUNA";
            }

        });


        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Recuperamos los valores de los campos de texto
                String nombreS = edtNombre.getText().toString();
                String apellidosS = edtApellidos.getText().toString();
                String nieS = edtNIE.getText().toString();
                String fechaNS = edtFechaN.getText().toString();
               // int telefonoS = Integer.parseInt(edtTelefono.getText().toString());
                String telefonoS=edtTelefono.getText().toString();
                String horaS = edtHora.getText().toString();

                //Creamos Primary Key
             //   String codCitaS = Pedir1.data+horaS+nieS;
                codCita = Pedir1.data+horaS+nieS;


                //Insertamos datos a la tabla
// String sqlCreate = "CREATE TABLE Citas(codCita TEXT, nombre TEXT, apellidos TEXT, nie TEXT, fechaN TEXT, telefono INTEGER, hora TEXT, fechaC TEXT, atencion TEXT)";
                //Metodo2 --Insert
                ContentValues nuevoRegistro = new ContentValues();
                nuevoRegistro.put("codCita",codCita);
                nuevoRegistro.put("nombre",nombreS);
                nuevoRegistro.put("apellidos",apellidosS);
                nuevoRegistro.put("nie",nieS);
                nuevoRegistro.put("fechaN",fechaNS);
                nuevoRegistro.put("telefono",telefonoS);
                nuevoRegistro.put("hora",horaS);
                nuevoRegistro.put("fechaC", Pedir1.data);
                nuevoRegistro.put("atencion",atencion);
                MainActivity.db.insert("Cita", null, nuevoRegistro);

                //pop up con codigo identificador de cita
                PopUp=new PopUp();
                getSupportFragmentManager().beginTransaction().add(android.R.id.content, PopUp).commit();

            }
        });





        btnVolverP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Abrimos otro actividad
                Intent intent = new Intent(Pedir2.this, Pedir1.class);
                startActivity(intent);
            }
        });

    }
}