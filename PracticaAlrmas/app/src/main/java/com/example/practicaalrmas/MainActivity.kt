package com.example.practicaalrmas

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.example.practicaalrmas.databinding.ActivityMainBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.util.*
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var picker: MaterialTimePicker
    private lateinit var calendar: Calendar
    private lateinit var alarmManager: AlarmManager
    private lateinit var pendingIntent: PendingIntent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.selectTime.setOnClickListener {
            showTimePicker()
        }

        binding.setAlarm.setOnClickListener {
            setAlarm()
        }

        binding.cancelAlarm.setOnClickListener {
            cancelAlarm()
        }

        createNotificationChannel()
    }

    private fun cancelAlarm() {
        if (::alarmManager.isInitialized && ::pendingIntent.isInitialized) {
            alarmManager.cancel(pendingIntent)
            Toast.makeText(this, "Alarma cancelada", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "No hay alarma para cancelar", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setAlarm() {
        if (!::picker.isInitialized) {
            Toast.makeText(this, "Selecciona una hora primero", Toast.LENGTH_SHORT).show()
            return
        }

        if (!::calendar.isInitialized) {
            calendar = Calendar.getInstance()
            calendar[Calendar.HOUR_OF_DAY] = picker.hour
            calendar[Calendar.MINUTE] = picker.minute
            calendar[Calendar.SECOND] = 0
            calendar[Calendar.MILLISECOND] = 0
        }

        val intent = Intent(this, AlarmReceiver::class.java)
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP, calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY, pendingIntent
        )

        Toast.makeText(this, "Alarma configurada con éxito", Toast.LENGTH_SHORT).show()
    }

    private fun showTimePicker() {
        picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Selecciona Alarma")
            .build()

        picker.addOnPositiveButtonClickListener {
            val selectedHour = if (picker.hour > 12) picker.hour - 12 else picker.hour
            val amPm = if (picker.hour >= 12) "PM" else "AM"

            val formattedTime = String.format("%02d:%02d%s", selectedHour, picker.minute, amPm)
            binding.selectedTime.text = formattedTime
        }

        picker.show(supportFragmentManager, "fox android")
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "foxandroidReminderChannel"
            val description = "Channel For Alarm Manager"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("foxandroid", name, importance)
            channel.description = description
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }
}
