package com.example.alejandro.porquimetro.fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.alejandro.porquimetro.Articulo;
import com.example.alejandro.porquimetro.R;
import com.example.alejandro.porquimetro.Reportar;


public class mostrarPorki extends Fragment  implements  View.OnClickListener{

    public mostrarPorki() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_mostrar_porki, container, false);

        Button b = (Button) v.findViewById(R.id.reportarP);
        b.setOnClickListener((View.OnClickListener) this);

        Button a = (Button) v.findViewById(R.id.buscarA);
        a.setOnClickListener((View.OnClickListener) this);

        return v;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reportarP:

                Intent intent = new Intent(getActivity(),Reportar.class);
                startActivity(intent);

                break;
            case R.id.buscarA:

                Intent intent2 = new Intent(getActivity(),Articulo.class);
                startActivity(intent2);

                break;
        }
    }
}

/*
public class mostrarPorki extends Fragment {

    public mostrarPorki()
    {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mostrar_porki, container, false);
        return v;
    }

}
*/