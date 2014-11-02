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
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;


public class ArticuloMostrar extends Activity {

    String url = "http://porkimetro.wc.lt/info.php?art=1&ley=1";
    private TextView num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_articulo_mostrar);
        num = (TextView) findViewById(R.id.texto);

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            num.setText("Numero: " + response.getString("numero")+"sgshsd");
                            Log.e("response",""+response.toString());
                            Toast.makeText(ArticuloMostrar.this,"It works",Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });

        super.onCreate(savedInstanceState);
    }

    public void inicio(View v) {
        Intent intent = new Intent(this, Index.class);
        startActivity(intent);
    }
}
