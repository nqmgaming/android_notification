package com.nqmgaming.androidnotification

import android.Manifest.permission.POST_NOTIFICATIONS
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat

fun simpleNotification(context: Context) {
    val notification = NotificationCompat.Builder(context, CHANNEL_DEFAULT_ID)
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setContentTitle("Simple Notification")
        .setContentText("This is a simple notification")
        .build()

    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
        if (ContextCompat.checkSelfPermission(
                context,
                POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            NotificationManagerCompat.from(context).notify(1, notification)
        }

    } else {
        NotificationManagerCompat.from(context).notify(1, notification)
    }
}