package com.example.practicamultimedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    private lateinit var btnVideo: Button
    private lateinit var btnAudio: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnVideo = findViewById(R.id.btnVideo)
        btnAudio = findViewById(R.id.btnAudio)

        btnAudio.setOnClickListener{
            irAudio()
        }
        btnVideo.setOnClickListener{
            irVideo()
        }

    }
    fun irAudio (){
        startActivity(Intent(this, AudioAcivity:: class.java))
    }
    fun irVideo (){
        startActivity(Intent(this, VideoActivity:: class.java))
    }
}