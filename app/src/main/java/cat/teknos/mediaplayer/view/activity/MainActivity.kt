package cat.teknos.mediaplayer.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import cat.teknos.mediaplayer.view.adapter.MediaAdapter
import cat.teknos.mediaplayer.databinding.ActivityMainBinding
import cat.teknos.mediaplayer.data.model.Media
import cat.teknos.mediaplayer.data.MediaProvider

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