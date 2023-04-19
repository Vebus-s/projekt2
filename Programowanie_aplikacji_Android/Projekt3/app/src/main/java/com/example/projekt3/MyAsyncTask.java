package com.example.projekt3;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyAsyncTask extends AsyncTask<Void, Void, String[]> {

    private Context mContext;
    private String mUrl;
    private AsyncTaskListener mListener;

    public MyAsyncTask(Context context, String url, AsyncTaskListener listener) {
        mContext = context;
        mUrl = url;
        mListener = listener;
    }

    @Override
    protected String[] doInBackground(Void... voids) {
        String[] result = new String[2];
        try {
            // Nawiązanie połączenia z serwerem i odczyt informacji o pliku
            HttpURLConnection connection = (HttpURLConnection) new URL(mUrl).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            String contentType = connection.getContentType();
            long contentLength = connection.getContentLengthLong();
            connection.disconnect();

            // Przekazanie informacji o pliku do metody onPostExecute()
            result[0] = contentType;
            result[1] = String.valueOf(contentLength);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(String[] result) {
        if (result != null) {
            // Wyświetlenie informacji o pliku
            String contentType = result[0];
            long contentLength = Long.parseLong(result[1]);
            mListener.onTaskCompleted(contentType, contentLength);
        } else {
            Toast.makeText(mContext, "Błąd pobierania informacji", Toast.LENGTH_SHORT).show();
        }
    }
}

