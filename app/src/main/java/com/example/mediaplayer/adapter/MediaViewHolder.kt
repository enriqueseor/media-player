package com.example.mediaplayer.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mediaplayer.databinding.ItemMediaBinding
import com.example.mediaplayer.media.Media

class MediaViewHolder(view:View):RecyclerView.ViewHolder(view) {

    private val binding = ItemMediaBinding.bind(view)

    fun render(mediaModel: Media, onClickListener:(Media) -> Unit){
        binding.tvMediaType.text = mediaModel.mediaType
        binding.tvSingerName.text = mediaModel.singerName
        binding.tvSongName.text = mediaModel.songName
        Glide.with(binding.ivMedia.context).load(mediaModel.image).into(binding.ivMedia)
        itemView.setOnClickListener{onClickListener(mediaModel)}
    }
}