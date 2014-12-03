package com.example.alejandro.porquimetro;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.Touch;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class mostrarP extends ActionBarActivity {

    TextView placa, porkimetro, nombre, cuadrante, reportes, dentro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_p);

        String tplaca = getIntent().getStringExtra("placa");
        String tdentro = getIntent().getStringExtra("dentro");

        placa = (TextView)findViewById(R.id.placa);
        porkimetro = (TextView)findViewById(R.id.porkimetro);
        nombre = (TextView)findViewById(R.id.nombre);
        cuadrante = (TextView)findViewById(R.id.cuadrante);
        reportes = (TextView)findViewById(R.id.reportes);
        dentro = (TextView)findViewById(R.id.dentro);

        placa.setText("Placa del oficial: "+tplaca);
        dentro.setText(tdentro);

        String url = "http://porkimetro.wc.lt/info.php?placa="+tplaca;
        Boolean find=false;

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            nombre.setText("Nombre del Policia: " + response.getString("nombre"));
                            porkimetro.setText("Porkinivel : " + response.getString("porqui"));
                            reportes.setText("No. de Reportes: " + response.getString("reportes"));
                            cuadrante.setText("Nombre del Sector:\n"+response.getString("cuadrante"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        nombre.setText("Policia no encontrado");
                        Toast.makeText(getApplicationContext(),"Policia no encontrado",Toast.LENGTH_SHORT).show();
                    }
                });
        queue.add(jsObjRequest);




    }

    public void goReportar(View v)
    {
        Intent intent = new Intent(this,Reportar.class);
        startActivity(intent);
    }

    public void goArticulo(View v)
    {
        Intent intent = new Intent(this,Articulo.class);
        startActivity(intent);
    }

}
