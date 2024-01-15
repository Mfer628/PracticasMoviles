package com.example.layouts_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var contador=0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("conta",contador);
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val txtlike: TextView = findViewById(R.id.txtlike);
        val txtnolike: TextView = findViewById(R.id.txtnolike);
        if (savedInstanceState != null) {

            contador = savedInstanceState.getInt("conta");
        }
        txtlike.text=contador.toString();
        txtnolike.text=contador.toString();
        }
    fun contadorlike(view: View){
        val txtlike: TextView = findViewById(R.id.txtlike)
        contador++
        txtlike.text=contador.toString()
    }
    fun contadornolike(view: View){

        val txtnolike: TextView = findViewById(R.id.txtnolike)
        contador++
        txtnolike.text=contador.toString()
    }

}