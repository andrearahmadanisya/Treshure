package android.studio.treshure.main.harga

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_harga.view.*

class HargaViewHolder(val view: View, val context: Context) : RecyclerView.ViewHolder(view) {
    fun onBind(item : HargaModel){
        view.tvItemHargaTitle.text = item.title
        view.tvItemHargaValue.text = item.value
        view.ivItemHarga.setImageDrawable(item.images)

//        Picasso.get()
//            .load(item.images)
//            .into(view.ivItemHarga)

        view.setOnClickListener {
            Toast.makeText(context, "Item "+item.title+" Has Been Clicked",Toast.LENGTH_SHORT).show()
        }
    }
}