package com.example.mediaplayer

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.VideoView

class VideoPlayerActivity : AppCompatActivity() {

    private var mediaPlayerv: VideoView? = null
    private lateinit var myvideoUri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videoplayer)

        val song: Int? = intent.extras?.getInt("song")

        myvideoUri = Uri.parse("android.resource://com.example.mediaplayer/$song")
        mediaPlayerv = findViewById(R.id.vvMedia)
        mediaPlayerv?.setVideoURI(myvideoUri)

        btnPlayVideo()
        btnPauseVideo()
        btnStopVideo()
    }

    private fun btnPlayVideo(){
        val button: ImageButton = findViewById(R.id.fab_play)
        button.setOnClickListener {
            mediaPlayerv?.start()
        }
    }

    private fun btnPauseVideo(){
        val button: ImageButton = findViewById(R.id.fab_pause)
        button.setOnClickListener {
            mediaPlayerv?.pause()
        }
    }

    private fun btnStopVideo(){
        val button: ImageButton = findViewById(R.id.fab_stop)
        button.setOnClickListener {
            mediaPlayerv?.setVideoURI(myvideoUri)
        }
    }
}
