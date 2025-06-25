package com.pedrodamian.gestorapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // esta funcion permite redireccionar de una actividad a otra en este caso de Splashscreen a Mainactivity
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }
            // delaymillis es el tiempo para que ejecute la funcion run()
        }, 4000);


    }
}