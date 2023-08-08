package cat.teknos.mediaplayer.data

import cat.teknos.mediaplayer.R
import cat.teknos.mediaplayer.data.model.Media

object MediaProvider {
    val mediaList = listOf(
        Media(
            "Sharlene, Lalo Ebratt",
            "El Vecino",
            R.raw.audio_elvecino,
            image = R.drawable.img_elvecino
        ),
        Media(
            "Bad Bunny",
            "Bichiyal",
            R.raw.audio_bichiyal,
            image = R.drawable.img_yhlqmdlg,
            ),
        Media(
            "Ryan Castro",
            "Jordan",
            R.raw.audio_jordan,
            image = R.drawable.img_jordan
        ),
        Media(
            "Bad Bunny",
            "La Difícil",
            R.raw.audio_ladificil,
            image = R.drawable.img_yhlqmdlg
        ),
        Media(
            "Miyagi",
            "Minor",
            R.raw.audio_minor,
            image = R.drawable.img_minor
        ),
        Media(
            "Alejo, Feid, ROBI",
            "Pantysito",
            R.raw.audio_pantysito,
            image = R.drawable.img_pantysito
        ),
        Media(
            "Jhay Cortéz",
            "Sensual bebé",
            R.raw.audio_sensualbebe,
            image = R.drawable.img_sensualbebe
        ),
        Media(
            "ROSALÍA",
            "DESPECHÁ",
            R.raw.audio_despecha,
            image = R.drawable.img_despecha
        )
    )
}