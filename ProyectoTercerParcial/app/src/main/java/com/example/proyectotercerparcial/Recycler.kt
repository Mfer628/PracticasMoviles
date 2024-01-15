package com.example.proyectotercerparcial

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import androidx.core.content.ContextCompat
import kotlin.coroutines.CoroutineContext
class Recycler : AppCompatActivity() {




    private lateinit var nombres: MutableList<Fruta>
    private lateinit var miRecyclerView: RecyclerView
    private lateinit var miAdapter: MyAdapter
    private lateinit var miLayoutManager: RecyclerView.LayoutManager
    private var counter= 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        nombres = getAllNames()
        miRecyclerView = findViewById(R.id.recycler)
        miLayoutManager= LinearLayoutManager(this)

        miAdapter =
            MyAdapter(nombres,R.layout.item_verduras, object : MyAdapter.OnItemClickListener{
                override fun onItemClick(nombre: String?, position: Int) {
                    Toast.makeText(this@Recycler,nombre + " - "+position,Toast.LENGTH_LONG).show()
                    deleteName(position)
                }
            })
        miRecyclerView.setLayoutManager(miLayoutManager)
        miRecyclerView.setAdapter(miAdapter)

    }




    private fun getAllNames(): MutableList<Fruta>{
       // val objFruta = Fruta("Pera" , "@drawable/img2.jpg")


        return object : ArrayList<Fruta> (){
            init {
                val iconoManzana = ContextCompat.getDrawable(this@Recycler, R.drawable.manzana);
                val iconoPepino = ContextCompat.getDrawable(this@Recycler, R.drawable.pepino);
                val iconoPera = ContextCompat.getDrawable(this@Recycler, R.drawable.pera);
                val zana = ContextCompat.getDrawable(this@Recycler, R.drawable.zana);
                val ceboolla = ContextCompat.getDrawable(this@Recycler, R.drawable.cebolla);
                val pimiento = ContextCompat.getDrawable(this@Recycler, R.drawable.pimiento);
                val sandia = ContextCompat.getDrawable(this@Recycler, R.drawable.sandia);
                val betabel = ContextCompat.getDrawable(this@Recycler, R.drawable.betabel);
                val calaV = ContextCompat.getDrawable(this@Recycler, R.drawable.calabve);
                val calabaza = ContextCompat.getDrawable(this@Recycler, R.drawable.calabaza);

                add( Fruta("Manzana" , iconoManzana));
                add( Fruta("Pepino" , iconoPepino));
                add( Fruta("Pera" , iconoPera ));
                add( Fruta("Zanahoria" , zana));
                add( Fruta("Cebolla" , ceboolla));
                add( Fruta("Pimiento" , pimiento));
                add( Fruta("Sandia" , sandia));
                add( Fruta("Betabel" , betabel));
                add( Fruta("Calabaza Verde" , calaV));
                add( Fruta("Calabaza" , calabaza));
                add( Fruta("Manzana" , iconoManzana));
                add( Fruta("Pepino" , iconoPepino));
                add( Fruta("Pera" , iconoPera ));
                add( Fruta("Zanahoria" , zana));
                add( Fruta("Cebolla" , ceboolla));
                add( Fruta("Pimiento" , pimiento));
                add( Fruta("Sandia" , sandia));
                add( Fruta("Betabel" , betabel));
                add( Fruta("Calabaza Verde" , calaV));
                add( Fruta("Calabaza" , calabaza));
                add( Fruta("Manzana" , iconoManzana));
                add( Fruta("Pepino" , iconoPepino));
                add( Fruta("Pera" , iconoPera ));
                add( Fruta("Zanahoria" , zana));
                add( Fruta("Cebolla" , ceboolla));
                add( Fruta("Pimiento" , pimiento));
                add( Fruta("Sandia" , sandia));
                add( Fruta("Betabel" , betabel));
                add( Fruta("Calabaza Verde" , calaV));
                add( Fruta("Calabaza" , calabaza));
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
        val iconoPepino = ContextCompat.getDrawable(this@Recycler, R.drawable.pepino);
        nombres.add(position,Fruta("New name" , iconoPepino ));
        miAdapter.notifyItemInserted(position)
        miLayoutManager.scrollToPosition(position)
        return true
    }
    private fun deleteName (position: Int){
        nombres.removeAt(position)
        miAdapter.notifyItemRemoved(position)
    }


}