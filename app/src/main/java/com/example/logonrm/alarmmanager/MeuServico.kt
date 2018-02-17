package com.example.logonrm.alarmmanager

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log


class MeuServico : Service() {
    lateinit var mp : MediaPlayer

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent?.extras != null)
            Log.i("MEUSERVICO", intent?.getStringExtra("parametro1"))

        mp = MediaPlayer.create(this, R.raw.alarm_clock)
        mp.start()


        //return START_STICKY -- em caso de morte, VOLTA A FAZER SEM OS PARAMETROS
        //return START_NOT_STICKY -- não retorna em caso de morte
        return START_REDELIVER_INTENT //em caso de morte volta a fazer com os parametros

    }

   override fun onBind(intent: Intent?): IBinder ?{
    return  null
   }
}