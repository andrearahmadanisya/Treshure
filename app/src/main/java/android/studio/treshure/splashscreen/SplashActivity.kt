package android.studio.treshure.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.studio.treshure.R
import android.studio.treshure.login.LoginActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.core.os.HandlerCompat.postDelayed

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            LoginActivity.startActivity(this)
            finish()
        },2000)
    }
}