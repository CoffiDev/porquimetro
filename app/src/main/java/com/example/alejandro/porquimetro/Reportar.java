package com.example.alejandro.porquimetro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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

public class Reportar extends ActionBarActivity {

    String url = "http://porkimetro.wc.lt/repo.php?";
    private TextView num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportar);


    }

    public void reportar(View v)
    {
        TextView placa = (TextView) findViewById(R.id.placa);
        TextView porki = (TextView) findViewById(R.id.porki);
        //TextView mordida = (TextView) findViewById(R.id.mordida);

        String urlget= url+ "placa=" + placa.getText() + "&por=" + porki.getText() + "&precio=" + "3434";
        //Toast.makeText(getApplicationContext(), urlget, Toast.LENGTH_SHORT).show();
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, urlget,  null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // num.setText("Numero: " + response.getString("placa"));
                            response.getString("placa");

                        } catch (JSONException e) {
                            e.printStackTrace();

                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                        // TODO Auto-generated method stub
                        //Toast.makeText(getApplicationContext(), "Registrado", Toast.LENGTH_SHORT).show();
                    }
                });
        queue.add(jsObjRequest);


        Intent intent = new Intent(this,Agradecimiento.class);
        startActivity(intent);
    }
}