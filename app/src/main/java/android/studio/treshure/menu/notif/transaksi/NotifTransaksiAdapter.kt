package android.studio.treshure.menu.notif.transaksi

import android.studio.treshure.R
import android.studio.treshure.main.harga.HargaViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView

class NotifTransaksiAdapter (val lists : List<NotifTransaksiModel>) : RecyclerView.Adapter<NotifTransaksiViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotifTransaksiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_notifikasi_transaksi,parent,false)
        return NotifTransaksiViewHolder(view, parent.context)
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: NotifTransaksiViewHolder, position: Int) {
        holder.onBind(lists[position])
    }
}