package com.example.alejandro.porquimetro;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;


public class Index extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }

    public void alerta(View v)
    {
        Toast.makeText(this,"Estas reportando",Toast.LENGTH_SHORT).show();
    }

    public void goBuscarP(View v)
    {
        Intent intent = new Intent(this,BuscarP.class);
        startActivity(intent);
    }

    public void goBuscarL(View v)
    {
        Intent intent = new Intent(this,Articulo.class);
        startActivity(intent);
    }

    public void goReportar(View v)
    {
        Intent intent = new Intent(this,Reportar.class);
        startActivity(intent);
    }
}




/*
        reporta = (Button)findViewById(R.id.Reporta);
        reporta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(Index.this, "Hemos registrado al puerco", Toast.LENGTH_LONG).show();
                Intent intentopuerco = new Intent(Index.this, Reportar.class);
                startActivity(intentopuerco);
            }
        });
        */