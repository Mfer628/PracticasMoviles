package com.example.recyclerview
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter constructor(var names:List<String>, var layout: Int, var itemListener: OnItemCLickListener) : RecyclerView.Adapter<MyAdapter.ViewHolder?>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view:View = LayoutInflater.from(parent.context).inflate(layout,parent,false)
        val vh = ViewHolder(view)
        return vh;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {

        return names.size;
    }



    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        //Construccion Primario: Es un constructor que permite asignarle atribtos a la clase sin que yo se los tenga
        //Que poner el codigo
            var txtViewName:TextView = itemView.findViewById<View>(R.id.text_ViewName) as TextView
        fun bind(name: String?,itemListener: OnItemCLickListener){
            txtViewName.text= name
            itemView.setOnClickListener{
                itemListener.onItemClick(name,absoluteAdapterPosition);
            }
        }
    }


    interface OnItemCLickListener{
        fun onItemClick(name:String?,position: Int);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        holder.bind(names.get(position) , itemListener);
    }







}