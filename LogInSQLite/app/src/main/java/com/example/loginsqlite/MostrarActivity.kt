package com.example.loginsqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class MostrarActivity : AppCompatActivity() {
    private lateinit var nombre : EditText
    private lateinit var apellido : EditText
    private lateinit var edad: EditText
    private lateinit var email : EditText
    private lateinit var password :EditText
    private lateinit var codigo:EditText
    private lateinit var mensaje: TextView
    private lateinit var btnActualizar: Button
    private lateinit var linear: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar)
        nombre = findViewById(R.id.txtNombre)
        edad = findViewById(R.id.txtEdad)
        email = findViewById(R.id.txtEmail)
        apellido = findViewById(R.id.txtapellido)
        password = findViewById(R.id.txtpswd)
        codigo =  findViewById(R.id.txtCodigo)
        mensaje = findViewById(R.id.txtMostrar)
        btnActualizar = findViewById(R.id.btnActualizar)
        linear=findViewById(R.id.linearLayout)
        btnActualizar.setOnClickListener{
            linear.visibility = View.VISIBLE
        }

    }
    fun Listar(view: View){
        var bd = BaseDatos(this)
        var datos = bd.ListarDatos()
        mensaje.text=""
        if (codigo.text.toString().isNotEmpty()){
            for(i in 0 ..datos.size-1){
                mensaje.append("codigo: "+ datos.get(i).id.toString()+ "\n"+" Nombre" +  datos.get(i).nombre+ "\n" +"Apellido: "+  datos.get(i).apellido.toString()+"\n" + "Edad" + datos.get(i).edad.toString()+ "\n" +" Email: " + datos.get(i).email.toString()+   "\n")

            }
        }
    }
    fun borrarelemento(view: View){
        var db = BaseDatos(this)
        if (codigo.text.toString().length > 0){
            db.borrarDato(codigo.text.toString())
        }

    }
    fun actualizarDatos(view: View){
        var db = BaseDatos(this)
        if(codigo.text.toString().length > 0) {
            db.actualizar(
                codigo.text.toString(),
                nombre.text.toString (),
                apellido.text.toString (),
                edad.text.toString ().toInt(),
                email.text.toString (),
                password.text.toString()
            )

        }

    }
}
