package com.example.alejandro.porquimetro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Articulo extends Activity {

    EditText ley,art;

    private Spinner spinner1;
    private Button btnSubmit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulo);

        spinner1 = (Spinner) findViewById(R.id.reglamentos);
        List<String> list = new ArrayList<String>();
        list.add("Transito");
        list.add("Civil");
        list.add("Penal");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,list);

        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(dataAdapter);

        // Spinner item selection Listener
        addListenerOnSpinnerItemSelection();

        // Button click Listener
        //addListenerOnButton();


    }
    public void mostrarArticulo(View v){

        //ley = (EditText)findViewById(R.id.ley);
        art = (EditText)findViewById(R.id.articulo);

        //String tley = ley.getText()+"";
        String tart = art.getText()+"";
        String tley = String.valueOf(spinner1.getSelectedItem());


        if(tley.equals("") ) {
            Toast.makeText(this,"Llena los campos :)",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent = new Intent(this, ArticuloMostrar.class);


            if(String.valueOf(spinner1.getSelectedItem()).equals("Transito"))
                tley = "1";
            else if(String.valueOf(spinner1.getSelectedItem()).equals("Civil"))
                    tley = "2";
                else
                    tley = "3";

            intent.putExtra("ley", tley);
            intent.putExtra("art", tart);

            startActivity(intent);
        }
    }

    public void addListenerOnSpinnerItemSelection(){

        spinner1.setOnItemSelectedListener(new Combo());
    }

    //get the selected dropdown list value



}
