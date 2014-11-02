package com.example.alejandro.porquimetro;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;


public class ArticuloMostrar extends Activity {



    private TextView    num,
                        texto,
                        falta,
                        multa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String ley = getIntent().getStringExtra("ley");
        String art = getIntent().getStringExtra("art");

        String url = "http://porkimetro.wc.lt/cons.php?ley="+ley+"&art="+art;

        setContentView(R.layout.activity_articulo_mostrar);

        num = (TextView) findViewById(R.id.no);
        texto = (TextView) findViewById(R.id.texto);
        falta = (TextView) findViewById(R.id.falta);
        multa = (TextView) findViewById(R.id.multa);

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            num.setText("Numero: " + response.getString("numero"));

                            texto.setText("Texto:\n " + response.getString("texto"));
                            falta.setText("Falta cometida: " + response.getString("tipo"));
                            multa.setText("Multa:$ " + response.getString("multa"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error)
                    {

                    }
                });
         queue.add(jsObjRequest);

    }

    public void inicio(View v) {
        Intent intent = new Intent(this, Index.class);
        startActivity(intent);
    }
}
