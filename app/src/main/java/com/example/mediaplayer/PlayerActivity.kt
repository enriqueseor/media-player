package com.example.mediaplayer

import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class PlayerActivity : AppCompatActivity() {

    private var mediaPlayerv: VideoView? = null
    private lateinit var myvideoUri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        val song: Int? = intent.extras?.getInt("song")

        myvideoUri = Uri.parse("android.resource://com.example.mediaplayer/$song")
        mediaPlayerv = findViewById(R.id.videoView)
        mediaPlayerv?.setVideoURI(myvideoUri)

        btnPlayVideo()
        btnPauseVideo()
        btnStopVideo()
    }

    private fun btnPlayVideo(){
        val button: ImageButton = findViewById(R.id.fab_play)
        button.setOnClickListener {
            startVideo()
        }
    }
    private fun startVideo() {
        mediaPlayerv?.start()
    }

    private fun btnPauseVideo(){
        val button: ImageButton = findViewById(R.id.fab_pause)
        button.setOnClickListener {
            pauseVideo()
        }
    }
    private fun pauseVideo(){
        mediaPlayerv?.pause()
    }

    private fun btnStopVideo(){
        val button: ImageButton = findViewById(R.id.fab_stop)
        button.setOnClickListener {
            stopVideo()
        }
    }

    private fun stopVideo(){ mediaPlayerv?.stopPlayback()
        mediaPlayerv?.setVideoURI(myvideoUri)
    }
}
