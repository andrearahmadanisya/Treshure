package android.studio.treshure.main.beranda

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.studio.treshure.R
import android.studio.treshure.main.harga.HargaModel
import android.studio.treshure.main.penukaran.PenukaranAdapter
import android.studio.treshure.main.penukaran.PenukaranModel
import android.studio.treshure.main.penukaran.price_list.PriceListModel
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_penukaran.view.*

class PenukaranFragment : Fragment() {
val lists = arrayListOf<PenukaranModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_penukaran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView(view)
        initData(view)
    }

    fun initRecyclerView(view: View) {
        view.rvPenukaran.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            adapter = PenukaranAdapter(lists, this@PenukaranFragment)
        }
    }

    fun initData(view: View) {
        lists.add(
            PenukaranModel(
                "1",
                R.drawable.ic_penukaran_pulsa_black,
                "Pulsa",
                activity?.let { ContextCompat.getDrawable(it, R.drawable.ic_iconmore) }
            )
        )
        lists.add(
            PenukaranModel(
                "2",
                R.drawable.img_penukaran_dana,
                "Dana",
                activity?.let { ContextCompat.getDrawable(it, R.drawable.ic_iconmore) }
            )
        )
        lists.add(
            PenukaranModel(
                "3",
                R.drawable.img_penukaran_linkaja,
                "LinkAja",
                activity?.let { ContextCompat.getDrawable(it, R.drawable.ic_iconmore) }
            )
        )
        view.rvPenukaran.adapter?.notifyDataSetChanged()
    }
    val CODE_PRICE_LIST = 100
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CODE_PRICE_LIST) {
            if(resultCode == Activity.RESULT_OK){
                val result = data?.getSerializableExtra("data") as PriceListModel
                Toast.makeText(activity, "kamu memilih : ${result.id}", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "kamu tidak memilih apapun", Toast.LENGTH_SHORT).show()
            }
        }
    }
}