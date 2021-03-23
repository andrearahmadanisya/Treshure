package android.studio.treshure.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.studio.treshure.R
import android.studio.treshure.main.MainActivity
import android.studio.treshure.regist.RegistActivity
import android.studio.treshure.splashscreen.SplashActivity
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.inputEmail
import kotlinx.android.synthetic.main.activity_regist.*


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()
            if (email.isEmpty()|| password.isEmpty()) {
                Toast.makeText(this, "Please Insert Email and Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            startActivity(Intent(this, MainActivity::class.java))

        }

        btnRegister.setOnClickListener{
            startActivity(Intent(this, RegistActivity::class.java))
        }
    }

    fun doLogin(email : String, password : String){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
            .addOnCompleteListener{

                if (!it.isSuccessful){ return@addOnCompleteListener
                    val intent = Intent (this, LoginActivity::class.java)
                    startActivity(intent)
                }
                else
                    Toast.makeText(this, "Succesfully Login", Toast.LENGTH_SHORT).show()
                val intent = Intent (this, MainActivity::class.java) //sementara
                startActivity(intent)
            }
            .addOnFailureListener{
                Log.d("Main", "Failed Login: ${it.message}")
                Toast.makeText(this, "Email/Password incorrect", Toast.LENGTH_SHORT).show()
            }

    }

    companion object {
        fun startActivity(context: Context){
            context.startActivity(Intent(context,LoginActivity::class.java))
        }
    }
}