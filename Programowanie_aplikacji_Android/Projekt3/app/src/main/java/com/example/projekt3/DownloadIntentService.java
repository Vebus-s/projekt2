package com.example.projekt3;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.Nullable;

public class DownloadIntentService extends IntentService {
    private static final String AKCJA_ZADANIE1 = "com.example.intent_service.action.zadanie1";
    private static final String PARAMETR1 = "com.example.intent_service.extra.parametr1";
    private static final int ID_POWIADOMIENIA = 1;
    private NotificationManager mManagerPowiadomien;

    public static void uruchomUsluge(Context context, int parametr){
        Intent zamiar = new Intent(context, DownloadIntentService.class);
        zamiar.setAction(AKCJA_ZADANIE1);
        zamiar.putExtra(PARAMETR1, parametr);
        context.startService(zamiar);
    }

    public DownloadIntentService(){
        super("DownloadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        mManagerPowiadomien = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //przygotujKanalPowiadomien();
        //startForeground(ID_POWIADOMIENIA, utworzPowiadomienie());

        if(intent != null){

        }
    }
}
