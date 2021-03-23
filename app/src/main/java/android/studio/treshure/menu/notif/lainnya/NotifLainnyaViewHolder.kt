package android.studio.treshure.menu.notif.lainnya

import android.content.Context
import android.studio.treshure.menu.notif.transaksi.NotifTransaksiModel
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_notifikasi_transaksi.view.*

class NotifLainnyaViewHolder(val view: View, val context: Context) : RecyclerView.ViewHolder(view) {
    fun onBind(item: NotifLainnyaModel){
        view.ibnotifpulsa.setImageDrawable(item.images)
        view.tvitempulsanotif.text = item.title
        view.tvitempesannotif.text = item.notiftext
        view.tvitemdatenotif.text = item.date

        view.setOnClickListener {
            Toast.makeText(context, "Item "+item.title+" Has Been Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}