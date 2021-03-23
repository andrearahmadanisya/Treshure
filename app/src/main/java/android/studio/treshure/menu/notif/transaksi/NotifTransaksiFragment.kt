package android.studio.treshure.menu.notif.transaksi

import android.os.Bundle
import android.studio.treshure.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_notif_transaksi.view.*

class NotifTransaksiFragment : Fragment() {
    val lists = arrayListOf<NotifTransaksiModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notif_transaksi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.rvNotifTransaksi.apply {
            adapter = NotifTransaksiAdapter(lists)
            layoutManager = LinearLayoutManager(activity)
        }

        loadDummy(view)
    }

    private fun loadDummy(view: View) {
        lists.add(
            NotifTransaksiModel(
                ContextCompat.getDrawable(activity!!.baseContext, R.drawable.ic_penukaran_pulsa),
                "Lorem ipsum",
                "desc",
                "dd-mm-yyyy"
            )
        )

        view.rvNotifTransaksi.adapter?.notifyDataSetChanged()
    }

}