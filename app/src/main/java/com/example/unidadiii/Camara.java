package com.example.unidadiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Camara extends AppCompatActivity {

    private Button btnCamara;


    private static final int pic_id = 123;
    ImageView click_image_id;

    Bitmap photo;
    boolean photoTook = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);

        btnCamara = findViewById(R.id.btn_tomar_foto);

        click_image_id = findViewById(R.id.imagen_camara);


        btnCamara.setOnClickListener(v -> {

            Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            startActivityForResult(camera_intent, pic_id);
        });
    }



    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == pic_id) {

            photo = (Bitmap) data.getExtras().get("data");


            click_image_id.setImageBitmap(photo);
        }
    }
}