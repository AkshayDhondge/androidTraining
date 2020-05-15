package com.example.firstandroidapp.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firstandroidapp.R
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var loginButton: Button
    private lateinit var emailId: String
    private lateinit var passwordString: String
    private var Counter: Int = 0

    private val arrayInt = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.editTextEmail)
        password = findViewById(R.id.editTextPassword)
        loginButton = findViewById(R.id.btnLogin)



        loginButton.setOnClickListener { it: View? ->
            emailId = email.text.toString()
            passwordString = password.text.toString()

            Log.i("Main activity", emailId)
            Log.i("Main activity", passwordString)

            val validated = loginValidations(emailId, passwordString)
            if (validated) {
                showToast("Success")
            }
            forLoopInKotlin()
        }
    }


    private fun loginValidations(email: String, pass: String): Boolean {
        if (email == "") {
            showToast("Please enter Email id")
            return false
        } else if (pass == "") {
            showToast("Please enter Password")
            return false
        } else if (!isEmailValid(email)) {
            showToast("Enter valid Email id")
            return false
        } else {
            return true
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }

    private fun showToast(Msg_string: String) {
        val toast: Toast =
            Toast.makeText(this@MainActivity, Msg_string, Toast.LENGTH_SHORT)

        toast.show()
    }
//Nullability
//    fun kotlineNullability(){
//        var s2: String? = "Geeks for Geeks"
//
//        s2 = null
//
//        println(s2.length)  //
//    }

    private fun forLoopInKotlin() {
        arrayInt.clear()
        for (ind in 0..10) {
            arrayInt.add(ind)
        }
        Log.d("this is my array", "arr: $arrayInt");

    }

}
