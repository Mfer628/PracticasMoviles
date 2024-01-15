package com.example.elementosvisualestarea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.ToggleButton

class BTNTonggle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_btntonggle)
        var txtresul: TextView
        txtresul= findViewById(R.id.txtResp)

        val toggle: ToggleButton
        toggle= findViewById(R.id.TgOpcion)

        toggle.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                txtresul.setText("The answer is correct")
            } else {
                txtresul.setText("The answer is Wrong")
            }
        }

        var btnNext4: Button
        btnNext4=findViewById(R.id.Next4);
        btnNext4.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                ver(btnNext4);

            }
        })


    }
    fun ver(v: View){
        when (v.getId()){
            R.id.Next4-> {
                val intent = Intent(this, Elemento_sner :: class.java)
                startActivity(intent)
            }

        }

    }
}