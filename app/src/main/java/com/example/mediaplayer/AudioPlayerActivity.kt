package com.example.mediaplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AudioPlayerActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audioplayer)

        /*SET IMAGE*/
        val imageView = findViewById<View>(R.id.ivMedia) as ImageView
        val image = intent.extras?.getInt("image")
        if (image != null) {
            imageView.setImageResource(image)
        }

        /*SET SONG NAME*/
        val textView = findViewById<View>(R.id.tvSongText) as TextView
        textView.text = buildString {
        append(intent.extras?.getString("singerName")!!)
        append(" - ")
        append(intent.extras?.getString("songName")!!)
        }

        /*SET TRACK*/
        val song: Int? = intent.extras?.getInt("song")
        mediaPlayer = song?.let { MediaPlayer.create(this, it) }

        /*SET BUTTONS*/
        btnPlayAudio()
        btnPauseAudio()
        btnStopAudio()
    }

    private fun btnPlayAudio(){
        val button: ImageButton = findViewById(R.id.fab_play)
        button.setOnClickListener {
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
            val song: Int? = intent.extras?.getInt("song")
            mediaPlayer = song?.let { MediaPlayer.create(this, it) }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mediaPlayer != null) mediaPlayer?.release()
    }
}