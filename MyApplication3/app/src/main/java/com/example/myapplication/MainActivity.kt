package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.ContextMenu.ContextMenuInfo
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.OnCreateContextMenuListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var lista: ListView//No me valides si esta inicializando, y
    private val dias = arrayOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")
    private val list: ArrayList<String> = ArrayList(dias.toList())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lista= findViewById(R.id.main_activity_lista)
        val adapter= ArrayAdapter(this,
                                   R.layout.activity_main,
                                    R.id.main_activity_text,
                                   list)
        lista.setAdapter(adapter)

        lista.onItemClickListener = OnItemClickListener{ adapterView, view,i,l ->

            Toast.makeText(
                this,
            list[i],
            Toast.LENGTH_LONG
            ).show()
        }
        registerForContextMenu(lista)

    }
//El signo de interrogacion puede ser null
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater=menuInflater
        inflater.inflate(R.menu.activity_main_menu,menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.new_game -> {
                mostrar_mensaje("Nuevo juego desde Menú de opciones Contextual")
            }
            R.id.help -> {
                mostrar_mensaje("Ayuda desde Menú de Opciones Contextual")
            }
            else ->  return super.onContextItemSelected(item)
        }


    }





//crear el menu o inflarlo cargar en el xml
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.activity_main_menu,menu)
        return true
    }
//Que item presiono el usuario
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.new_game -> mostrar_mensaje("Nuevo juego desde Menú de Opciones")
            R.id.help -> mostrar_mensaje("Ayuda desde Menú de Opciones")
            else -> super.onOptionsItemSelected(item)
        }
    }
    fun mostrar_mensaje( msj:String) :Boolean{

        val toast= Toast.makeText(this, msj, Toast.LENGTH_LONG)//LENGTH_LONG es el tiempo que dura el mensaje en patalla
        toast.setGravity(Gravity.BOTTOM or Gravity.CENTER,0,0)
        toast.show()
        return true
    }



}