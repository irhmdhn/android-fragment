package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ImplicitActivity extends AppCompatActivity {
    Button btnDialpad, btnContact, btnCamera, btnGalery, btnBrowser;
    EditText etTelp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);

        btnDialpad = findViewById(R.id.btnDialpad);
        btnContact = findViewById(R.id.btnContact);
        btnCamera = findViewById(R.id.btnCamera);
        btnGalery = findViewById(R.id.btnGalery);
        btnBrowser = findViewById(R.id.btnBrowser);
        etTelp = findViewById(R.id.etTelp);

        btnDialpad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etTelp.getText().toString().isEmpty()){
                    Intent i = new Intent();
                    i.setAction(Intent.ACTION_DIAL);
                    startActivity(i);
                }
                else{
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+etTelp.getText()));
                    startActivity(intent);
                }
            }
        });

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("content://contacts/people/"));
                startActivity(intent);
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
                startActivity(intent);
            }
        });

        btnGalery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("content://media/external/images/media/"));
                startActivity(intent);
            }
        });

        btnBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("https://amikom.ac.id/"));
                startActivity(intent.createChooser(intent,"title"));
            }
        });
    }
}