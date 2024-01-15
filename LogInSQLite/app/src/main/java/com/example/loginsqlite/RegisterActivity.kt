package com.example.loginsqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    private lateinit var nombre : EditText
    private lateinit var apellido : EditText
    private lateinit var edad: EditText
    private lateinit var email : EditText
    private lateinit var password :EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        nombre = findViewById(R.id.txtNombre)
        edad = findViewById(R.id.txtEdad)
        email = findViewById(R.id.txtEmail)
        apellido = findViewById(R.id.txtapellido)
        password = findViewById(R.id.txtpswd)


    }
    fun GuardarDatos(view: View){
        var bd = BaseDatos(this)
        var use = Usuario()
        var bandera:Boolean= false
        if(nombre.text.toString().length > 0 && apellido.text.toString().length > 0 && edad.text.toString().length > 0 && email.text.toString().length>0 && password.text.toString().length > 0){
            use.nombre = nombre.text.toString()
            use.apellido = nombre.text.toString()
            use.edad = edad.text.toString().toInt()
            use.email = email.text.toString()
            use.password = password.text.toString()
            bd.insertarDatos(use)
        }

        bandera= true
        if (bandera){
            Toast.makeText(this, "Se registro Correctament", Toast.LENGTH_LONG).show()
            siguientebtn()
        }else {
            Toast.makeText(this, "Hubo un error", Toast.LENGTH_LONG).show()
        }
    }
    fun siguientebtn()  {
        val intent = Intent(this, MainActivity :: class.java)
        startActivity(intent);
    }
}