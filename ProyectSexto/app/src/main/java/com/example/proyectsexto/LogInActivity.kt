package com.example.proyectsexto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LogInActivity : AppCompatActivity() {
    private lateinit var txtUser: EditText
    private lateinit var txtpswd: EditText
    private lateinit var progressBar: ProgressBar

    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        txtUser=findViewById(R.id.txtUser)
        txtpswd=findViewById(R.id.txtpswd)
        progressBar= findViewById(R.id.progressBar1)
        auth= FirebaseAuth.getInstance()

    }
    fun forgotPassworrd(view: View){
        startActivity(Intent(this, ForgotPassword:: class.java))
    }
    fun register(view: View){
        startActivity(Intent(this, RegisterActivity:: class.java))
    }
    fun logIn(view: View){
        loginUser()
    }
    private fun loginUser(){
        val user:String=txtUser.text.toString()
        val password:String= txtpswd.text.toString()

        if(!TextUtils.isEmpty(user) && !TextUtils.isEmpty(password) ){
            progressBar.visibility= View.VISIBLE
            auth.signInWithEmailAndPassword(user,password)
                .addOnCompleteListener(this){
                    task ->
                    if (task.isSuccessful){
                            action()
                    }else{
                        Toast.makeText(this,"Algo salio mal", Toast.LENGTH_LONG).show()
                    }
                }
        }

    }
    private fun action(){
        startActivity(Intent(this, MainActivity:: class.java))
    }

}