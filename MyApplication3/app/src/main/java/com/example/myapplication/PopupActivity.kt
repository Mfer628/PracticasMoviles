package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast

class PopupActivity : AppCompatActivity() {
    private lateinit var popupmenu:Button
    //Mapeando el boton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup)
        popupmenu= findViewById(R.id.activity_main_popup)
        popupmenu.setOnClickListener (object : View.OnClickListener  {
            override fun onClick(view: View?) {
                val menu =  PopupMenu(this@PopupActivity,view)
                val inflanter: MenuInflater=menu.getMenuInflater()
                inflanter.inflate(R.menu.activity_main_menu,menu.getMenu())

                menu.setOnMenuItemClickListener (object: MenuItem.OnMenuItemClickListener,
                    PopupMenu.OnMenuItemClickListener {
                    override fun onMenuItemClick(menuItem: MenuItem): Boolean {
                        return when (menuItem.itemId){
                        R.id.new_game -> {
                            mostrar_mensaje("Nuevo juego desde Menú popup")
                        }
                            R.id.help ->{
                                mostrar_mensaje("Ayuda ")
                            }
                            else -> false
                        }
                    }

                })
                menu.show()
            }
        })
    }
    fun mostrar_mensaje( msj:String) :Boolean{

        val toast= Toast.makeText(this, msj, Toast.LENGTH_LONG)//LENGTH_LONG es el tiempo que dura el mensaje en patalla
        toast.setGravity(Gravity.BOTTOM or Gravity.CENTER,0,0)
        toast.show()
        return true
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater=menuInflater
        inflater.inflate(R.menu.activity_main_menu,menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.new_game -> {
                mostrar_mensaje("Nuevo juego desde Menú de opciones Contextual");
            }
            R.id.help -> {
                mostrar_mensaje("Ayuda desde Menú de Opciones Contextual");
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


}