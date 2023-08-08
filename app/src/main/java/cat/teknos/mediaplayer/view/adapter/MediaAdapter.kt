package cat.teknos.mediaplayer.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cat.teknos.mediaplayer.R
import cat.teknos.mediaplayer.data.model.Media

class MediaAdapter(private val mediaList:List<Media>, private val onClickListener:(Media) -> Unit) : RecyclerView.Adapter<MediaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MediaViewHolder(layoutInflater.inflate(R.layout.item_media, parent, false))
    }

    override fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
        val item = mediaList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = mediaList.size
}