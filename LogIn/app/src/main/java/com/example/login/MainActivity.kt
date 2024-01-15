package com.example.login


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.firestore.FirebaseFirestore

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement
import java.text.SimpleDateFormat
import java.util.*
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity() {
    companion object{
        lateinit var usermail:String
        lateinit var provaiderSeesion:String
    }
    private var email by Delegates.notNull<String>()
    private var password by Delegates.notNull<String>()
    private lateinit var etEmail: EditText
    private lateinit var etPasswpord: EditText
    private lateinit var btnAceptar: Button
    private lateinit var lyTerms : LinearLayout


    private lateinit var mAuth :FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lyTerms = findViewById(R.id.lytTerms)
        lyTerms.visibility = View.INVISIBLE


    etEmail = findViewById(R.id.txtUser)
    etPasswpord = findViewById(R.id.txtpswd)
    btnAceptar = findViewById(R.id.btnAceptar)
    mAuth = FirebaseAuth.getInstance();
        btnAceptar.setOnClickListener{
            login();
        }

    }
/*
    public override fun onStart() {
        super.onStart()
    //val currentUser = FirebaseAuth.getInstance().currentUser
    //if (currentUser != null)goHome(currentUser.email.toString(), currentUser.providerId);
    }

 */
    override fun onBackPressed() {
        val startMain = Intent(Intent.ACTION_MAIN)
        startMain.addCategory(Intent.CATEGORY_HOME)
        startMain.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(startMain)
    }
    fun login(){
        loginUser()
    }
private fun loginUser(){
    email = etEmail.text.toString()
    password = etPasswpord.text.toString()

    mAuth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener(this){task->
            if (task.isSuccessful){
                var dataRegistrer = SimpleDateFormat("dd/MM/yyyy").format(Date())
                var dbRegister = FirebaseFirestore.getInstance()
                dbRegister.collection("users").document(email).set(hashMapOf(
                    "user" to usermail,
                    "dateRegister " to dataRegistrer
                ))

                println("Esto es en e vez de la ventana")
                goHome(email, "email")
            }
            else{
                if (lyTerms.visibility == View.INVISIBLE) lyTerms.visibility = View.VISIBLE
                else{
                    var cbAcept = findViewById<CheckBox>(R.id.cbAcept)
                    if(cbAcept.isChecked){
                        registrar()
                    }
                }
            }

        }


}
private fun goHome(email : String, provider: String){
    usermail =email
    provaiderSeesion = provider
    val intent = Intent (this, activity_users::class.java )
    startActivity(intent);
}


private fun registrar(){
    email = etEmail.text.toString()
    password = etPasswpord.text.toString()

    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
        .addOnCompleteListener{
            if(it.isSuccessful){
                    println("Todo ah salido bien")

            }else
                println("Algo salio mal")
        }




}
    fun OlvidoContraseña ( view: View ) {
        Actualizarpswd();
    }
    private fun Actualizarpswd(){
        var e = etEmail.text.toString()
        if (!TextUtils.isEmpty(e)){
            mAuth.sendPasswordResetEmail(e)
                .addOnCompleteListener{ task ->
                    if (task.isSuccessful){
                        Toast.makeText(this, "Email enviado a $e", Toast.LENGTH_LONG).show()
                    }
                    else{
                        Toast.makeText(this, "No se encontro el usuario con este correo", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}