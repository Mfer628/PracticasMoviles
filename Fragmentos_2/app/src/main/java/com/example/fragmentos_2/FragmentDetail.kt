package com.example.fragmentos_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class FragmentDetail : Fragment() {
    private lateinit var txtDetalle: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_detail, container, false)
        txtDetalle = view.findViewById(R.id.fragment_detail_os)
        return view
    }

    fun cargar_detalle (detalle : String){
        txtDetalle.text=detalle
    }

}