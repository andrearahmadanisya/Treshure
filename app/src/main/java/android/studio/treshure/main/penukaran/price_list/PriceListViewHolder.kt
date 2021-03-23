package android.studio.treshure.main.penukaran.price_list

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.studio.treshure.R
import android.studio.treshure.main.penukaran.PenukaranModel
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_penukaran.view.*

class PriceListViewHolder (val view: View, val context: Context) : RecyclerView.ViewHolder(view){
    fun onBind(item : PriceListModel){
        // TODO: 12/26/2020
        view.setOnClickListener {
            (context as PriceListActivity).onItemClicked(item)
        }
    }
}