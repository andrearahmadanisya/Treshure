package android.studio.treshure.main.harga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.studio.treshure.R
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_harga.view.*

class HargaFragment : Fragment() {
    val lists = arrayListOf<HargaModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_harga, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView(view)
        initData(view)
    }

    fun initRecyclerView(view: View){
        view.rvHarga.apply {
            layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
            adapter = HargaAdapter(lists)
        }
    }

    fun initData(view: View){
        lists.add(HargaModel("1",
            activity?.let { ContextCompat.getDrawable(it,R.drawable.img_harga_plastik) },"Rp3.500","Sampah Plastik"))
        lists.add(HargaModel("2",
            activity?.let { ContextCompat.getDrawable(it,R.drawable.img_harga_kaleng) },"Rp5.000","Sampah Kaleng"))
        lists.add(HargaModel("3",
            activity?.let { ContextCompat.getDrawable(it,R.drawable.img_harga_kardus) },"Rp4.000","Sampah Kardus"))

        view.rvHarga.adapter?.notifyDataSetChanged()
    }
}