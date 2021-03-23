package android.studio.treshure.menu.notif.transaksi

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_harga.view.*
import kotlinx.android.synthetic.main.item_notifikasi_transaksi.view.*

class NotifTransaksiViewHolder(val view: View, val context: Context) : RecyclerView.ViewHolder(view) {
    fun onBind(item : NotifTransaksiModel){
        view.ibnotifpulsa.setImageDrawable(item.images)
        view.tvitempulsanotif.text = item.title
        view.tvitempesannotif.text = item.notiftext
        view.tvitemdatenotif.text = item.date

        view.setOnClickListener {
            Toast.makeText(context, "Item "+item.title+" Has Been Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}