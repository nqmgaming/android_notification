package com.nqmgaming.androidnotification

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

const val CHANNEL_DEFAULT_ID = "default_id"
const val CHANNEL_DEFAULT_NAME = "default_name"

const val CHANNEL_SILENT_ID = "silent_id"
const val CHANNEL_SILENT_NAME = "silent_name"

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_DEFAULT_ID,
                CHANNEL_DEFAULT_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val silentChannel = NotificationChannel(
                CHANNEL_SILENT_ID,
                CHANNEL_SILENT_NAME,
                NotificationManager.IMPORTANCE_LOW
            )
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
            notificationManager.createNotificationChannel(silentChannel)
        }
    }
}