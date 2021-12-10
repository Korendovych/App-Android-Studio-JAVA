package com.example.appcita;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class PopUp extends Fragment {

    private  TextView identificatorCita;
    private  Button btnOK;



    public PopUp() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_pop_up, container, false);

        final View view = inflater.inflate(R.layout.fragment_pop_up, container, false);

        identificatorCita=(TextView) view.findViewById(R.id.identificatorCita);
        btnOK=(Button) view.findViewById(R.id.btnOK);

        identificatorCita.setText(Pedir2.codCita.toString());

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              // getActivity().onBackPressed();
                Intent intent = new Intent(getActivity(), Medidas.class);
                startActivity(intent);

            }
        });


        return view;


    }
}



























