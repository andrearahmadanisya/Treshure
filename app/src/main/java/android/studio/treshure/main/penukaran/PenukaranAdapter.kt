package android.studio.treshure.main.penukaran

import android.studio.treshure.R
import android.studio.treshure.main.beranda.PenukaranFragment
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PenukaranAdapter(val lists: List<PenukaranModel>, val fragment: PenukaranFragment) :
    RecyclerView.Adapter<PenukaranViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PenukaranViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_penukaran, parent, false)
        return PenukaranViewHolder(view, parent.context, fragment)
    }
    override fun getItemCount(): Int {
        return lists.size
    }
    override fun onBindViewHolder(holder: PenukaranViewHolder, position: Int) {
        holder.onBind(lists[position])
    }

}