package com.example.linear_layout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.CollapsibleActionView
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun send(v: View){
        when (v.getId()){
            R.id.activity_main_send -> {
                val intent = Intent(this, ActivityConstraint :: class.java)
                startActivity(intent)
            }

        }

    }
}