package com.example.practicaalrmas
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        // Crear un intent para abrir la actividad de destino cuando se toque la notificación
        val destinationIntent = Intent(context, DestinationActiviti ::class.java)
        destinationIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        // Crear un PendingIntent con la bandera FLAG_IMMUTABLE
        val pendingIntent = PendingIntent.getActivity(
            context, 0, destinationIntent, PendingIntent.FLAG_IMMUTABLE
        )

        // Crear un canal de notificación si se ejecuta en Android 8.0 (Oreo) o superior
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "foxandroid",
                "Canal de Alarma",
                NotificationManager.IMPORTANCE_HIGH
            )

            val notificationManager = context?.getSystemService(NotificationManager::class.java)
            notificationManager?.createNotificationChannel(channel)
        }

        // Crear y mostrar la notificación
        val builder = NotificationCompat.Builder(context!!, "foxandroid")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("Alarma")
            .setContentText("Hora de levantarse")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        val notificationManager = NotificationManagerCompat.from(context!!)
        notificationManager.notify(123, builder.build())
    }
}
