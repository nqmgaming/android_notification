package com.nqmgaming.androidnotification

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

const val CHANNEL_DEFAULT_ID = "default_id"
const val CHANNEL_DEFAULT_NAME = "default_name"

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_DEFAULT_ID,
                CHANNEL_DEFAULT_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }
}