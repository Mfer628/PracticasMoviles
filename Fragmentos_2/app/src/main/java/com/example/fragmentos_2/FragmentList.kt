package com.example.fragmentos_2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class FragmentList : Fragment() {
    private lateinit var lista: ListView
    private val so = arrayOf("Windows", "MacOs", "Linux", "Debian" , "Android" ,"Solaris" , "RedHat",
                                "Fedora" , "CentOS", "Ubuntu", "Kali", "Tiles", "iOS", "MInt", "Windows Phone"  )
    private val list: ArrayList<String> = ArrayList(so.toList())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
       val view:View=inflater.inflate(R.layout.fragment_list, container,false)
        lista = view.findViewById(R.id.main_activity_lista)
        val adapter = ArrayAdapter(
            requireActivity(),
            android.R.layout.simple_list_item_1, list
        )
        lista.setAdapter(adapter);
        lista.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->

            cargar_actividad(list.get(i))
        }
        return view

    }

    fun cargar_actividad(item : String){
        val detail=requireActivity().supportFragmentManager.findFragmentById(R.id.activity_main_detail) as FragmentDetail
            if(detail!= null && detail.isInLayout){
                detail.cargar_detalle(item)
            }else {
                val intent = Intent(activity, ActivityDetail::class.java)
                intent.putExtra("ITEM", item)
                startActivity(intent)
            }
    }
}