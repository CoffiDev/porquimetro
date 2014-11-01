package com.example.alejandro.porquimetro;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.content.Intent;
import android.view.View;


public class MyFirstActivity extends ActionBarActivity {
    public Button button;

    public EditText placa;
    public EditText infraccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_first);

        placa = (EditText)findViewById(R.id.textDigitaPlaca);
        infraccion = (EditText)findViewById(R.id.textInfraccion);



        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view){

                Toast.makeText(MyFirstActivity.this, "Hemos registrado al puerco", Toast.LENGTH_LONG).show();
                Intent intentopuerco = new Intent(MyFirstActivity.this,MyReportado.class);
            }
        });



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_first, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
