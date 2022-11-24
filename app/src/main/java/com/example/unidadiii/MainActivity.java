package com.example.unidadiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnCamara;
    private Button btnLectorQR;
    private Button btnGeneradorQR;
    private Button btnGPS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCamara = findViewById(R.id.btn_camara);
        btnLectorQR = findViewById(R.id.btn_lectorQR);
        btnGeneradorQR = findViewById(R.id.btn_generadorQR);
        btnGPS = findViewById(R.id.btn_hubicacion);

        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(),Camara.class));
            }
        });

        btnLectorQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(),LectorQR.class));
            }
        });


        btnGeneradorQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(),GeneradorQR.class));
            }
        });

        btnGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(),GPS.class));
            }
        });


    }
}