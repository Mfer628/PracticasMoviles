package com.example.sensoresandroid

import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate

class AcelerometroActivity : AppCompatActivity(), SensorEventListener {
   private lateinit var sensorManager: SensorManager
   private lateinit var square : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acelerometro)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        square = findViewById(R.id.tv_square)
        setUpSensorsStuff()
    }

    private fun setUpSensorsStuff() {
      sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)?.also {
            sensorManager.registerListener(this ,
                it,
                SensorManager.SENSOR_DELAY_FASTEST,
                SensorManager.SENSOR_DELAY_FASTEST)
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
       if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER){
           val sides = event.values[0]
           val upDown = event.values[1]

           square.apply {
               rotationX =  upDown * 3F
               rotationY = sides * 3f
               rotation = -sides
               translationX = sides * -10
               translationX = upDown * 10
           }
           val color =
               if (upDown.toInt() == 0 && sides.toInt()==0) Color.GREEN else Color.RED
       square.setBackgroundColor(color)
           square.text = "up/down ${upDown.toInt()}\nleft/right ${sides.toInt()}"
       }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        return
    }

    override fun onDestroy() {
        sensorManager.unregisterListener(this)
        super.onDestroy()
    }
}