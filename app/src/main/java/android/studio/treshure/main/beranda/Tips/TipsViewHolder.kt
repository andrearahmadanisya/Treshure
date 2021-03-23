package android.studio.treshure.main.beranda.Tips

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.studio.treshure.main.beranda.TipsDetailActivity
import android.view.View
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_tips.view.*

class TipsViewHolder(val view: View, val context: Context) : RecyclerView.ViewHolder(view) {
    fun onBind(item : TipsModel){
        view.tvSubItemBannerListTitle.text = item.title
        view.ivSubItemBannerList.setImageDrawable(item.images)

//        view.setOnClickListener {
//            Intent.makeText(context, "Item "+item.title+" Has Been Clicked", Toast.LENGTH_SHORT).show()
//        }

        view.ivSubItemBannerList.setOnClickListener {
            (context as Activity).startActivity(Intent(context!!, TipsDetailActivity::class.java))
        }
    }
}