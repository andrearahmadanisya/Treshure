package android.studio.treshure.main.scan

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView


class ScanFragment : Fragment(), ZXingScannerView.ResultHandler  {
    lateinit var mScannerView: ZXingScannerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_scan, container, false)
        mScannerView = ZXingScannerView(activity)
        return mScannerView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TODO : do code here

    }

    override fun handleResult(rawResult: Result?) {
        Toast.makeText(
            activity, "Contents = " + rawResult!!.text.toString() +
                    ", Format = " + rawResult!!.barcodeFormat.toString(), Toast.LENGTH_SHORT
        ).show()
        // Note:
        // * Wait 2 seconds to resume the preview.
        // * On older devices continuously stopping and resuming camera preview can result in freezing the app.
        // * I don't know why this is the case but I don't have the time to figure out.
        // Note:
        // * Wait 2 seconds to resume the preview.
        // * On older devices continuously stopping and resuming camera preview can result in freezing the app.
        // * I don't know why this is the case but I don't have the time to figure out.
        val handler = Handler()
        handler.postDelayed(
            Runnable { mScannerView.resumeCameraPreview(this) },
            2000
        )
    }

    override fun onResume() {
        super.onResume()

        if (ContextCompat.checkSelfPermission(activity!!, Manifest.permission.CAMERA)
            == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(activity!!, arrayOf(Manifest.permission.CAMERA), 111)
        }

        mScannerView.setResultHandler(this)
        mScannerView.startCamera()
    }

    override fun onPause() {
        super.onPause()
        mScannerView.stopCamera()
    }
}