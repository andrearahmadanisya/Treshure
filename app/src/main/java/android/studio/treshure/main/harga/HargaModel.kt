package android.studio.treshure.main.harga

import android.graphics.drawable.Drawable

data class HargaModel(
    val id: String,
    val images: Drawable?,
    val value: String,
    val title: String
)