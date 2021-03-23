package android.studio.treshure.menu.notif

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.studio.treshure.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_notiftab.*
import kotlinx.android.synthetic.main.activity_main.*

class NotifTabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notiftab)

        viewpager_notif.adapter = PagerAdapter(supportFragmentManager)
        tablayoutnotif.setupWithViewPager(viewpager_notif)
    }
}