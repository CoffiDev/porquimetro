package com.example.alejandro.porquimetro.fragments;

import android.app.Activity;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.alejandro.porquimetro.R;


public class buscarPorki extends Fragment implements View.OnClickListener{

    public buscarPorki()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_buscar_porki, container, false);

        Button b = (Button) v.findViewById(R.id.buscar);
        b.setOnClickListener((View.OnClickListener) this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buscar:

                Toast.makeText(getActivity(), "Estas buscando un porki", Toast.LENGTH_SHORT).show();

                break;
        }
    }

}
