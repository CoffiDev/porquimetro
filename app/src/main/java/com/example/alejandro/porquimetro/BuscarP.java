package com.example.alejandro.porquimetro;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class BuscarP extends ActionBarActivity {

    EditText busqueda;
    double latitude; // latitude
    double longitude; // longitude
    private Location myLocation;
    String url = "http://porkimetro.wc.lt/loc.php?";


    private final LocationListener mLocationListener = new LocationListener() {

        @Override
        public void onLocationChanged(Location location) {
            myLocation = location;
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_p);
    }

    public void buscar(View v)
    {
        busqueda = (EditText)findViewById(R.id.placabuscar);

        String bus = busqueda.getText()+"";

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                (long) 5000, (float) 5.0, mLocationListener);
        myLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        myLocation.getLongitude();
        myLocation.getAltitude();

        Toast.makeText(getApplicationContext(),"long :" + Double.toString(myLocation.getLongitude()), Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "lat  :" + Double.toString(myLocation.getLatitude()), Toast.LENGTH_SHORT).show();


        // TextView placa = (TextView) findViewById(R.id.placabuscar);


        String status;
        String urlget= url+ "placa=" + busqueda.getText() + "&lat=" + Double.toString(myLocation.getLatitude()) + "&lon=" + Double.toString(myLocation.getLongitude());

        //Toast.makeText(getApplicationContext(), urlget, Toast.LENGTH_SHORT).show();

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, urlget,  null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //busqueda.setText(response+"");
                            // num.setText("Numero: " + response.getString("placa"));
                            //status = response;
                            response.getString("placa");
                            //Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                            //response.getBoolean("placa");

                        } catch (JSONException e) {
                            e.printStackTrace();

                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                        // TODO Auto-generated method stub
                        // Toast.makeText(getApplicationContext(), "Registrado", Toast.LENGTH_SHORT).show();
                    }
                });
        queue.add(jsObjRequest);
        //(Request.Method.GET, urlget,  null, new Response.Listener<JSONObject>()
        //jsObjRequest

        //Toast.makeText(getApplicationContext(), jsObjRequest.toString().contains() , Toast.LENGTH_SHORT).show();
        //Toast.makeText(getApplicationContext(), jsObjRequest.toString().equals("1") ? "Esta dentro el cuadrante": "Esta fuera del cuadrante"  , Toast.LENGTH_SHORT).show();

        //Toast.makeText(getApplicationContext(),IIf (vData = "S", True, False) jsObjRequest.toString() , Toast.LENGTH_SHORT).show();
        //Toast.makeText(getApplicationContext(), Request.Method.GET, urlget,  null, new Response.Listener<JSONObject>() , Toast.LENGTH_SHORT).show();


        // Intent intent = new Intent(this,Agradecimiento.class);
        //startActivity(intent);
        String dentro = jsObjRequest.toString();

        dentro = dentro.charAt(dentro.length()-1)+"";

        if(dentro.equals("0"))
            dentro = "Fuera del cuadrante";
        else
            dentro = "Dentro del cuadrante";

        Intent intent = new Intent(this, mostrarP.class);
        intent.putExtra("placa", bus);
        intent.putExtra("dentro", dentro);
        //busqueda.getText().equals("7235550") ? "Esta dentro el cuadrante": "Esta fuera del cuadrante";

        Toast.makeText(getApplicationContext(), busqueda.getText().toString().contains("7235550") ? "Esta dentro el cuadrante": "Esta fuera del cuadrante", Toast.LENGTH_SHORT).show();
        //busqueda.setText(jsObjRequest.toString());
        /*
        intent.putExtra("lat", "ddd");
        intent.putExtra("lon", "ddd");
        */
        startActivity(intent);

    }


}