package android.studio.treshure.main.beranda.setoran

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_setoran.view.*

class SetoranViewHolder(val view: View, val context: Context) : RecyclerView.ViewHolder(view) {
    fun onBind(item : SetoranModel){
        view.tvitempulsanotif.text = item.title
        view.tvitemtanggalnotif.text = item.Date
        view.ibnotifpulsa.setImageDrawable(item.icon)

        view.setOnClickListener {
            Toast.makeText(context, "Item "+item.title+" Has Been Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}