package com.example.alejandro.porquimetro;

import android.app.ActionBar;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class BuscarP extends ActionBarActivity {

    EditText busqueda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_p);

    }

    public void buscar(View v)
    {
        busqueda = (EditText)findViewById(R.id.placabuscar);

        String bus = busqueda.getText()+"";

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, true);
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        //location.getLongitude();
        //location.getAltitude();
        /*
        Intent intent = new Intent(this, mostrarP.class);
        intent.putExtra("placa", bus);



        intent.putExtra("lat", "ddd");
        intent.putExtra("lon", "ddd");

        startActivity(intent);

        */
    }


}
