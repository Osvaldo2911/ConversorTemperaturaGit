package com.actividad.conversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private EditText etTemperaturaEntrada, etTemperaturaSalida;
    private Spinner spOpcionTemEntrada, spOpcionTemSalida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTemperaturaEntrada = findViewById(R.id.etTemperaturaEntrada);
        etTemperaturaSalida = findViewById(R.id.etTemperaturaSalida);

        spOpcionTemEntrada = (Spinner) findViewById(R.id.spOpcionTemEntrada);
        spOpcionTemSalida = (Spinner)findViewById(R.id.spOpcionTemSalida);

        ArrayAdapter<CharSequence>adapter;
        adapter = ArrayAdapter.createFromResource(this, R.array.TemEn,android.R.layout.simple_spinner_item);
        spOpcionTemEntrada.setAdapter(adapter);


        adapter = ArrayAdapter.createFromResource(this, R.array.TemEn,android.R.layout.simple_spinner_item);
        spOpcionTemSalida.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String text = parent.getItemAtPosition(position).toString();
        if(text.equals("Centigrados")){

            if(spOpcionTemEntrada.getSelectedItem().equals("Centigrados")){
                etTemperaturaSalida.setText(etTemperaturaEntrada.getText().toString());
            }
            if(spOpcionTemEntrada.getSelectedItem().equals("Fahrenheit")){
                double  cen = ( Double.parseDouble(etTemperaturaEntrada.getText().toString())-32)*(5/9);
                etTemperaturaSalida.setText(cen+"");
            }
            if(spOpcionTemEntrada.getSelectedItem().equals("Kelvin")){
                double  cen = (Double.parseDouble(etTemperaturaEntrada.getText().toString())-273.15);
                etTemperaturaSalida.setText(cen+"");
            }
            if(spOpcionTemEntrada.getSelectedItem().equals("Rankine")){
                double cen = (Double.parseDouble(etTemperaturaEntrada.getText().toString())-491.67) * (5/9);
                etTemperaturaSalida.setText(cen+"");
            }

        }
        else if(text.equals("Fahrenheit")){

            if(spOpcionTemEntrada.getSelectedItem().equals("Centigrados")){
                double fa = (Double.parseDouble(etTemperaturaEntrada.getText().toString())*(9/5)+32);
                etTemperaturaSalida.setText(fa+"");
            }
            if(spOpcionTemEntrada.getSelectedItem().equals("Fahrenheit")){
                etTemperaturaSalida.setText(etTemperaturaEntrada.getText().toString());
            }
            if(spOpcionTemEntrada.getSelectedItem().equals("Kelvin")){
                double  fa = (Double.parseDouble(etTemperaturaEntrada.getText().toString())-273.15) * (9/5) + 32;
                etTemperaturaSalida.setText(fa+"");
            }
            if(spOpcionTemEntrada.getSelectedItem().equals("Rankine")){
                double fa = (Double.parseDouble(etTemperaturaEntrada.getText().toString())- 459.67);
                etTemperaturaSalida.setText(fa+"");
            }

        }
        else if(text.equals("Kelvin")){

            if(spOpcionTemEntrada.getSelectedItem().equals("Centigrados")){
                double ke = (Double.parseDouble(etTemperaturaEntrada.getText().toString())+ 273.15);
                etTemperaturaSalida.setText(ke+"");
            }
            if(spOpcionTemEntrada.getSelectedItem().equals("Fahrenheit")){
                double  ke = (Double.parseDouble(etTemperaturaEntrada.getText().toString())-32) * (5/9) + 273.15;
                etTemperaturaSalida.setText(ke+"");
            }
            if(spOpcionTemEntrada.getSelectedItem().equals("Kelvin")){
                etTemperaturaSalida.setText(etTemperaturaEntrada.getText().toString());
            }
            if(spOpcionTemEntrada.getSelectedItem().equals("Rankine")){
                double fa = (Double.parseDouble(etTemperaturaEntrada.getText().toString())*(5/9));
                etTemperaturaSalida.setText(fa+"");
            }
        }
        else if(text.equals("Rankine")){

            if(spOpcionTemEntrada.getSelectedItem().equals("Centigrados")){
                double ke = (Double.parseDouble(etTemperaturaEntrada.getText().toString())* (9/5) + 491.67);
                etTemperaturaSalida.setText(ke+"");
            }
            if(spOpcionTemEntrada.getSelectedItem().equals("Fahrenheit")){
                double  ke = (Double.parseDouble(etTemperaturaEntrada.getText().toString())+ 459.67);
                etTemperaturaSalida.setText(ke+"");
            }
            if(spOpcionTemEntrada.getSelectedItem().equals("Kelvin")){
                double fa = (Double.parseDouble(etTemperaturaEntrada.getText().toString())*(1.8));
                etTemperaturaSalida.setText(fa+"");
            }
            if(spOpcionTemEntrada.getSelectedItem().equals("Rankine")){
                etTemperaturaSalida.setText(etTemperaturaEntrada.getText().toString());
            }
        }




    }
}
