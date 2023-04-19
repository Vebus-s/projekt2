package com.example.projekt3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AsyncTaskListener {

    private Button info;
    private TextView link;
    private TextView sizeText;
    private TextView typeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info = findViewById(R.id.info);
        link = findViewById(R.id.link);
        sizeText = findViewById(R.id.size);
        typeText = findViewById(R.id.type);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Wywołanie zadania AsyncTask
                MyAsyncTask task = new MyAsyncTask(MainActivity.this, link.getText().toString(), MainActivity.this);
                task.execute();
            }
        });

    }
    @Override
    public void onTaskCompleted(String contentType, long contentLength) {
        // Tutaj możesz wykorzystać informacje o pliku
        //Toast.makeText(this, "Typ pliku: " + contentType + ", rozmiar: " + contentLength + " bajtów", Toast.LENGTH_LONG).show();
        typeText.setText(contentType);
        sizeText.setText(String.valueOf(contentLength));
    }

}