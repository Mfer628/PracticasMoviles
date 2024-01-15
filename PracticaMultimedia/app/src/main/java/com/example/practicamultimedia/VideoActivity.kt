package com.example.practicamultimedia

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.MediaController
import android.widget.VideoView

class VideoActivity : AppCompatActivity() {
    private lateinit var videoView: VideoView

    private lateinit var mediaController: MediaController
    private lateinit var btnPlay: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        videoView = findViewById(R.id.videoView)
        btnPlay = findViewById(R.id.btnplay)
        mediaController = MediaController(this)
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.videluis)
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(videoUri)
        videoView.requestFocus()

        btnPlay.setOnClickListener{
            if (!videoView.isPlaying){
                videoView.start()
            }
        }
    }

}