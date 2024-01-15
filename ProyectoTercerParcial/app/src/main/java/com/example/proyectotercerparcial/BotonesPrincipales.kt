package com.example.proyectotercerparcial

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.fragment.app.DialogFragment

class BotonesPrincipales : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_botones_principales)

        var btnRecycler : Button
        btnRecycler=findViewById(R.id.btnListo)
            //btnCortarCubos
        var btnCortarCubos : ImageButton
        btnCortarCubos=findViewById(R.id.btnCubos)

        //btnCortar Julianas
        var btnCortarJulianas : ImageButton
        btnCortarJulianas=findViewById(R.id.btnJulianas)

        //btnRallar
        var btnRayar: ImageButton
        btnRayar= findViewById(R.id.btnRallar)


        var btnEspiral: ImageButton
        btnEspiral=findViewById(R.id.btnEspiral)


        btnCortarCubos.setOnClickListener{
            btnRecycler.visibility=View.VISIBLE
            creacionBtnCubos()
        }

        btnCortarJulianas.setOnClickListener{
            btnRecycler.visibility=View.VISIBLE
            creacionBtnJulianas()
        }

        btnRayar.setOnClickListener{
            btnRecycler.visibility=View.VISIBLE
            creacionBtnRallar()
        }

        btnEspiral.setOnClickListener{
            btnRecycler.visibility=View.VISIBLE
            creacionBtnEspiral()
        }

        btnRecycler.setOnClickListener {
            siguiente(btnRecycler)
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.activity_menu, menu)
        return true;
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId){
            R.id.dialog_date->inflarDate()
            R.id.dialog_time->siguientebtn()

            else -> super.onOptionsItemSelected(item)
        }

    }

    fun mostrar_mensaje (msj : String): Boolean{
        val toast = Toast.makeText(this, msj, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.BOTTOM or Gravity.CENTER, 0, 0)
        toast.show()
        return true
    }
    fun inflar () : Boolean{
        val fragment: DialogFragment = UsuarioDialog()
        fragment.show(supportFragmentManager, "Usuario")

        return true
    }
    fun inflarDate () : Boolean{
        val fragment: DialogFragment = FechaDialog()
        fragment.show(supportFragmentManager, "Fecha");
        return true
    }


    private fun creacionBtnCubos(){

        val radioG: RadioGroup
        radioG=findViewById(R.id.RadioGroup)
        radioG.clearCheck()
        radioG.removeAllViews()
        val textos = arrayOf("1x1", "2X2", "3x3")

        textos.forEach {
            val rbtn = RadioButton(this)
            rbtn.id = View.generateViewId()
            rbtn.text=it
            radioG.addView(rbtn)
        }
    }

    private fun creacionBtnJulianas() {

        val radioG: RadioGroup
        radioG=findViewById(R.id.RadioGroup)
        radioG.clearCheck()
        radioG.removeAllViews()
        val textos = arrayOf("10x10", "20X20", "30x30")

        textos.forEach {
            val rbtn = RadioButton(this)
            rbtn.id = View.generateViewId()
            rbtn.text=it
            radioG.addView(rbtn)
        }
    }

    private fun creacionBtnRallar() {

        val radioG: RadioGroup
        radioG=findViewById(R.id.RadioGroup)
        radioG.clearCheck()
        radioG.removeAllViews()
        val textos = arrayOf("4cm Largo - 1mm Grosor", "5cm Largo - 2mm Grosor")

        textos.forEach {
            val rbtn = RadioButton(this)
            rbtn.id = View.generateViewId()
            rbtn.text=it
            radioG.addView(rbtn)
        }


    }

    private fun creacionBtnEspiral() {

        val radioG: RadioGroup
        radioG=findViewById(R.id.RadioGroup)
        radioG.clearCheck()
        radioG.removeAllViews()
        val textos = arrayOf("3cm Grosor", "4cm Grosor", "5cm Grosor")

        textos.forEach {
            val rbtn = RadioButton(this)
            rbtn.id = View.generateViewId()
            rbtn.text=it
            radioG.addView(rbtn)

        }
    }
    fun siguiente(v: View){
        when (v.getId()){
            R.id.btnListo-> {
                val intent = Intent(this, Recycler :: class.java)
                startActivity(intent);
            }
        }
    }
    fun siguientebtn() :Boolean {
                val intent = Intent(this, TiempoEjemplo :: class.java)
                startActivity(intent);
        return true;

    }


}