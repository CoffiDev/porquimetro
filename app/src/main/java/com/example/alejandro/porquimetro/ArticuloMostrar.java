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

import org.json.JSONException;
import org.json.JSONObject;


public class ArticuloMostrar extends Activity {

    String url = "http://porkimetro.wc.lt/cons.php?ley=1&art=1";
    private TextView num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulo_mostrar);
        num = (TextView) findViewById(R.id.texto);
        num.setText("Hola ");

        Toast.makeText(this,"Hola",Toast.LENGTH_SHORT).show();

          RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                            Toast.makeText(getApplicationContext(),"Hola2",Toast.LENGTH_SHORT).show();
                        num.setText("baakaa");
                        try {
                            num.setText("Numero: " + response.getString("numero")+"sgshsd");
                            Log.e("response",""+response.toString());
                            Toast.makeText(ArticuloMostrar.this,"It works",Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            num.setText("yolo");
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        num.setText("juuum");
                        // TODO Auto-generated method stub
                                    Toast.makeText(getApplicationContext(),"Hola3",Toast.LENGTH_SHORT).show();
                    }
                });
         queue.add(jsObjRequest);

    }

    public void inicio(View v) {
        Intent intent = new Intent(this, Index.class);
        startActivity(intent);
    }
}
