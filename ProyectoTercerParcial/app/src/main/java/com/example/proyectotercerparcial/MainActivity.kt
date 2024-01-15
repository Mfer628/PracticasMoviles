package com.example.proyectotercerparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class MainActivity : AppCompatActivity() {
    private lateinit var txtUser : EditText
    private lateinit var txtpws : EditText
    private lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtUser= findViewById(R.id.txtUser)
        txtpws= findViewById(R.id.txtpswd)
        btn=findViewById(R.id.btnAceptar)

        btn.setOnClickListener ( object: View.OnClickListener {
            override fun onClick(v: View?) {
                var textNombre : String= txtUser.text.toString().trim();
                var password : String = txtpws.text.toString().trim();

                        if(textNombre == "fer" && password == "1234" ){
                        println("El usuario es correcto: " + textNombre);
                        println("La contraseña es correcta: " + password);
                            /*
                            val fragment :DialogFragment = UsuarioDialog()
                            fragment.show(supportFragmentManager, "Usuario")
*/                          siguiente(btn);
                    }else{
                        println("El usuario es incorrecto: " + textNombre);
                        println("La contraseña es incorrecta: " + password);
                            inflar();
                    }
            }
        })
    }

    fun siguiente(v: View){
        when (v.getId()){
            R.id.btnAceptar-> {
                val intent = Intent(this, BotonesPrincipales :: class.java)
                startActivity(intent);
            }

        }

    }
    fun inflar () : Boolean{
        val fragment: DialogFragment = UsuarioDialog()
        fragment.show(supportFragmentManager, "Usuario")
        return true
    }
}