package com.example.conexionsqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var nombre: EditText
    lateinit var edad: EditText
    lateinit var codigo: EditText
    lateinit var mensaje: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nombre = findViewById(R.id.txtNombre)
        edad = findViewById(R.id.txtEdad)
        codigo = findViewById(R.id.txtcodigo)
        mensaje = findViewById(R.id.txtLista)
    }

    fun GuardarDatos(view: View) {

        var bd = BasedeDatos(this)
        var usu = Usuario()
        if (nombre.text.toString().length > 0 && edad.text.toString().length > 0) {
            usu.nombre = nombre.text.toString()
            usu.edad = edad.text.toString().toInt()
            bd.insertarDatos(usu)
        }
    }

    fun ListarDatos(view: View) {
        var bd = BasedeDatos(this)
        var datos = bd.listarDatos()
        mensaje.text = ""
        if (codigo.text.toString().isNotEmpty()) {
            for (i in 0..datos.size - 1) {
                mensaje.append(
                    "codigo" + datos.get(i).id.toString() + " Nombre" + datos.get(i).nombre + datos.get(
                        i
                    ).edad.toString() + "\n"
                )
                println(
                    "codigo" + datos.get(i).id.toString() + " Nombre" + datos.get(i).nombre + datos.get(
                        i
                    ).edad.toString() + "\n"
                )
            }
        }
    }
    fun actualizarDatos (view: View){
        var db = BasedeDatos(this)
        if(codigo.text.toString().length>0) {
            db.actualizar(
                codigo.text.toString(),
                nombre.text.toString(),
                edad.text.toString().toInt()
            )
        }
    }
    fun borrarDatos (view: View){
        var db = BasedeDatos(this)
        if(codigo.text.toString().length>0){
            db.borrarDatos(codigo.text.toString());
        }
    }
}







