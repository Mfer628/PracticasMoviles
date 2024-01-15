package com.example.fragmento

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity() , DataFragment.DataListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun enviarInfo(info: String) {
        //El supportFragmentManager: Permite obtener el fragmento id
        val detailsFragment:DetailsFragment= supportFragmentManager.findFragmentById(R.id.detailFragment) as DetailsFragment
        //Esto viene lo que mando llamar el callback.enviar
        detailsFragment.mostrarInfo(info)
    }
}