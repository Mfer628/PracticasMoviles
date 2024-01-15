package com.example.proyectotercerparcial
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MyAdapter constructor(var nombres: List<Fruta>,  var layout: Int, var itemListener: OnItemClickListener) :RecyclerView.Adapter<MyAdapter.ViewHolder?> () {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view: View = LayoutInflater.from(parent.context).inflate(layout, parent,false)
        val vh = ViewHolder(view)
        return vh
    }

    override fun getItemCount(): Int {
       return nombres.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(nombres.get(position), itemListener)

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            var txtViewNombre:TextView = itemView.findViewById(R.id.NombreVerdura) as TextView
            var image: ImageView = itemView.findViewById(R.id.image) as ImageView;

            fun bind (nombre: Fruta,itemListener: OnItemClickListener){
                txtViewNombre.text=nombre.getNombre().toString()
                image.setImageDrawable(nombre.getImagen())
                itemView.setOnClickListener{
                    itemListener.onItemClick(nombre.getNombre(),absoluteAdapterPosition)

                }
            }


    }

    interface OnItemClickListener {
        fun onItemClick (nombre: String?, position: Int)

    }

}