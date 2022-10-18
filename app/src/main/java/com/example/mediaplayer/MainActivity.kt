package com.example.mediaplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mediaplayer.adapter.MediaAdapter
import com.example.mediaplayer.databinding.ActivityMainBinding
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
                onItemSelected(
                    media
                )
            }
        binding.recyclerMediaPlayer.addItemDecoration(decoration)
    }

    private fun onItemSelected(media: Media){
        Toast.makeText(this, media.songName, Toast.LENGTH_SHORT).show()
        val intent = Intent(this@MainActivity, AudioPlayerActivity::class.java)
        intent.putExtra("song" , media.song)
        intent.putExtra("image", media.image)
        startActivity(intent)
    }
}
