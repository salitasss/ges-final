package com.example.practice

import com.google.firebase.database.FirebaseDatabase
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.content.Intent

import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError

import android.view.View
import android.widget.*

//import org.joda.time.Minutes
import java.util.ArrayList

class SignIn : AppCompatActivity(), View.OnClickListener {
    var username: EditText? = null
    var password: EditText? = null
    var users: ArrayList<DataBaseUser?>? = null
    var services: ArrayList<DataBaseService?>? = null
    private var activeUser: Person? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val button1 = findViewById<Button>(R.id.signInButton)
        val button3 = findViewById<Button>(R.id.BackButton)
        button1.setOnClickListener(this)
        button3.setOnClickListener(this)
        username = findViewById<View>(R.id.usernameField2) as EditText
        password = findViewById<View>(R.id.passwordField2) as EditText
        users = ArrayList()
        services = ArrayList()
        updateUsers()
        updateServices()
    }

    fun updateUsers() {
        databaseUsers.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                users!!.clear() // might need to remove
                for (postSnapshot in dataSnapshot.children) {
                    val usr = postSnapshot.getValue(DataBaseUser::class.java)
                    users!!.add(usr)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }

    fun updateServices() {
        databaseServices.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                services!!.clear() // might need to remove
                for (postSnapshot in dataSnapshot.children) {
                    val service = postSnapshot.getValue(
                        DataBaseService::class.java
                    )
                    services!!.add(service)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.signInButton -> if (validateForm()) {
                if (activeUser is Patient) {
                    openPatient()
                }
            }
            R.id.BackButton -> openMain()
        }
    }
/*
    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(this.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
*/
    fun validateForm(): Boolean {
        val userName = username!!.text.toString()
        val Password = password!!.text.toString()
        //updateUsers();
        if (userName == "" || Password == "") {
            Toast.makeText(applicationContext, "Invalid Form", Toast.LENGTH_LONG).show()
            return false
        } else {
            for (usr in users!!) {
                val otherUsername = username
                val pwd = password


                    if (pwd==password) {
                        // successful login
                        Toast.makeText(applicationContext, "Logged In", Toast.LENGTH_LONG).show()
                        return true
                    } else {
                        Toast.makeText(applicationContext, "Incorrect password", Toast.LENGTH_LONG)
                            .show()
                    }

            }
        }
        Toast.makeText(applicationContext, "Invalid Login", Toast.LENGTH_LONG).show()
        return false
    }

    fun openPatient() {
        val intent = Intent(this, PatientUser::class.java)
        intent.putExtra("user", activeUser)
        intent.putExtra("users", users)
        intent.putExtra("services", services)
        startActivity(intent)
    }


    fun openMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("user", activeUser)
        startActivity(intent)
    }

    companion object {
        private val databaseUsers = FirebaseDatabase.getInstance().getReference("users")
        private val databaseServices = FirebaseDatabase.getInstance().getReference("services")
    }
}