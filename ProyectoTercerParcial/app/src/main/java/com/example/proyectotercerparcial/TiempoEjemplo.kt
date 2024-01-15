package com.example.proyectotercerparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*


class TiempoEjemplo : AppCompatActivity() {
    private lateinit var popupmenu: Button
    private lateinit var lista: ListView
    private lateinit var txt : TextView
    private val dias = arrayOf("10:30", "11:30", "12:30", "1:30", "2:30", "4:00", "5:00")
    private val list: ArrayList<String> = ArrayList(dias.toList())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiempo_ejemplo)


        var txtTime: EditText;

        txtTime = findViewById(R.id.etTime);

        txtTime.setOnClickListener { showTimePickerDialog() }
        lista = findViewById(R.id.main_activity_lista)
        val adapter = ArrayAdapter(this , R.layout.activity_tiempo_ejemplo,
            R.id.main_activity_text,
            list)

        lista.setAdapter(adapter)
        lista.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(
                this,
                list[i],
                Toast.LENGTH_LONG
            ).show()
            registerForContextMenu(lista);
        }


        popupmenu = findViewById(R.id.popuMenu)



        popupmenu.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val menu = PopupMenu(this@TiempoEjemplo, view)
                val inflater: MenuInflater = menu.getMenuInflater()
                inflater.inflate(R.menu.menu_contextual, menu.getMenu())
                menu.setOnMenuItemClickListener(object : MenuItem.OnMenuItemClickListener,
                    PopupMenu.OnMenuItemClickListener {
                    override fun onMenuItemClick(menuItem: MenuItem): Boolean {
                        return when (menuItem.getItemId()) {
                            R.id.dialog_date -> {
                                mostrar_mensaje("Nuevo Juego desde Menú Popup")
                                siguientebtn();
                            }

                            else -> false
                        }
                    }
                })
                menu.show()
            }
        })
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_contextual, menu)
    }

    private fun showTimePickerDialog() {
        val timePicker = HoraDialog {onTimeSelected(it)}
        timePicker.show(supportFragmentManager, "Time")
    }
    private fun onTimeSelected(time:String){
        var txtTime1: EditText;
        txtTime1=findViewById(R.id.etTime);
        txtTime1.setText("Has seleccionado  $time");

        if (txtTime1.getText().toString().trim().length < 0){
            println("El campo esta vacio")
        }else{
            println("El campo tiene informacion");

        }

    }

    fun mostrar_mensaje(msj: String) : Boolean {
        val toast = Toast.makeText(this, msj, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.BOTTOM or Gravity.CENTER, 0, 0)
        toast.show()
        return true
    }

    fun siguientebtn() :Boolean {
        val intent = Intent(this, MainActivity :: class.java)
        startActivity(intent);
        return true;

    }

}