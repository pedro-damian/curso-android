package com.pedrodamian.gestorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Paso 1: declaro mi control con el tipo de elemento
        Button btnweb;
        Button btningresar;
        TextView tvRegistrate;


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        // Paso 2: ASOCIAR mi variable creada con el control de activity_main
        btnweb = findViewById(R.id.btnWeb);
        btningresar = findViewById(R.id.btnIngresar);
        tvRegistrate = findViewById(R.id.tvRegistrate);


        // Paso 3: Indicar a la variable que es lo que vas hacer
        btnweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast es el mensajito tipo globito
                // Toast.makeText(MainActivity.this, "Soy el boton", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, PaginaWeb.class));
            }
        });

        btningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast es el mensajito tipo globito
                Toast.makeText(MainActivity.this, "Ingresate", Toast.LENGTH_SHORT).show();
            }
        });

        tvRegistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Registro.class));
            }
        });

    }
}