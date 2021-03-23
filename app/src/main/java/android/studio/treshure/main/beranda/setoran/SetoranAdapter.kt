package android.studio.treshure.main.beranda.setoran

import android.studio.treshure.R
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SetoranAdapter(val lists: List<SetoranModel>) : RecyclerView.Adapter<SetoranViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SetoranViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_setoran, parent, false)
        return SetoranViewHolder(view, parent.context)
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: SetoranViewHolder, position: Int) {
        holder.onBind(lists[position])
    }
}