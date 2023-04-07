package com.example.mediaplayer.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mediaplayer.R
import com.example.mediaplayer.media.Media

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