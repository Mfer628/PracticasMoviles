package com.example.sensoresandroid

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class SensorLuzACTIVITY : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private lateinit var lightSensor: Sensor
    private lateinit var lightValueTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor_luz)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

        // Obtener la referencia al TextView
        lightValueTextView = findViewById(R.id.lightValueTextView)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        val lightValue = event?.values?.get(0)
        lightValueTextView.text = "Valor del sensor de luz: $lightValue lux"

        if (lightValue != null && lightValue < 10) {
            // El sensor de luz está tapado, implementa tu lógica aquí
            showToast("Sensor de luz tapado")
        }

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
    override fun onResume() {
        super.onResume()
        // Registrar el Listener del sensor de luz
        sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        // Detener la lectura del sensor de luz cuando la actividad está en pausa
        sensorManager.unregisterListener(this)
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
