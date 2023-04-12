package com.example.projekt2;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> activityLauncher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        Button WebButton = findViewById(R.id.web);
        Button CancelButton = findViewById(R.id.cancel);
        Button SaveButton = findViewById(R.id.save);
        EditText ManufacturerText = findViewById(R.id.manufacturer);
        EditText WebText = findViewById(R.id.webText);
        EditText ModelText = findViewById(R.id.model);
        EditText AndroidVersion = findViewById(R.id.version);

        WebButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browser = new Intent("android.intent.action.VIEW", Uri.parse(WebText.getText().toString()));
                startActivity(browser);
            }
        });

        CancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InsertActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("Manufacturer", ManufacturerText.getText().toString());
                intent.putExtra("Model", ModelText.getText().toString());
                intent.putExtra("Android version", AndroidVersion.getText().toString());
                intent.putExtra("Web site", WebText.getText().toString());
                setResult(78, intent);
                InsertActivity.super.onBackPressed();
            }
        });

    }
}