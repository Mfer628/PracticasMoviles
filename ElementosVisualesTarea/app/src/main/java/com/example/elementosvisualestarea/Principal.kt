package com.example.elementosvisualestarea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        var btnPrincipal: Button
        btnPrincipal=findViewById(R.id.btnPrincipal);
        btnPrincipal.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                ver(btnPrincipal);

            }
        })

    }
    fun ver(v: View){
        when (v.getId()){
            R.id.btnPrincipal-> {
                val intent = Intent(this, compleateText :: class.java)
                startActivity(intent)
            }

        }

    }

}
