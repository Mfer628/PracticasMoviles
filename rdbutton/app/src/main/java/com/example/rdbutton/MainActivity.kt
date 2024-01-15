
package com.example.rdbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnAceptar: Button
        btnAceptar = findViewById(R.id.btnAceptar)

        btnAceptar.setOnClickListener {
                creacion()
        }

    }
    fun creacion(){
        val radioG:RadioGroup
        radioG=findViewById(R.id.RadioGroup)
        radioG.clearCheck()
        radioG.removeAllViews()
        val textos = arrayOf("radio1", "radio2", "radio3", "radio 4 ")

        textos.forEach {
            val rbtn = RadioButton(this)
            rbtn.id = View.generateViewId()
            rbtn.text=it
            radioG.addView(rbtn)
        }

    }
}