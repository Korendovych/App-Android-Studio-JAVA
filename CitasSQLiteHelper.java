package com.example.appcita;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CitasSQLiteHelper extends SQLiteOpenHelper {

    //Sentencia SQL para crear la tabla Usuarios

    String sqlCreate = "CREATE TABLE Cita(codCita TEXT, nombre TEXT, apellidos TEXT, nie TEXT, fechaN TEXT, telefono INTEGER, hora TEXT, fechaC TEXT, atencion TEXT)";

    public CitasSQLiteHelper(MainActivity contexto, String codCita, SQLiteDatabase.CursorFactory factory, int version) {

        super(contexto, codCita, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int VersionAnterior, int versionNueva) {

        //Se elimina la versio anterior
        db.execSQL("DROP TABLE IF EXISTS Cita");

        //Se crea la nueva version de la tabla
        db.execSQL(sqlCreate);
    }

}
