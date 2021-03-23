package android.studio.treshure.regist

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.studio.treshure.R
import android.studio.treshure.login.LoginActivity
import android.studio.treshure.main.MainActivity
import android.telephony.SmsManager
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login_verification.*
import kotlinx.android.synthetic.main.activity_regist.*
import java.util.regex.Pattern

class RegistActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regist)
        val str_verify_code : String

        btnregist.setOnClickListener() {
            val name = registname.text.toString()
            val email = registemail.text.toString()
            val number = Integer.valueOf(registnumber.text.toString())
            val password = registpass.text.toString()
            val int_random_number = 0
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please Complete your data", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
//            else {
//                val string_random = Integer.toString(int_random_number)
//                showAddVerifyCode()
//                Toast.makeText(
//                    this@RegistActivity,
//                    "Confirmation Code: $string_random",
//                    Toast.LENGTH_LONG
//                ).show()
//            }
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    fun doregist(nama : String, email : String, nomor : Int, password : String){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
            .addOnCompleteListener{

                if (!it.isSuccessful){ return@addOnCompleteListener
                    val intent = Intent (this, RegistActivity::class.java)
                    startActivity(intent)
                }
                else
                    Toast.makeText(this, "Succesfully Login", Toast.LENGTH_SHORT).show()
                val intent = Intent (this, LoginActivity::class.java) //sementara
                startActivity(intent)
            }
            .addOnFailureListener{
                Log.d("Main", "Failed Login: ${it.message}")
                Toast.makeText(this, "Email/Password incorrect", Toast.LENGTH_SHORT).show()
            }
    }

//    private fun showAddVerifyCode() {
//        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this@RegistActivity)
//        alertDialog.setTitle("Verify your phone number")
//        alertDialog.setMessage("Please fill the verification code")
//        var int_random_number = edtVerifyCode.text.length
//        val inflater = this.layoutInflater
//        val add_menu_layout: View =
//            inflater.inflate(R.layout.activity_login_verification, null)
//        val edtVerifyCode = add_menu_layout.findViewById<EditText>(R.id.edtVerifyCode)
//        val btn_verify =
//            add_menu_layout.findViewById<Button>(R.id.btn_verify)
//        var str_verify_code : String
//        var sms : SmsManager
//        val number = registnumber.text.toString()
//        Handler().postDelayed({
//            LoginActivity.startActivity(this)
//            finish()
//        },2000)
//
//        btn_verify.setOnClickListener {
//            val string_random = Integer.toString(int_random_number)
//            str_verify_code = edtVerifyCode.text.toString()
//            if (str_verify_code.isEmpty()) {
//                Toast.makeText(
//                    this@RegistActivity,
//                    "Verify code must be filled",
//                    Toast.LENGTH_SHORT
//                ).show()
//            } else if (str_verify_code == string_random == false) {
//                Toast.makeText(
//                    this@RegistActivity,
//                    "Verify code must be the same with the confirmation code from SMS. ",
//                    Toast.LENGTH_SHORT
//                ).show()
//            } else {
////                val UsersID: String = databaseHelper.new_user_id()
//                sms = SmsManager.getDefault()
//                sms.sendTextMessage(
//                    "Fanbase SM", number
//                    , "Confirmation Code: $str_verify_code", null, null
//                )
////                databaseHelper.insertDataUser(
////                    UsersID,
////                    str_username,
////                    str_password,
////                    str_email,
////                    str_address,
////                    str_phone_number
////                )
//                Toast.makeText(this@RegistActivity, "Registration Success", Toast.LENGTH_SHORT)
//                    .show()
//                val i = Intent(this@RegistActivity, LoginActivity::class.java)
//                startActivity(i)
//                finish()
//            }
//        }
//        alertDialog.setView(add_menu_layout)
//        alertDialog.show()
//    }
}