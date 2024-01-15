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
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {
    private lateinit var txtNombre: EditText
    private lateinit var txtApellido: EditText
    private lateinit var txtEdad: EditText
    private lateinit var txtEmail: EditText
    private lateinit var txtpswd: EditText
    private lateinit var btnAceptar:Button
    private lateinit var progressBar: ProgressBar
    private lateinit var dbReference:DatabaseReference
    private lateinit var database:FirebaseDatabase
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        txtNombre=findViewById(R.id.txtNombre)
        txtApellido=findViewById(R.id.txtApellido)
        txtEdad= findViewById(R.id.txtEdad)
        txtEmail=findViewById(R.id.txtEmail)
        txtpswd=findViewById(R.id.txtpswd)
        btnAceptar=findViewById(R.id.btnAceptar);
        progressBar= findViewById(R.id.progressBar)
        database=FirebaseDatabase.getInstance()
        auth=FirebaseAuth.getInstance()
        dbReference=database.reference.child("User");
        btnAceptar.setOnClickListener{
            createNewAccount()
        }
    }
    private fun createNewAccount(){
        val name:String = txtNombre.text.toString();
        val apellido:String = txtApellido.text.toString();
        val edad:String = txtEdad.text.toString();
        val email:String = txtEmail.text.toString();
        val pswd:String = txtpswd.text.toString();

        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(apellido) && !TextUtils.isEmpty(edad) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(pswd) ){
                progressBar.visibility= View.VISIBLE
            auth.createUserWithEmailAndPassword(email, pswd)
                .addOnCompleteListener(this){
                    task ->
                    if (task.isComplete){
                        val user:FirebaseUser?=auth.currentUser
                        verifyEmail(user)
                        val userBD= user?.uid?.let { dbReference.child(it) }
                        userBD?.child("Name")?.setValue(name)
                        userBD?.child("Apellido")?.setValue(apellido)
                        action()
                    }
                }
        }
    }
    private fun verifyEmail(user: FirebaseUser?){
        user?.sendEmailVerification()
            ?.addOnCompleteListener(this){
                task ->
                if(task.isComplete){
                    Toast.makeText(this, "Email enviado", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this, "Error al enviar", Toast.LENGTH_LONG).show()
                }
            }
    }
    private fun action(){
        startActivity(Intent(this, LogInActivity:: class.java))
    }
}