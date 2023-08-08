package cat.teknos.mediaplayer.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import cat.teknos.mediaplayer.databinding.ItemMediaBinding
import cat.teknos.mediaplayer.data.model.Media
import com.bumptech.glide.Glide

class MediaViewHolder(view:View):RecyclerView.ViewHolder(view) {

    private val binding = ItemMediaBinding.bind(view)

    fun render(mediaModel: Media, onClickListener:(Media) -> Unit){
        binding.tvSingerName.text = mediaModel.singerName
        binding.tvSongName.text = mediaModel.songName
        Glide.with(binding.ivMedia.context).load(mediaModel.image).into(binding.ivMedia)
        itemView.setOnClickListener{onClickListener(mediaModel)}
    }
}