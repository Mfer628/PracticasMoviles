package com.example.elementosvisualestarea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.ClickableSpan
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SearchView.SearchAutoComplete

class compleateText : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compleate_text)

        var answer: TextView
        answer=findViewById( R.id.answer )
        var btnAceptar:Button
        btnAceptar=findViewById(R.id.btnAceptar)
        var autoComplete= findViewById<AutoCompleteTextView>(R.id.autoComplete)
        var tiempo: Array<String> = resources.getStringArray(R.array.respuestas)
        var adapter : ArrayAdapter<String> = ArrayAdapter <String>(this, android.R.layout.simple_spinner_dropdown_item,tiempo)
        autoComplete.setThreshold(2)//Este evento nos ayuda para que busque solo con 2 letras introducidas
        autoComplete.setAdapter(adapter)


        btnAceptar.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(applicationContext," choose" +autoComplete.text.toString(),Toast.LENGTH_SHORT).show()
                var frase=autoComplete.text.toString()
                //answer.setText("La frase es: "+frase)
                if (frase=="Past Simple" ){
                    answer.setText("The answer is correct  "+frase)
                }
                else {
                    answer.setText("The answer is Wrong "+frase)

                }

            }
        })

        // Establece el oyente que recibirá una notificación cuando el usuario haga clic en un elemento de la lista desplegable.
        autoComplete.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(applicationContext," Choose " + tiempo[position],Toast.LENGTH_SHORT).show()

        }



        var btnNext1: Button
        btnNext1=findViewById(R.id.Next1);
        btnNext1.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                ver(btnNext1);

            }
        })



    }
    fun ver(v: View){
        when (v.getId()){
            R.id.Next1-> {
                val intent = Intent(this, MainActivity :: class.java)
                startActivity(intent)
            }

        }

    }


}