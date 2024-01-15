package com.example.elementosvisualestarea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class Rdiogrup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rdiogrup)

        var btnAceptar: Button
        btnAceptar=findViewById(R.id.btnAceptar3)

        var txtresult: TextView
        txtresult=findViewById(R.id.result)
        var btnNext3: Button
        btnNext3=findViewById(R.id.Next3);
        btnNext3.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                ver(btnNext3);

            }
        })



        var rdBaseForm: RadioButton
        rdBaseForm= findViewById(R.id.rbBase_Form)
        var rdPastSimple: RadioButton
        rdPastSimple= findViewById(R.id.rbPast_Simple)
        var rdPastParticiple: RadioButton
        rdPastParticiple= findViewById(R.id.rbPast_Participle)

        btnAceptar.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {


                var frase= rdPastParticiple.text.toString()

                var frase2= rdPastSimple.text.toString()
                var frase3= rdBaseForm.text.toString()

                if (rdBaseForm.isChecked ){
                    txtresult.setText("The answer is Wrong " + frase3)
                }
                else if (rdPastSimple.isChecked){
                    txtresult.setText("The answer is Wrong "+frase2)
                } else if(rdPastParticiple.isChecked){
                    txtresult.setText("The answer is correct "+frase)

                }


            //txtresult.setText("La respuesta es: " + frase)


            }
        })


    }
    fun ver(v: View){
        when (v.getId()){
            R.id.Next3-> {
                val intent = Intent(this, BTNTonggle :: class.java)
                startActivity(intent)
            }

        }

    }

    fun onRadioButtonClicked(view: View){

        if (view is RadioButton){
            var checked = view.isChecked

            when(view.id){
                R.id.rbBase_Form -> {
                    if (checked){
                        Toast.makeText(applicationContext," You choose Base Form  " , Toast.LENGTH_SHORT).show()

                    }
                }
                R.id.rbPast_Simple -> {
                    if (checked){
                        Toast.makeText(applicationContext," You choose Past Simple",Toast.LENGTH_SHORT).show()

                    }
                }
                R.id.rbPast_Participle -> {
                    if (checked){
                        Toast.makeText(applicationContext," You choose Past Participle ",Toast.LENGTH_SHORT).show()

                    }
                }
            }
        }

    }

}