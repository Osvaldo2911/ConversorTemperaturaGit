package com.actividad.conversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText etTemperaturaEntrada, etTemperaturaSalida;
    private Spinner spOpcionTemEntrada, spOpcionTemSalida;
    private ArrayAdapter adapter;
    private String Tem[]= {"Centigrados","Fahrenheit","Kelvin","Rankine"};
    private double c,f,k,r,res;
    private String p1,p2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spOpcionTemEntrada = (Spinner) findViewById(R.id.spOpcionTemEntrada);
        spOpcionTemSalida = (Spinner)findViewById(R.id.spOpcionTemSalida);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Tem);
        spOpcionTemEntrada.setAdapter(adapter);
        spOpcionTemSalida.setAdapter(adapter);

        etTemperaturaEntrada = findViewById(R.id.etTemperaturaEntrada);
        etTemperaturaSalida = findViewById(R.id.etTemperaturaSalida);

        spOpcionTemEntrada.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                p1=Tem[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spOpcionTemSalida.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                p2 = Tem[position];


                if(p2.equals("Centigrados")){

                    if(p1.equals("Centigrados")){
                        etTemperaturaSalida.setText(etTemperaturaEntrada.getText().toString());
                    }
                    else if(p1.equals("Fahrenheit")){
                        double  cen = ( Double.parseDouble(etTemperaturaEntrada.getText().toString())-32)*(5/9);
                        etTemperaturaSalida.setText(cen+"");
                    }
                    else if(p1.equals("Kelvin")){
                        double  cen = (Double.parseDouble(etTemperaturaEntrada.getText().toString())-273.15);
                        etTemperaturaSalida.setText(cen+"");
                    }
                    else if(p1.equals("Rankine")){
                        double cen = (Double.parseDouble(etTemperaturaEntrada.getText().toString())-491.67) * (5/9);
                        etTemperaturaSalida.setText(cen+"");
                    }

                }
                else if(p2.equals("Fahrenheit")){

                    if(p1.equals("Centigrados")){
                        double fa = (Double.parseDouble(etTemperaturaEntrada.getText().toString())*(9/5)+32);
                        etTemperaturaSalida.setText(fa+"");
                    }
                    else if(p1.equals("Fahrenheit")){
                        etTemperaturaSalida.setText(etTemperaturaEntrada.getText().toString());
                    }
                    else if(p1.equals("Kelvin")){
                        double  fa = (Double.parseDouble(etTemperaturaEntrada.getText().toString())-273.15) * (9/5) + 32;
                        etTemperaturaSalida.setText(fa+"");
                    }
                    else if(p1.equals("Rankine")){
                        double fa = (Double.parseDouble(etTemperaturaEntrada.getText().toString())- 459.67);
                        etTemperaturaSalida.setText(fa+"");
                    }

                }
                else if(p2.equals("Kelvin")){

                    if(p1.equals("Centigrados")){
                        double ke = (Double.parseDouble(etTemperaturaEntrada.getText().toString())+ 273.15);
                        etTemperaturaSalida.setText(ke+"");
                    }
                    if(p1.equals("Fahrenheit")){
                        double  ke = (Double.parseDouble(etTemperaturaEntrada.getText().toString())-32) * (5/9) + 273.15;
                        etTemperaturaSalida.setText(ke+"");
                    }
                    if(p1.equals("Kelvin")){
                        etTemperaturaSalida.setText(etTemperaturaEntrada.getText().toString());
                    }
                    if(p1.equals("Rankine")){
                        double ke = (Double.parseDouble(etTemperaturaEntrada.getText().toString())*(5/9));
                        etTemperaturaSalida.setText(ke+"");
                    }
                }
                else if(p2.equals("Rankine")){

                    if(p1.equals("Centigrados")){
                        double ra = (Double.parseDouble(etTemperaturaEntrada.getText().toString())* (9/5) + 491.67);
                        etTemperaturaSalida.setText(ra+"");
                    }
                    if(p1.equals("Fahrenheit")){
                        double  ra = (Double.parseDouble(etTemperaturaEntrada.getText().toString())+ 459.67);
                        etTemperaturaSalida.setText(ra+"");
                    }
                    if(p1.equals("Kelvin")){
                        double ra = (Double.parseDouble(etTemperaturaEntrada.getText().toString())*(1.8));
                        etTemperaturaSalida.setText(ra+"");
                    }
                    if(p1.equals("Rankine")){
                        etTemperaturaSalida.setText(etTemperaturaEntrada.getText().toString());
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}

