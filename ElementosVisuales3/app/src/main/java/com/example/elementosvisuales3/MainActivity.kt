package com.example.elementosvisuales3

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class MainActivity : AppCompatActivity() {
    private lateinit var adialog: Button
    private lateinit var dpdialog: Button
    private lateinit var hrDialog: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adialog = findViewById(R.id.activity_main_adialog)

        adialog.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val fragment: DialogFragment = EstudianteDialog()
                fragment.show(supportFragmentManager, "Estudiante")
            }
        })
        dpdialog = findViewById(R.id.activity_main_dpddialog)

        dpdialog.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val fragment: DialogFragment = FechaDialog()
                fragment.show(supportFragmentManager, "Calendario")

            }
        })

        hrDialog= findViewById(R.id.activity_main_hrDialog)
        hrDialog.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val fragment: DialogFragment = HoraDialog()
                fragment.show(supportFragmentManager, "Fecha")
            }

        })
    }



}