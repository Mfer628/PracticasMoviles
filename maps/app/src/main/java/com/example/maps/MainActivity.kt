package com.example.maps

import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var locationService:LocationService = LocationService()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txtLocation=findViewById<TextView>(R.id.tvLocation)
        val btnLocation=findViewById<Button>(R.id.btnLocation)
        btnLocation.setOnClickListener{
            lifecycleScope.launch {
               val result=  locationService.getUserLocation(this@MainActivity)
                if (result != null){
                    txtLocation.text ="Latutud ${result.latitude} y longitud ${result.longitude}"
                }
            }

        }
    }
}