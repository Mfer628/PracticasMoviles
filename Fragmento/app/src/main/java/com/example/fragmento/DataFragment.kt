package com.example.fragmento

import android.content.Context
import android.os.Bundle
import android.os.ProxyFileDescriptorCallback
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment


//Heredamos de Fragment() simpre debemos de heredar de fragment()
class DataFragment : Fragment() {
    private lateinit var txtInfo: EditText
    private lateinit var btnEnviar: Button
    private lateinit var callback: DataListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    //Me regresa una vista
    ): View? {
        //in
        val view:View= inflater.inflate(R.layout.fragment_data2,container,false )
        txtInfo=view.findViewById(R.id.txtInfo)
        btnEnviar=view.findViewById(R.id.btnEnviar)

        btnEnviar.setOnClickListener (object :View.OnClickListener{
            override fun onClick(v: View?) {
                val infoEnviar =txtInfo.text.toString()
                //Call back es un elemento de la interfa
                //ese callback se convierte en el activity que tiene incrustado el  fragmento
                callback.enviarInfo(infoEnviar)
            }
        })

        return view;
    }

 //Se le implementa una Interface

interface DataListener{
    fun enviarInfo(info:String)

}

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback=try{
            context as DataListener
        }catch (ex : Exception){
            throw ClassCastException(context.toString() + "Se debe implementar la interfaz DataListener")

        }

    }

}