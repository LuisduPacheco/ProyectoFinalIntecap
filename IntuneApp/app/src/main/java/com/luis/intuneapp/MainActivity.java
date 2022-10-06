package com.luis.intuneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonVerProductos, buttonComprar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonVerProductos = findViewById(R.id.btnVerProductosMenu);
        buttonComprar = findViewById(R.id.btnComprarProductosMenu);

        clickVerProductos();
    }

    private void clickVerProductos() {
        buttonVerProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirVerProductos();
            }
        });
    }

    private void abrirVerProductos(){
        Intent intent =new Intent(getApplicationContext(), MAVerProductos.class);
        startActivity(intent);
    }


}