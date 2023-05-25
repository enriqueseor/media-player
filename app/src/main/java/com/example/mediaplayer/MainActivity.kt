package com.example.mediaplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import cat.teknos.mediaplayer.databinding.ActivityMainBinding
import com.example.mediaplayer.adapter.MediaAdapter
import com.example.mediaplayer.media.Media
import com.example.mediaplayer.media.MediaProvider

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        binding.recyclerMediaPlayer.layoutManager = manager
        binding.recyclerMediaPlayer.adapter =
            MediaAdapter(MediaProvider.mediaList) { media ->
                onItemSelected(media)
            }
        binding.recyclerMediaPlayer.addItemDecoration(decoration)
    }

    private fun onItemSelected(media: Media){
        val intent = Intent(this@MainActivity, AudioPlayerActivity::class.java)
        intent.putExtra("song" , media.song)
        intent.putExtra("image", media.image)
        intent.putExtra("singerName", media.singerName)
        intent.putExtra("songName", media.songName)
        startActivity(intent)
    }
}