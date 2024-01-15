package com.example.loginsqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var user : EditText
    private lateinit var password: EditText
    private lateinit var btnAceptar:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        user= findViewById(R.id.txtUser1)
        password=findViewById(R.id.txtpswd1)
        btnAceptar= findViewById(R.id.btnAceptar)

        btnAceptar.setOnClickListener{
            consultar()
        }
    }
    fun consultar(){
        var user1:String = user.text.toString()
        var passwd:String = password.text.toString()
        var bd = BaseDatos(this)
        var consulta = bd.verificarCredenciales(user1, passwd)
        if(consulta){
            Toast.makeText(this, "Todo salio bien" , Toast.LENGTH_LONG).show()
           Mostrar()
        }else{
            Toast.makeText(this, "Algo salio Mal :(" , Toast.LENGTH_LONG).show()
        }
    }
    fun Mostrar(){
        val intent = Intent(this, MostrarActivity :: class.java)
        startActivity(intent);
    }
    fun irRegister(view: View){
        val intent = Intent(this, RegisterActivity :: class.java)
        startActivity(intent);
    }
}