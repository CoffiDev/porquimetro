package com.example.alejandro.porquimetro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;


public class Articulo extends Activity {

    EditText ley,art;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulo);


    }
    public void mostrarArticulo(View v){

        ley = (EditText)findViewById(R.id.ley);
        art = (EditText)findViewById(R.id.articulo);

        String tley = ley.getText()+"";
        String tart = art.getText()+"";

        if(tley.equals("") || tart.equals("") ) {
            Toast.makeText(this,"Llena los campos :)",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent = new Intent(this, ArticuloMostrar.class);

            intent.putExtra("ley", tley);
            intent.putExtra("art", tart);

            startActivity(intent);
        }
    }
}
