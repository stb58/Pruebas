package com.example.apprandy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button btn_calcular;
    private EditText edit_precio;
    private EditText edit_gasolina;
    private EditText edit_km;
    private EditText edit_personas;
    private TextView text_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_calcular = findViewById(R.id.CALCULAR);
        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_resultado.setText(calculo(Double.parseDouble(edit_precio.getText().toString()),
                        Double.parseDouble(edit_gasolina.getText().toString()),
                        Double.parseDouble(edit_km.getText().toString()),
                        Double.parseDouble(edit_personas.getText().toString())) + "");
            }
        });
        edit_precio = findViewById(R.id.precio);
        edit_gasolina = findViewById(R.id.gasolina);
        edit_km = findViewById(R.id.km);
        edit_personas = findViewById(R.id.personas);
        text_resultado = findViewById(R.id.resultado);
    }

    public double calculo (double precio, double gasolina, double km, double personas){
        double litrosTotal = (gasolina * km)/100;
        double precioTotal = (litrosTotal * precio)/personas;
        return precioTotal;
    }
}