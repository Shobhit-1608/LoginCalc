package com.example.afinal

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.afinal.R
import com.example.afinal.bleh
import com.example.afinal.calculator
import java.util.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var username = findViewById<EditText>(R.id.username)
        var password = findViewById<EditText>(R.id.password)


        var loginBtn = findViewById<Button>(R.id.btnLogIn)
        loginBtn.setOnClickListener {
            val uname = username.text
            val pwd = password.text

            if(uname.toString().equals("student") && pwd.toString().equals("moneytap")){
                val intent = Intent(this, bleh::class.java)
                startActivity(intent)}
            else {
                Toast.makeText(this, "wrong Login",Toast.LENGTH_SHORT).show()
            }
        }
        var mBtn = findViewById<Button>(R.id.changelang)
        mBtn.setOnClickListener{

            showChangeLanguage()
        }
    }

    private fun showChangeLanguage() {
        val listofitems = arrayOf("English","हिंदी","മലയാളം","தமிழ்")

        val langbuilder = AlertDialog.Builder(this)
        langbuilder.setTitle("Change the Language")
        langbuilder.setSingleChoiceItems(listofitems,-1){dialog, which->
            if(which == 1){
                setLocate("hi")
                recreate()
            } else if (which == 2){
                setLocate("ml")
                recreate()
            }else if(which == 3){
                setLocate("ta")
                recreate()
            }else if(which == 0){
                setLocate("")
                recreate()
            }

            dialog.dismiss()
        }
        val maindialog = langbuilder.create()
        maindialog.show()

    }

    private fun setLocate(Lang: String) {
        val locale = Locale(Lang)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale=locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
        val editor = getSharedPreferences("settings", Context.MODE_PRIVATE).edit()
        editor.putString("My_Language", Lang)
        editor.apply()

    }

    private fun xyz(){
        val sharedPreferences = getSharedPreferences("settings",Activity.MODE_PRIVATE)
        val language : String? = sharedPreferences.getString("My_Language", "")
        if (language != null) {
            setLocate(language)
        }
    }

    fun onDecimalPoint(view: View) {}
    fun onEqual(view: View) {}

}

