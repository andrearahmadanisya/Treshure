package android.studio.treshure.main.beranda

//import com.github.mikephil.charting.data.BarData
//import com.github.mikephil.charting.data.BarDataSet
//import com.github.mikephil.charting.data.BarEntry
import android.content.Intent
import android.os.Bundle
import android.studio.treshure.R
import android.studio.treshure.main.beranda.Tips.TipsAdapter
import android.studio.treshure.main.beranda.Tips.TipsModel
import android.studio.treshure.main.beranda.setoran.SetoranAdapter
import android.studio.treshure.main.beranda.setoran.SetoranModel
import android.studio.treshure.main.profile.ProfileActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlinx.android.synthetic.main.fragment_beranda.view.*
import kotlinx.android.synthetic.main.fragment_harga.view.*
import kotlinx.android.synthetic.main.fragment_profile.view.*
import kotlinx.android.synthetic.main.item_tips.view.*

class BerandaFragment : Fragment() {
    val Tlists = arrayListOf<TipsModel>()
    val Slists = arrayListOf<SetoranModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beranda, container, false)

//      setBarChart()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBarChart(view)

        initRecyclerViewTips(view)
        initDataTips(view)

        initRecyclerViewSetoran(view)
        initDataSetoran(view)
//
//        view.ivSubItemBannerList.setOnClickListener {
//            startActivity(Intent(context!!, TipsDetailActivity::class.java))
//        }

    }

    private fun setBarChart(view: View) {
        val entries = arrayListOf<BarEntry>()
        entries.add(BarEntry(8f, 1f))
        entries.add(BarEntry(2f, 5f))
        entries.add(BarEntry(5f, 10f))
        entries.add(BarEntry(20f, 20f))
        entries.add(BarEntry(15f, 30f))
        entries.add(BarEntry(19f, 50f))

        val barDataSet = BarDataSet(entries, "Cells")

        val labels = ArrayList<String>()
        labels.add("Minggu")
        labels.add("Bulan")
        labels.add("Tahun")
        val data = BarData(barDataSet)
        view.barchart.data = data // set the data and list of lables into chart

        barDataSet.color = resources.getColor(R.color.barchart)

        view.barchart.animateY(5000)
    }

        //recycle Tips
    fun initRecyclerViewTips(view: View) {
            view.rvTips.apply {
                layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                adapter = TipsAdapter(Tlists)
            }
        }

    fun initDataTips(view: View){
        Tlists.add(
            TipsModel("1",
            activity?.let { ContextCompat.getDrawable(it,R.drawable.img_tips1) },"Cara Memilah Sampah yang Baik")
        )
        Tlists.add(
            TipsModel("2",
            activity?.let { ContextCompat.getDrawable(it,R.drawable.img_tips2) },"Cara Menggunakan Trashbag ID")
        )
        Tlists.add(
            TipsModel("3",
            activity?.let { ContextCompat.getDrawable(it,R.drawable.img_tips3) },"Cara Membuang Sampah Mantan")
        )

        view.rvTips.adapter?.notifyDataSetChanged()
    }

    //Recycle Setoran
    fun initRecyclerViewSetoran(view: View) {
        view.rvSetoran.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            adapter = SetoranAdapter(Slists)
        }
    }

    fun initDataSetoran(view: View){
        Slists.add(SetoranModel("1",
            activity?.let { ContextCompat.getDrawable(it,R.drawable.ic_garbage) },"Trashbag ID 1304A327FA","24 / 04 / 2019"))
        Slists.add(SetoranModel("2",
            activity?.let { ContextCompat.getDrawable(it,R.drawable.ic_garbage) },"Trashbag ID 1304A327FA","19 / 04 / 2019"))
        Slists.add(SetoranModel("3",
            activity?.let { ContextCompat.getDrawable(it,R.drawable.ic_garbage) },"Trashbag ID 1304A327FA","15 / 04 / 2019"))
        Slists.add(SetoranModel("4",
            activity?.let { ContextCompat.getDrawable(it,R.drawable.ic_garbage) },"Trashbag ID 1304A327FA","10 / 04 / 2019"))

        view.rvSetoran.adapter?.notifyDataSetChanged()
    }
}