package com.pedrodamian.gestorapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PaginaWeb extends AppCompatActivity {

    WebView wvpagina;
    WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pagina_web);

        wvpagina = findViewById(R.id.wvPagina);
        webSettings = wvpagina.getSettings();

        // una web usa el DOM y el Javascript
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        // carga la url dentro de la actividad
        wvpagina.loadUrl("https://platzi.com");
        // atrapa y lo contiene dentro de la actividad
        wvpagina.setWebViewClient(new WebViewClient());

    }

    // metodo para interactuar con la pagina sin que regrese al login
    @SuppressLint("GestureBackNavigation")
    @Override
    public void onBackPressed() {
        if(wvpagina.canGoBack()){
            wvpagina.goBack();
        } else {
            super.onBackPressed();
        }
    }
}