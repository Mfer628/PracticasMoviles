package com.example.elementos_visuales

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btntxt: Button
        var txtInfo: EditText
        btntxt=findViewById(R.id.activity_main_btnTexto)
        txtInfo=findViewById(R.id.txt)
        txtInfo.setOnEditorActionListener{textView, i, keyEvent ->
            var handled = false
            if(i == EditorInfo.IME_ACTION_SEARCH){
                mostraMensaje(textView.text.toString())
                handled= true
            }
            //Devuelve si se ha consumido la accion, de lo contrario
            //Si el usuario presiono el imeOptions
            handled
        }


        btntxt.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View?){

            mostraMensaje()
            }

        })

    }


    fun mostraMensaje(){

        val toast = Toast.makeText(this@MainActivity,"Activado desde codigo" , Toast.LENGTH_LONG)
        toast.setGravity(Gravity.BOTTOM or Gravity.CENTER, 0, 0)
        toast.show()
    }
    fun mostraMensaje(msj: String){

        val toast = Toast.makeText(this@MainActivity,"Activado desde codigo" , Toast.LENGTH_LONG)
        toast.setGravity(Gravity.BOTTOM or Gravity.CENTER, 0, 0)
        toast.show()
    }
}