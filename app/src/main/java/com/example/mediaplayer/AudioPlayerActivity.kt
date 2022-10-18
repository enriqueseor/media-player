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

        val song: Int? = intent.extras?.getInt("song")

        val imageView = findViewById<View>(R.id.ivMedia) as ImageView
        val image = intent.extras?.getInt("image")
        if (image != null) {
            imageView.setImageResource(image)
        }

        mediaPlayer = song?.let { MediaPlayer.create(this, it) }

        btnPlayAudio()
        btnPauseAudio()
        song?.let { btnStopAudio(it) }

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

    private fun btnStopAudio(song: Int){
        val button: ImageButton = findViewById(R.id.fab_stop)
        button.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer = song.let { MediaPlayer.create(this, it) }
        }
    }

    /*
    private fun seekBar(){
        val seekbar: SeekBar = findViewById(R.id.seekBar)

        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) mediaPlayer?.seekTo(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    private fun initialiseSeekBar(){
        val seekbar: SeekBar = findViewById(R.id.seekBar)
        seekbar.max = mediaPlayer!!.duration

        Handler(Looper.getMainLooper()).postDelayed({
            seekbar.progress = mediaPlayer!!.currentPosition

        }, 1000)
    }*/
}
