package com.example.appcita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Anular extends AppCompatActivity {

    private ImageButton btnVolverAnular;
    private Button btnAnularA;
    private EditText edtCitaAnular;

    //fragment
    private PopUp2 PopUp2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anular);
        getSupportActionBar().hide();


        edtCitaAnular = (EditText) findViewById(R.id.edtCitaAnular);
        btnAnularA=(Button) findViewById(R.id.btnAnularA);
        btnVolverAnular=(ImageButton) findViewById(R.id.btnVolverAnular);




        btnVolverAnular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Abrimos otro actividad
                Intent intent = new Intent(Anular.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnAnularA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String nie = edtCitaAnular.getText().toString();
                String codCita2 = edtCitaAnular.getText().toString();
// String sqlCreate = "CREATE TABLE Cita(codCita TEXT, nombre TEXT, apellidos TEXT, nie TEXT, fechaN TEXT, telefono INTEGER, hora TEXT, fechaC TEXT, atencion TEXT)";
             //  MainActivity.db.delete("Cita", "nie='"+nie"'", null);

                String sql = "DELETE FROM Cita WHERE codCita='"+codCita2+"'";
                MainActivity.db.execSQL(sql);

             //   Intent intent = new Intent(Anular.this, MainActivity.class);
             //   startActivity(intent);

                //pop up con codigo identificador de cita
                PopUp2=new PopUp2();
                getSupportFragmentManager().beginTransaction().add(android.R.id.content, PopUp2).commit();

            }
        });




    }
}



















