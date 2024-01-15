package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var resultado : String= "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var checkBox_Flauta: CheckBox
        var checkBox_Guitarra: CheckBox
        var checkBox_Piano: CheckBox
        var btnGustar: Button
        var txtResult: EditText
        //Checkbox de Flauta
        checkBox_Flauta= findViewById(R.id.flauta)
        //Checkbox de Guitarra
        checkBox_Guitarra= findViewById(R.id.Guitarra)
        //Checkbox de Piano
        checkBox_Piano= findViewById(R.id.Piano)
        //Boton de btnGustar
        btnGustar=findViewById(R.id.button_gustar)
        //TextView
        txtResult=findViewById(R.id.txtResultado)


            btnGustar.setOnClickListener{

            if (checkBox_Flauta.isChecked ){

                txtResult.setText("Te Gusta la flauta" + "Te gusta el piano");

            }

        }

    }


}