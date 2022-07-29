package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent


import android.widget.*
import com.example.practice.databinding.ActivityPatientBinding
import com.google.firebase.auth.FirebaseAuth

import java.util.ArrayList

class PatientIntroActivity : AppCompatActivity() {

    lateinit var binding: ActivityPatientBinding

    private lateinit var button: Button
    private var activeUser: Patient? = null
    private lateinit var welcome: TextView
    private var book: Button? = null
    private var appointment: Button? = null
    private var services: ArrayList<DataBaseService>? = null
    private var users: ArrayList<DataBaseUser>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPatientBinding.inflate(layoutInflater)

        setContentView(binding.root)

        button = binding.getStartedButton
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this@PatientIntroActivity.finish()
        }
        //book = findViewById<View>(R.id.appointmentBtn) as Button
        //appointment = findViewById<View>(R.id.bookButton) as Button
        //val i = intent
        //activeUser = i.getSerializableExtra("user") as Patient?
        //services = i.getSerializableExtra("services") as ArrayList<DataBaseService>?
        //users = i.getSerializableExtra("users") as ArrayList<DataBaseUser>?
        //button!!.setOnClickListener { openActivity(MainActivity::class.java) }


        //welcome = findViewById<View>(R.id.welcomeText) as TextView
        //activeUser = i.getSerializableExtra("user") as Patient?
        welcome = binding.welcomeText
        val email = FirebaseAuth.getInstance().currentUser?.email!!
        welcome.text = "Bienvenido " + email + " usted se ah registrado en nuestro aplicativo exitosamente"
    }

    /*fun openActivity(activity: Class<*>?) {
        val intent = Intent(this, activity)
        intent.putExtra("user", activeUser)
        intent.putExtra("users", users)
        intent.putExtra("services", services)
        startActivity(intent)
    }*/
}