package com.nqmgaming.androidnotification

import android.Manifest.permission.POST_NOTIFICATIONS
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat

fun urgentNotification(context: Context) {
    val notification = NotificationCompat.Builder(context, CHANNEL_URGENT_ID)
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setContentTitle("Urgent Notification")
        .setContentText("This is a urgent notification")
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
        .setVibrate(longArrayOf(0, 1000, 1000, 1000, 1000))
        .build()

    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
        if (ContextCompat.checkSelfPermission(
                context,
                POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            NotificationManagerCompat.from(context).notify(3, notification)
        }

    } else {
        NotificationManagerCompat.from(context).notify(3, notification)
    }
}