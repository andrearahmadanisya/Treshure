package android.studio.treshure.menu.notif

import android.studio.treshure.menu.notif.lainnya.NotifLainnyaFragment
import android.studio.treshure.menu.notif.transaksi.NotifTransaksiFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    private val page = listOf(
        NotifTransaksiFragment(),
        NotifLainnyaFragment()
    )

    override fun getItem(position: Int): Fragment {
        return page[position]
    }

    override fun getCount(): Int {
        return page.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Transaksi"
            else -> "Lainnya"
        }
    }
}