package android.studio.treshure.main.penukaran.price_list

import android.studio.treshure.R
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PriceListAdapter(val lists: List<PriceListModel>) :
    RecyclerView.Adapter<PriceListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PriceListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_price_pulsa, parent, false)
        return PriceListViewHolder(view, parent.context)
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: PriceListViewHolder, position: Int) {
        holder.onBind(lists[position])
    }

}