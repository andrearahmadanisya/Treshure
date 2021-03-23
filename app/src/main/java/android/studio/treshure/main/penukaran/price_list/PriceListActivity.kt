package android.studio.treshure.main.penukaran.price_list

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.studio.treshure.R
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_price_list.*

class PriceListActivity : AppCompatActivity() {
    val mList = arrayListOf<PriceListModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_price_list)

        rvPricepulsa.apply {
            adapter = PriceListAdapter(mList)
            layoutManager = LinearLayoutManager(this@PriceListActivity)
        }

        mList.add(PriceListModel("a"))
        mList.add(PriceListModel("b"))
        mList.add(PriceListModel("c"))
        mList.add(PriceListModel("d"))

    }

    fun onItemClicked(data: PriceListModel) {
        val resultIntent = Intent()
        resultIntent.putExtra("data", data)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }

    fun onCloseClicked(){
        val resultIntent = Intent()
        setResult(Activity.RESULT_CANCELED,resultIntent)
        finish()
    }
}