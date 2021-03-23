package android.studio.treshure.main.beranda.setoran

import android.os.Bundle
import android.studio.treshure.R
import android.studio.treshure.main.beranda.Tips.TipsAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_beranda.view.*
import kotlinx.android.synthetic.main.fragment_harga.view.*

class SetoranFragment : Fragment() {
    val lists = arrayListOf<SetoranModel>()

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
        view.rvSetoran.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            adapter = SetoranAdapter(lists)
        }
    }

    fun initData(view: View){
        lists.add(SetoranModel("1",
            activity?.let { ContextCompat.getDrawable(it,R.drawable.ic_garbage) },"Trashbag ID 1304A327FA","24 / 04 / 2019"))
        lists.add(SetoranModel("2",
            activity?.let { ContextCompat.getDrawable(it,R.drawable.ic_garbage) },"Trashbag ID 1304A327FA","19 / 04 / 2019"))
        lists.add(SetoranModel("3",
            activity?.let { ContextCompat.getDrawable(it,R.drawable.ic_garbage) },"Trashbag ID 1304A327FA","15 / 04 / 2019"))
        lists.add(SetoranModel("4",
            activity?.let { ContextCompat.getDrawable(it,R.drawable.ic_garbage) },"Trashbag ID 1304A327FA","10 / 04 / 2019"))

        view.rvSetoran.adapter?.notifyDataSetChanged()
    }
}