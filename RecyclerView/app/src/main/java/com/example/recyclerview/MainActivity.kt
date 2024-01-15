package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {
    //Creando los objetos de las clases que hemos creado..
    private lateinit var names: MutableList<String>
    private lateinit var miRecyclerView: RecyclerView
    private lateinit var miAdapter: MyAdapter
    private lateinit var miLayoutManager: RecyclerView.LayoutManager
    private var counter= 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        names = getAllnames()
        miRecyclerView = findViewById(R.id.recycleView)
        miLayoutManager= GridLayoutManager(this , 2)
        //miLayoutManager= LinearLayoutManager(this)
        miAdapter =
            MyAdapter(names,R.layout.recycler_view_item, object : MyAdapter.OnItemCLickListener{
                override fun onItemClick(name: String?, position: Int) {
                   //Toast.makeText(this@MainActivity,name + " - "+position,Toast.LENGTH_LONG).show()
                deleteName(position);
                }
            })
        miRecyclerView.setLayoutManager(miLayoutManager)
        miRecyclerView.setAdapter(miAdapter)
    }
    private fun getAllnames(): MutableList<String> {
        return object : ArrayList<String>(){
            init {
                add("Alejandro")
                add("Jose")
                add("Fernanda")
                add("Brenda")
                add("Nayeli")
                add("Sara")
                add("Juan")
                add("Mariana")
                add("Maggie")
                add("Daniela")
                add("Alejandra")
                add("Jorge")
                add("Mireya")
                add("Alejandro")
                add("Alejandro")
                add("Jose")
                add("Fernanda")
                add("Brenda")
                add("Nayeli")
                add("Sara")
                add("Juan")
                add("Mariana")
                add("Maggie")
                add("Daniela")
                add("Alejandra")
                add("Jorge")
                add("Mireya")
                add("Alejandro")
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu_add,menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.add_name -> addName(0)
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun addName(position: Int): Boolean{
        names.add(position,"New name" + (++counter));
        miAdapter.notifyItemInserted(position)
        miLayoutManager.scrollToPosition(position)
        return true
    }
    private fun deleteName (position: Int){
        names.removeAt(position)
        miAdapter.notifyItemRemoved(position)
    }
}