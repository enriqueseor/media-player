package com.example.mediaplayer.media

import com.example.mediaplayer.R

object MediaProvider {
    val mediaList = listOf(
        Media(
            "AUDIO",
            "ROSALIA, The Weeknd",
            "LA FAMA",
            R.raw.audio_lafama,
            image = R.drawable.img_lafama,
            ),
        Media(
            "AUDIO",
            "Alejo, Feid, ROBI",
            "Pantysito",
            R.raw.audio_pantysito,
            image = R.drawable.img_pantysito
        ),
        Media(
            "AUDIO",
            "Jhay Cortéz",
            "Sensual bebé",
            R.raw.audio_sensualbebe,
            image = R.drawable.img_sensualbebe
        ),
        Media(
            "VIDEO",
            "Omar Monter, Kevin Roldan",
            "Bésame",
            R.raw.video_besame,
            image = R.drawable.img_besame
        ),
        Media(
            "VIDEO",
            "La Pantera, Quevedo, Juseph",
            "Cayó la noche [Remix]",
            R.raw.video_cayolanoche,
            image = R.drawable.img_cayolanoche
        ),
        Media(
            "VIDEO",
            "Jey Blessing, Rauw Alejandro",
            "Suave - Remix",
            R.raw.video_suaveremix,
            image = R.drawable.img_suaveremix
        )
    )
}
