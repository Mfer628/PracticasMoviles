package com.example.elementosvisualestarea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class Elemento_sner : AppCompatActivity() {
    val lenguajes= arrayOf(" ","English", "Spanish", "French")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elemento_sner)
        val txtResult: TextView
        txtResult=findViewById(R.id.txtRespuestas)
       val spinner: Spinner
       spinner= findViewById(R.id.spinner_Respuestas)
        val array_Adapter= ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,lenguajes)
        spinner.adapter=array_Adapter
        spinner.onItemSelectedListener= object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                txtResult.setText("Choose " + lenguajes[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}