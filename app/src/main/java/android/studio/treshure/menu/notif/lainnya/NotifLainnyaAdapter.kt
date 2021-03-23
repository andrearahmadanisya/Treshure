package android.studio.treshure.menu.notif.lainnya

import android.studio.treshure.R
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NotifLainnyaAdapter(val lists : List<NotifLainnyaModel>) : RecyclerView.Adapter<NotifLainnyaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotifLainnyaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_notifikasi_transaksi,parent,false)
        return NotifLainnyaViewHolder(view, parent.context)
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: NotifLainnyaViewHolder, position: Int) {
        holder.onBind(lists[position])
    }
}