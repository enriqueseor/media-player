package cat.teknos.mediaplayer.media

data class Media(
    val mediaType:String,
    val singerName:String,
    val songName:String,
    val song: Int,
    val image: Int?,
)