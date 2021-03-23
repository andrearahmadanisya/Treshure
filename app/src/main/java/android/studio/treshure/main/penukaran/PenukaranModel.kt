package android.studio.treshure.main.penukaran

import android.graphics.drawable.Drawable

data class PenukaranModel(
    val id: String,
    val images: Any,
    val title: String,
    val icon: Drawable?,
    var isExpand : Boolean = false
)