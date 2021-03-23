package android.studio.treshure.main.penukaran

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.studio.treshure.R
import android.studio.treshure.main.beranda.PenukaranFragment
import android.studio.treshure.main.harga.HargaModel
import android.studio.treshure.main.penukaran.price_list.PriceListActivity
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_penukaran.view.*

class PenukaranViewHolder (val view: View, val context: Context, val fragment: PenukaranFragment) : RecyclerView.ViewHolder(view){
    fun onBind(item : PenukaranModel){
        view.tvPenukaran.text = item.title
        if(item.images is Int)
            view.ivPenukaran.setImageResource(item.images)
        else if(item.images is Drawable){
            view.ivPenukaran.setImageDrawable(item.images)
        }
        checkExpandItem(item)

        view.setOnClickListener {
//            Toast.makeText(context, "Item "+item.title+" Has Been Clicked", Toast.LENGTH_SHORT).show()
            item.isExpand = !item.isExpand
            checkExpandItem(item)
        }

        view.etPenukaranvalue.setOnClickListener {
            val intent = Intent(context, PriceListActivity::class.java)
            fragment.startActivityForResult(intent, 100)
        }

    }

    fun checkExpandItem(item:PenukaranModel){
        if(item.isExpand){
            view.clDetailPenukaran.visibility = View.VISIBLE
            view.ivMore.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_penukaranup))
        }else {
            view.ivMore.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_iconmore))
            view.clDetailPenukaran.visibility = View.GONE
        }
    }
}

