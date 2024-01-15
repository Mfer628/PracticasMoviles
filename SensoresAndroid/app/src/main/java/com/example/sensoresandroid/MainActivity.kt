package com.example.sensoresandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnSensorAce: Button
    private lateinit var btnSensorLuz:Button
    private lateinit var btnASensorHuella:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSensorAce = findViewById(R.id.btnSensor1)
        btnSensorLuz = findViewById(R.id.btnSensor2)
        btnASensorHuella = findViewById(R.id.btnSensor3)
        btnSensorAce.setOnClickListener{
            siguientebtnR()
        }
        btnSensorLuz.setOnClickListener{
            siguientebtnLuz()
        }
        btnASensorHuella.setOnClickListener{
            siguientebtnHuella()
        }

    }


    fun siguientebtnR() {
        val intent = Intent(this, AcelerometroActivity :: class.java)
        startActivity(intent);

    }
    fun siguientebtnLuz() {
        val intent = Intent(this, SensorLuzACTIVITY :: class.java)
        startActivity(intent);

    }
    fun siguientebtnHuella() {
        val intent = Intent(this, SensorHuella :: class.java)
        startActivity(intent);

    }

}