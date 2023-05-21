package com.example.mediaplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Timer
import java.util.TimerTask

class AudioPlayerActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var seekBar: SeekBar

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

        /*SET SEEKBAR*/
        seekBar = findViewById(R.id.seekBar)
        setupSeekBar()

        /*SET TRACK*/
        val song: Int? = intent.extras?.getInt("song")
        mediaPlayer = song?.let { MediaPlayer.create(this, it) }!!

        // Set the maximum value for the SeekBar
        seekBar.max = mediaPlayer?.duration ?: 0

        updateSeekBarProgress()

        /*SET BUTTONS*/
        btnPlayAudio()
        btnPauseAudio()
        btnStopAudio()
    }

    private fun setupSeekBar() {
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) mediaPlayer?.seekTo(progress)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    private fun updateSeekBarProgress() {
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                try {
                    mediaPlayer?.let { player ->
                        runOnUiThread {
                            val currentPosition = player.currentPosition
                            seekBar.progress = currentPosition
                        }
                    }
                } catch (e: IllegalStateException) {
                    seekBar.progress = 0
                }
            }
        }, 0, 1000)
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
            mediaPlayer = song?.let { MediaPlayer.create(this, it) }!!
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}