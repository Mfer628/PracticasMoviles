package com.example.linear_layout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ActivityConstraint : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint)
    }
    fun ejecutar(v: View){
        when (v.getId()){
            R.id.button3 -> {
                val intent = Intent(this, ActivityGrid :: class.java)
                startActivity(intent)
            }

        }

    }
}