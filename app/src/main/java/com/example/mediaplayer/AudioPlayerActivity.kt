package com.example.mediaplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class AudioPlayerActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audioplayer)

        val imageView = findViewById<View>(R.id.ivMedia) as ImageView
        val image = intent.extras?.getInt("image")
        if (image != null) {
            imageView.setImageResource(image)
        }

        val song: Int? = intent.extras?.getInt("song")
        mediaPlayer = song?.let { MediaPlayer.create(this, it) }

        btnPlayAudio()
        btnPauseAudio()
        btnStopAudio()
    }

    private fun btnPlayAudio(){
        val button: ImageButton = findViewById(R.id.fab_play)
        button.setOnClickListener {
            val song: Int? = intent.extras?.getInt("song")
            mediaPlayer = song?.let { MediaPlayer.create(this, it) }
            mediaPlayer?.start()
        }
    }

    private fun btnPauseAudio(){
        val button: ImageButton = findViewById(R.id.fab_pause)
        button.setOnClickListener {
            mediaPlayer?.pause()
        }
    }

    private fun btnStopAudio(){
        val button: ImageButton = findViewById(R.id.fab_stop)
        button.setOnClickListener {
            mediaPlayer?.stop()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.stop()
    }
}
