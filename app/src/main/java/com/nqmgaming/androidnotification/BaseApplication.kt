package com.nqmgaming.androidnotification

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

const val CHANNEL_DEFAULT_ID = "default_id"
const val CHANNEL_DEFAULT_NAME = "default_name"

const val CHANNEL_SILENT_ID = "silent_id"
const val CHANNEL_SILENT_NAME = "silent_name"

const val CHANNEL_URGENT_ID = "urgent_id"
const val CHANNEL_URGENT_NAME = "urgent_name"

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
            val urgentChannel = NotificationChannel(
                CHANNEL_URGENT_ID,
                CHANNEL_URGENT_NAME,
                NotificationManager.IMPORTANCE_HIGH
            )
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
            notificationManager.createNotificationChannel(silentChannel)
            notificationManager.createNotificationChannel(urgentChannel)
        }
    }
}