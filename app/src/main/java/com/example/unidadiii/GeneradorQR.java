package com.example.unidadiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class GeneradorQR extends AppCompatActivity {

    private EditText etText;
    private Button btnGenerarQR;
    private ImageView imagenLectorQR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generador_q_r);

        etText = findViewById(R.id.et_texto);
        btnGenerarQR = findViewById(R.id.btn_generarQR);
        imagenLectorQR = findViewById(R.id.imagen_generadorQR);

        btnGenerarQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    com.google.zxing.Writer writer = new QRCodeWriter();
                    // String finaldata = Uri.encode(data, "utf-8");
                    int width = 1024;
                    int height = 1024;
                    BitMatrix bm = writer
                            .encode(etText.getText().toString(), BarcodeFormat.QR_CODE, width, height);
                    Bitmap ImageBitmap = Bitmap.createBitmap(width, height,
                            Bitmap.Config.ARGB_8888);

                    for (int i = 0; i < width; i++) {// width
                        for (int j = 0; j < height; j++) {// height
                            ImageBitmap.setPixel(i, j, bm.get(i, j) ? Color.BLACK
                                    : Color.WHITE);
                        }
                    }

                    imagenLectorQR.setImageBitmap(ImageBitmap);

                }
                catch (Exception ex){

                }
            }
        });

    }
}