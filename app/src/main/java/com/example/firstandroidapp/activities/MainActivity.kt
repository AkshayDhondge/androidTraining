package com.example.firstandroidapp.activities

import android.annotation.SuppressLint
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

    //Variable in kotlin
    private var Counter: Int = 0

    //List in kotlin
    private val arrayInt = arrayListOf<Int>()

    private lateinit var sampelObject: sampleClass

    @SuppressLint("LongLogTag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Object of sample class (Java class)
        sampelObject = sampleClass()

        //extension for circle class
        fun Circle.perimeter(): Double{
            return 2*Math.PI*radius;
        }
        val newCircle = Circle(2.5);
        println("Area of the circle is ${newCircle.area()}")
        println("Perimeter of the circle is ${newCircle.perimeter()}")

        email = findViewById(R.id.editTextEmail)
        password = findViewById(R.id.editTextPassword)
        loginButton = findViewById(R.id.btnLogin)

        //calling inner class functions
        val demo = Outer().Inner()
        Log.d("This is my inner class example", "$demo");

        loginButton.setOnClickListener {
            emailId = email.text.toString()
            passwordString = password.text.toString()

            Log.i("Main activity", emailId)
            Log.i("Main activity", passwordString)

            val validated = loginValidations(emailId, passwordString)
            if (validated) {
                showToast("Success")
            }

            forLoopInKotlin()
            exceptionHandlingCode()
            listExample()


            val demo = Outer().Inner()
            Log.d("This is my inner class example", "${demo.foo()}");


        }

        //Higher order function calling
        func("BeginnersBook", ::demo)

    }

    //Higher order function definition.
    private fun func(str: String, myfunc: (String) -> Unit) {
        print("Welcome to Kotlin tutorial at ")
        myfunc(str)
    }

    private fun demo(str: String) {
        println(str)
    }

    //Function in kotlin
    private fun loginValidations(email: String, pass: String): Boolean {
        if (email == "") {
            showToast("Please enter Email id")
            return false
        } else if (pass == "") {
            showToast("Please enter Password")
            return false
        } else
//            if (!isEmailValid(email)) {
//            showToast("Enter valid Email id")
//            return false
//        }
            //Calling java code from kotlin
            if (!sampelObject.isValidEmailInJava(email)) {
                showToast("Enter valid Email id using java")
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
        Log.d("this is my array", "$arrayInt");

    }

    private fun exceptionHandlingCode() {
        try {
            var num = 10 / 0
            println("BeginnersBook.com")
            println(num)
        } catch (e: ArithmeticException) {
            println("Arithmetic Exception")
        }
    }

    private fun listExample(){
        //immutable list
        val list = mutableListOf(2, 3, 5, 6, 7)
        list[2] = 100
        println(list)

        //Mutable list
        val mutableList = mutableListOf(2, 3, 5, 6, 7)
        mutableList[2] = 100 // works now
        println(mutableList[2]) // 100
        mutableList.add(index = 3, element = 500)
        println(mutableList[3]) // 500
        mutableList.remove(7)
        println(mutableList) // [2, 3, 100, 500, 6]
        mutableList.removeAt(0)
        println(mutableList) // [3, 100, 500, 6]

    }

}

class Outer {
    private val bar: Int = 1

    inner class Inner {
        fun foo() = bar
    }
}

class Circle (val radius: Double){
    // member function of class
    fun area(): Double{
        return Math.PI * radius * radius;
    }
}
