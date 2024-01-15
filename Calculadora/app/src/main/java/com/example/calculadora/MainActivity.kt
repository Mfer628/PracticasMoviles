package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

        fun Sumar(view: View){
            val num1 =findViewById<EditText>(R.id.activity_main_num1)
            val num2 =findViewById<EditText>(R.id.activity_main_num2)



            var bndnum1=true
            var bndnum2=true

            num1.error=null;
            num2.error=null

            if (num1.text.toString().trim().isEmpty()){
                bndnum1=false
                num1.error=getString(R.string.activity_main_error)

            }
            if (num2.text.toString().trim().isEmpty()){
                bndnum2=false
                num2.error=getString(R.string.activity_main_error)

            }
            if(bndnum1 && bndnum2){

                var campo1:Double=num1.text.toString().toDouble()
                var campo2:Double=num2.text.toString().toDouble()
                val resultado: TextView=findViewById<EditText>(R.id.activity_main_resultado)

                var result = campo1+campo2

                resultado.text=result.toString();


                Toast.makeText(
                    this@MainActivity,
                    num1.text.toString()+" "+num2.text.toString(),
                    Toast.LENGTH_LONG

                ) .show()

            }


}
    fun Restar(view: View){
        val num1 =findViewById<EditText>(R.id.activity_main_num1)
        val num2 =findViewById<EditText>(R.id.activity_main_num2)


        var bndnum1=true
        var bndnum2=true

        num1.error=null;
        num2.error=null

        if (num1.text.toString().trim().isEmpty()){
            bndnum1=false
            num1.error=getString(R.string.activity_main_error)

        }
        if (num2.text.toString().trim().isEmpty()){
            bndnum2=false
            num2.error=getString(R.string.activity_main_error)

        }
        if(bndnum1 && bndnum2){

            var campo1:Double=num1.text.toString().toDouble()
            var campo2:Double=num2.text.toString().toDouble()
            val resultado: TextView=findViewById<EditText>(R.id.activity_main_resultado)

            var result = campo1-campo2

            resultado.text=result.toString();


            Toast.makeText(
                this@MainActivity,
                num1.text.toString()+" "+num2.text.toString(),
                Toast.LENGTH_LONG

            ) .show()

        }


    }
    fun Dividir(view: View){
        val num1 =findViewById<EditText>(R.id.activity_main_num1)
        val num2 =findViewById<EditText>(R.id.activity_main_num2)


        var bndnum1=true
        var bndnum2=true

        num1.error=null;
        num2.error=null

        if (num1.text.toString().trim().isEmpty()){
            bndnum1=false
            num1.error=getString(R.string.activity_main_error)

        }
        if (num2.text.toString().trim().isEmpty()){
            bndnum2=false
            num2.error=getString(R.string.activity_main_error)

        }
        if(bndnum1 && bndnum2){

            var campo1:Double=num1.text.toString().toDouble()
            var campo2:Double=num2.text.toString().toDouble()
            val resultado: TextView=findViewById<EditText>(R.id.activity_main_resultado)

            var result = campo1/campo2

            resultado.text=result.toString();


            Toast.makeText(
                this@MainActivity,
                num1.text.toString()+" "+num2.text.toString(),
                Toast.LENGTH_LONG

            ) .show()

        }


    }
    fun Multiplicar(view: View){
        val num1 =findViewById<EditText>(R.id.activity_main_num1)
        val num2 =findViewById<EditText>(R.id.activity_main_num2)


        var bndnum1=true
        var bndnum2=true

        num1.error=null;
        num2.error=null

        if (num1.text.toString().trim().isEmpty()){
            bndnum1=false
            num1.error=getString(R.string.activity_main_error)

        }
        if (num2.text.toString().trim().isEmpty()){
            bndnum2=false
            num2.error=getString(R.string.activity_main_error)

        }
        if(bndnum1 && bndnum2){

            var campo1:Double=num1.text.toString().toDouble()
            var campo2:Double=num2.text.toString().toDouble()
            val resultado: TextView=findViewById<EditText>(R.id.activity_main_resultado)

            var result = campo1*campo2

            resultado.text=result.toString();



            Toast.makeText(
                this@MainActivity,
                num1.text.toString()+" "+num2.text.toString(),
                Toast.LENGTH_LONG

            ) .show()

        }


    }


}