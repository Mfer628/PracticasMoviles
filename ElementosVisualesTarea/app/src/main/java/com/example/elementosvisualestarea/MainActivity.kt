package com.example.elementosvisualestarea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Declarando los Views
        var checkBox_Run: CheckBox
        var checkBox_ran: CheckBox
        var checkBox_run2: CheckBox
        var checkBox_running: CheckBox
        var btnGustar: Button
        var txtResult: TextView
        //Checkbox de Flauta
        checkBox_Run= findViewById(R.id.run)
        //Checkbox de Guitarra
        checkBox_ran= findViewById(R.id.ran)

        checkBox_run2= findViewById(R.id.run2)
        //Checkbox de Piano
        checkBox_running=findViewById(R.id.running)
        //Boton de btnGustar
        btnGustar=findViewById(R.id.button_aceptar)
        //TextView
        txtResult=findViewById(R.id.txtResultado)


        btnGustar.setOnClickListener{

            if (checkBox_Run.isChecked  && checkBox_ran.isChecked && checkBox_run2.isChecked){

                txtResult.setText(" Base Form  Run  " +" \n "  +  "\n Past Simple  Ran"  +" \n " + " \n Past Participle Run" );
            }else{
                txtResult.setText("Son Incorrectos");

            }

        }
        var btnNext2: Button
        btnNext2=findViewById(R.id.Next2);
        btnNext2.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                ver(btnNext2);

            }
        })


    }
    fun ver(v: View){
        when (v.getId()){
            R.id.Next2-> {
                val intent = Intent(this,  Rdiogrup:: class.java)
                startActivity(intent)
            }

        }

    }

}