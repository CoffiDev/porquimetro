package com.example.alejandro.porquimetro;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Agradecimiento extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agradecimiento);
    }

    public void inicio(View v)
    {
        Intent intent = new Intent(this,Index.class);
        startActivity(intent);
    }
}
