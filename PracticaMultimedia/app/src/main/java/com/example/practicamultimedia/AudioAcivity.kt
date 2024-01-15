package com.example.practicamultimedia

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class AudioAcivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var btnPlay: ImageButton
    private lateinit var btnStop: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio_acivity)
        btnPlay = findViewById(R.id.btnPlay)
        btnStop = findViewById(R.id.btnStop)
        mediaPlayer = MediaPlayer.create(this, R.raw.audio)
        btnPlay.setOnClickListener{
            if (!mediaPlayer.isPlaying){
                mediaPlayer.start()
            }

        }
        btnStop.setOnClickListener{
            if (mediaPlayer.isPlaying){
                mediaPlayer.pause()
                mediaPlayer.seekTo(0)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer.release()
    }
}