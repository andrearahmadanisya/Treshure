package android.studio.treshure.main.beranda.Tips

import android.content.Intent
import android.os.Bundle
import android.studio.treshure.R
import android.studio.treshure.main.beranda.TipsDetailActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_beranda.view.*
import kotlinx.android.synthetic.main.item_tips.view.*

class TipsFragment : Fragment() {
    val lists = arrayListOf<TipsModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beranda, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView(view)
        initData(view)


    }

    fun initRecyclerView(view: View) {
        view.rvTips.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = TipsAdapter(lists)
        }
    }

    fun initData(view: View){
        lists.add(TipsModel("1",
            activity?.let { ContextCompat.getDrawable(it,R.drawable.img_tips1) },"Cara Memilah Sampah yang Baik"))
        lists.add(TipsModel("2",
            activity?.let { ContextCompat.getDrawable(it,R.drawable.img_tips2) },"Cara Menggunakan Trashbag ID"))
        lists.add(TipsModel("3",
            activity?.let { ContextCompat.getDrawable(it,R.drawable.img_tips3) },"Cara Membuang Sampah Mantan"))

        view.rvTips.adapter?.notifyDataSetChanged()
    }

}