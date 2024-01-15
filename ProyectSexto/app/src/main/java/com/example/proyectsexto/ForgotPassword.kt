package com.example.proyectsexto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ForgotPassword : AppCompatActivity() {
    private lateinit var txtEmail: EditText
    private lateinit var btnAceptar: Button
    private lateinit var auth:FirebaseAuth
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        txtEmail=findViewById(R.id.txtEmail)
        btnAceptar=findViewById(R.id.btnAceptar)

        btnAceptar.setOnClickListener{
            send()
        }
        progressBar= findViewById(R.id.progressBar2)

        auth= FirebaseAuth.getInstance()

    }
    private fun send(){
            val email=txtEmail.text.toString()
        if (!TextUtils.isEmpty(email)){
            auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(this){
                    task->
                    if (task.isSuccessful){
                        progressBar.visibility=View.VISIBLE
                            startActivity(Intent(this, LogInActivity::class.java))
                    }else{
                        Toast.makeText(this, "Error al enviar el email",Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}