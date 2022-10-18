package com.example.mediaplayer.media

import com.example.mediaplayer.R

object MediaProvider {
    val mediaList = listOf(
        Media(
            "AUDIO",
            "Bad Bunny",
            "Bichiyal",
            R.raw.audio_bichiyal,
            image = R.drawable.img_yhlqmdlg,
            ),
        Media(
            "AUDIO",
            "Ryan Castro",
            "Jordan",
            R.raw.audio_jordan,
            image = R.drawable.img_jordan
        ),
        Media(
            "AUDIO",
            "Bad Bunny",
            "La Difícil",
            R.raw.audio_ladificil,
            image = R.drawable.img_yhlqmdlg
        ),
        Media(
            "AUDIO",
            "Miyagi",
            "Minor",
            R.raw.audio_minor,
            image = R.drawable.img_minor
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
        )
    )
}
