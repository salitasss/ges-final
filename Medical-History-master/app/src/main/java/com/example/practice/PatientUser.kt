package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent


import android.view.View
import android.widget.*

import java.util.ArrayList

class PatientUser : AppCompatActivity() {
    private var button: Button? = null
    private var activeUser: Patient? = null
    private var welcome: TextView? = null
    private var book: Button? = null
    private var appointment: Button? = null
    private var services: ArrayList<DataBaseService>? = null
    private var users: ArrayList<DataBaseUser>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById<View>(R.id.signoutButton) as Button
        book = findViewById<View>(R.id.appointmentBtn) as Button
        appointment = findViewById<View>(R.id.bookButton) as Button
        val i = intent
        activeUser = i.getSerializableExtra("user") as Patient?
        services = i.getSerializableExtra("services") as ArrayList<DataBaseService>?
        users = i.getSerializableExtra("users") as ArrayList<DataBaseUser>?
        button!!.setOnClickListener { openActivity(MainActivity::class.java) }


        welcome = findViewById<View>(R.id.welcomeText) as TextView
        activeUser = i.getSerializableExtra("user") as Patient?
        welcome!!.text = "Welcome " + activeUser!!._username + " you are logged in as patient."
    }

    fun openActivity(activity: Class<*>?) {
        val intent = Intent(this, activity)
        intent.putExtra("user", activeUser)
        intent.putExtra("users", users)
        intent.putExtra("services", services)
        startActivity(intent)
    }
}