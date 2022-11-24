package com.example.unidadiii;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.google.zxing.qrcode.QRCodeWriter;
import com.journeyapps.barcodescanner.CaptureActivity;

public class LectorQR extends CaptureActivity {

    private Button btnLeerQR;
    private TextView textoQR;
    private ImageView imagenLectorQR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lector_q_r);

        btnLeerQR = findViewById(R.id.btn_leerQR);
        textoQR = findViewById(R.id.tv_textoQR);
        imagenLectorQR = findViewById(R.id.imagen_lectorQR);

        IntentIntegrator integrator = new IntentIntegrator(this);

        btnLeerQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new IntentIntegrator(getActivity()).initiateScan();

                integrator.setOrientationLocked(false);
                integrator.setPrompt("Scan QR code");
                integrator.setBeepEnabled(false);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.initiateScan();
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        String datos = result.getContents();

        try{
            com.google.zxing.Writer writer = new QRCodeWriter();
            // String finaldata = Uri.encode(data, "utf-8");
            int width = 1024;
            int height = 1024;
            BitMatrix bm = writer
                    .encode(datos.toString(), BarcodeFormat.QR_CODE, width, height);
            Bitmap ImageBitmap = Bitmap.createBitmap(width, height,
                    Bitmap.Config.ARGB_8888);

            for (int i = 0; i < width; i++) {// width
                for (int j = 0; j < height; j++) {// height
                    ImageBitmap.setPixel(i, j, bm.get(i, j) ? Color.BLACK
                            : Color.WHITE);
                }
            }

            imagenLectorQR.setImageBitmap(ImageBitmap);
            textoQR.setText(datos.toString());

        }
        catch (Exception ex){

        }

    }
}