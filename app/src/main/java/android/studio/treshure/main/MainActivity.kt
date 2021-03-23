package android.studio.treshure.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.studio.treshure.R
import android.studio.treshure.main.beranda.BerandaFragment
import android.studio.treshure.main.beranda.PenukaranFragment
import android.studio.treshure.main.harga.HargaFragment
import android.studio.treshure.main.profile.ProfileFragment
import android.studio.treshure.main.scan.ScanFragment
import android.studio.treshure.menu.notif.NotifTabActivity
import android.studio.treshure.menu.setting.PengaturanActivity
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_pengaturan.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar()

        loadfragment(BerandaFragment())
        bnvMain.setOnNavigationItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu);
        return true
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        tvToolbarTitle.text = "trashure"
    }
    //    manggil notif
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuNotif ->{
                val intent = Intent(this,NotifTabActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menuSetting ->{
                val intent = Intent(this, PengaturanActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    fun loadfragment(fragment: Fragment?) : Boolean{
        if (fragment != null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameMain,fragment)
                .commit()
            return true
        }
        return false
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        var fragment : Fragment? = when(p0.itemId){
            R.id.menuHome -> {
                tvToolbarTitle.text = "Trashure"
                BerandaFragment()
            }
            R.id.homepenukaran -> {
                tvToolbarTitle.text = "Penukaran"
                PenukaranFragment()
            }
            R.id.homescan -> {
                tvToolbarTitle.text = "Scan"
                ScanFragment()
            }
            R.id.homeharga -> {
                tvToolbarTitle.text = "Harga"
                HargaFragment()
            }
            R.id.homeakun -> {
                tvToolbarTitle.text = "Akun"
                ProfileFragment()
            }

            R.id.menuSetting -> {
                tvToolbarTitle.text = "Penukaran"
                ProfileFragment()
            }
            else -> null
        }
        return loadfragment(fragment)
    }
}