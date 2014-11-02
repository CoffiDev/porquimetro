package com.example.alejandro.porquimetro;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class mostrarP extends ActionBarActivity {

    TextView placa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_p);

        String tplaca= getIntent().getStringExtra("placa") + "--"+ getIntent().getStringExtra("lat") + "--" +getIntent().getStringExtra("lon");
        placa = (TextView)findViewById(R.id.placa);

        placa.setText("Placa del oficial: "+tplaca);


    }

}
