package com.example.fragmentos_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ActivityDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val item = intent.getStringExtra("ITEM").toString();
        val detail = supportFragmentManager.findFragmentById(R.id.activity_detail_fragment) as FragmentDetail;

        if (detail != null && detail.isInLayout()){
            detail.cargar_detalle(item);
        }


    }
}