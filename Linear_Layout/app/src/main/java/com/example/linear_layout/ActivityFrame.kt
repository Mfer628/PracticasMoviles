package com.example.linear_layout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ActivityFrame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame)
    }
    fun calculadora(v: View) {
        when (v.getId()) {
            R.id.btncalculadora -> {
                val intent = Intent(this, Practica::class.java)
                startActivity(intent)
            }
        }
    }
}