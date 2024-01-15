package com.example.calcularimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun CalcularIMC(view: View){
        val estatura =findViewById<EditText>(R.id.estatura)
        val peso =findViewById<EditText>(R.id.peso)


        var bndestatura=true
        var bndpeso=true

        estatura.error=null;
        peso.error=null

        if (estatura.text.toString().trim().isEmpty()){
            bndestatura=false
            estatura.error=getString(R.string.activity_main_error)

        }
        if (peso.text.toString().trim().isEmpty()){
            bndpeso=false
            peso.error=getString(R.string.activity_main_error)

        }
        if(bndestatura && bndpeso){

            var altura:Float=estatura.text.toString().toFloat()
            var pes:Float=peso.text.toString().toFloat()
            val resultado: TextView=findViewById<EditText>(R.id.calcular)
var resultadofinal=(pes / altura.pow(2) )
println(resultadofinal)
            if (resultadofinal<15){
                println("Delgadez muy severa")
                Toast.makeText(
                    this@MainActivity,
                    "Tu estatura es: "+estatura.text.toString()+" "+"Tu peso es: "+peso.text.toString()+" "+"Tu IMC es: "+ resultadofinal+"Tienes una delgadez muy severa",
                    Toast.LENGTH_LONG

                ) .show()

            }
            if (resultadofinal>=15 && resultadofinal<15.9){
                println("Delgadez severa")
                Toast.makeText(
                    this@MainActivity,
                    "Tu estatura es: "+estatura.text.toString()+" "+"Tu peso es: "+peso.text.toString()+" "+"Tu IMC es: "+ resultadofinal+"Tienes una delgadez  severa",
                    Toast.LENGTH_LONG

                ) .show()

            }
            if (resultadofinal>=15.9 && resultadofinal<18.4){
                println("Delgadez")
                Toast.makeText(
                    this@MainActivity,
                    "Tu estatura es: "+estatura.text.toString()+" "+"Tu peso es: "+peso.text.toString()+" "+"Tu IMC es: "+ resultadofinal+"Tienes  delgadez ",
                    Toast.LENGTH_LONG

                ) .show()

            }
            if (resultadofinal>=18.5 && resultadofinal<24.9){
                println("Peso Saludable ")
                Toast.makeText(
                    this@MainActivity,
                    "Tu estatura es: "+estatura.text.toString()+" "+"Tu peso es: "+peso.text.toString()+" "+"Tu IMC es: "+ resultadofinal +" Tienes un peso saludable",
                    Toast.LENGTH_LONG

                ) .show()
            }
            if (resultadofinal>=24.9 && resultadofinal<29.9){
                println("Peso Sobrepeso ")
                Toast.makeText(
                    this@MainActivity,
                    "Tu estatura es: "+estatura.text.toString()+" "+"Tu peso es: "+peso.text.toString()+" "+"Tu IMC es: "+ resultadofinal+"Tienes sobrepeso ",
                    Toast.LENGTH_LONG

                ) .show()
            }
            if (resultadofinal>=30 && resultadofinal<34.9){
                println(" Obesidad Moderada")
                Toast.makeText(
                    this@MainActivity,
                    "Tu estatura es: "+estatura.text.toString()+" "+"Tu peso es: "+peso.text.toString()+" "+"Tu IMC es: "+ resultadofinal+"Tienes Obesidad Moderada ",
                    Toast.LENGTH_LONG

                ) .show()
            }
            if (resultadofinal>=35 && resultadofinal<39.9){
                println(" Obesidad Severa ")
                Toast.makeText(
                    this@MainActivity,
                    "Tu estatura es: "+estatura.text.toString()+" "+"Tu peso es: "+peso.text.toString()+" "+"Tu IMC es: "+ resultadofinal+"Tienes una obesidad severa",
                    Toast.LENGTH_LONG

                ) .show()
            }
            if (resultadofinal>40){
                println(" Obesidad muy Severa")
                Toast.makeText(
                    this@MainActivity,
                    "Tu estatura es: "+estatura.text.toString()+" "+"Tu peso es: "+peso.text.toString()+" "+"Tu IMC es: "+ resultadofinal+"Tienes una obesidad muy severa",
                    Toast.LENGTH_LONG

                ) .show()
            }




            Toast.makeText(
                this@MainActivity,
                estatura.text.toString()+" "+peso.text.toString(),
                Toast.LENGTH_LONG

            ) .show()

        }


    }
}