package android.studio.treshure.main.beranda.Tips

import android.studio.treshure.R
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TipsAdapter(val lists : List<TipsModel>) : RecyclerView.Adapter<TipsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tips, parent, false)
        return TipsViewHolder(view, parent.context)
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: TipsViewHolder, position: Int) {
        holder.onBind(lists[position])
    }
}