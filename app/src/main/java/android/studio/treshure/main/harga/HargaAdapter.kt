package android.studio.treshure.main.harga

import android.studio.treshure.R
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HargaAdapter(val lists : List<HargaModel>) : RecyclerView.Adapter<HargaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HargaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_harga,parent,false)
        return HargaViewHolder(view, parent.context)
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: HargaViewHolder, position: Int) {
        holder.onBind(lists[position])
    }
}