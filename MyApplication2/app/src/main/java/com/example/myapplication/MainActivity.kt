package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    var cont =0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("MyApp","OnCreate()");

    }
//Es un metodo el estado de una actividad Objeto est
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    outState.putInt("conta",cont);
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val txtcuenta: TextView = findViewById(R.id.activity_main_contador);
        if (savedInstanceState != null) {

            cont = savedInstanceState.getInt("conta");
        }
        txtcuenta.text=cont.toString();
    }
    fun Guardar (view: View){
        val name =findViewById<EditText>(R.id.activity_main_name)
        val phone =findViewById<EditText>(R.id.activity_main_phone)

        var bndName=true;
        var bndPhone= true

        name.error=null
        phone.error=null;

        if (name.text.toString().trim().isEmpty()){
            bndName=false
            name.error=getString(R.string.activity_main_error)

        }
        if (phone.text.toString().trim().isEmpty()){
            bndPhone=false
            phone.error=getString(R.string.activity_main_error)

        }
        if(bndName && bndPhone){

        Toast.makeText(
            this@MainActivity,
            name.text.toString()+" "+phone.text.toString(),
            Toast.LENGTH_LONG

        ) .show()
        }


    }
fun contar(view: View){
    val txtcuenta: TextView = findViewById(R.id.activity_main_contador)
    cont++
    txtcuenta.text=cont.toString()

}
    //Ciclo de vida de la actividad


    override fun onStart(){
        super.onStart();
        Log.e("MyApp","OnStart()");

    }
    override fun onResume(){
        super.onResume();
        Log.e("MyApp","OnResume()");

    }
    override fun onPause(){
        super.onPause();
        Log.e("MyApp","OnPause()");

    }

    override fun onStop() {
        super.onStop()
        Log.e("MyApp","OnStop()");

    }

    override fun onRestart() {
        super.onRestart()
        Log.e("MyApp","OnRestart()");

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MyApp","OnDestroy()");
    }






}