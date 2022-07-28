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
import java.util.ArrayList
import java.util.HashSet

class SignUp : AppCompatActivity(), View.OnClickListener {
    private var usernamesUsed: HashSet<String?>? = null
    private var users: ArrayList<DataBaseUser?>? = null
    private var services: ArrayList<DataBaseService?>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val button1 = findViewById<Button>(R.id.createButton)
        val button2 = findViewById<Button>(R.id.backButton)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        usernamesUsed = HashSet()
        users = ArrayList()
        services = ArrayList()
        updateUsers()
        updateServices()
    }

    fun updateUsers() {
        databaseUsers.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                users!!.clear()
                for (postSnapshot in dataSnapshot.children) {
                    val usr = postSnapshot.getValue(DataBaseUser::class.java)
                    val add = users!!.add(usr)
                   // usernamesUsed!!.add(usr.getUsername())
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
        val rb1: RadioButton
        val rb2: RadioButton
        rb1 = findViewById(R.id.EmployeeRB)
        rb2 = findViewById(R.id.PatientRB)
        when (v.id) {
            R.id.createButton -> if (validateForm()) {

            }
            R.id.backButton -> openMain()
        }
    }

    private fun validateForm(): Boolean {
        val name = findViewById<View>(R.id.addressField2) as EditText
        val username = findViewById<View>(R.id.usernameField2) as EditText
        val password = findViewById<View>(R.id.passwordField2) as EditText
        val userName = username.text.toString()
        val Password = password.text.toString()
        val Name = name.text.toString()
        if (userName == "" || Password == "" || Name == "") {
            Toast.makeText(applicationContext, "Invalid Form", Toast.LENGTH_LONG).show()
            return false
        }

        // validate password
        if (Password.length < 5) {
            Toast.makeText(
                applicationContext,
                "Password Must Have Minimum 5 Characters",
                Toast.LENGTH_LONG
            ).show()
            return false
        }
        if (Password.contains(" ")) {
            Toast.makeText(applicationContext, "Password Cannot Contain Spaces", Toast.LENGTH_LONG)
                .show()
            return false
        }

        // make sure username is alphanumeric
        for (c in userName.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                Toast.makeText(
                    applicationContext,
                    "Username Must Be Alphanumeric",
                    Toast.LENGTH_LONG
                ).show()
                return false
            }
        }
        return true
    }

    fun openPatient() {
        val name = findViewById<View>(R.id.addressField2) as EditText
        val username = findViewById<View>(R.id.usernameField2) as EditText
        val password = findViewById<View>(R.id.passwordField2) as EditText
        val userName = username.text.toString()
        val Password = password.text.toString()
        val Name = name.text.toString()
        updateUsers()
        val newPatient = Patient(name =Name,username = userName,password= Password)
        if (!usernamesUsed!!.contains(userName)) {  // tries to save user in database
            if (newPatient.save()) {
                name.setText("")
                password.setText("")
                username.setText("")
                Toast.makeText(applicationContext, "Account Created", Toast.LENGTH_LONG).show()
                val intent = Intent(this, PatientUser::class.java)
               // intent.putExtra("user", newPatient)
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "Error Creating An Account", Toast.LENGTH_LONG)
                    .show()
            }
        } else {  // if user account already exists
            Toast.makeText(applicationContext, "Username Already Exists", Toast.LENGTH_LONG).show()
        }
    }



    fun openMain() {
        val name = findViewById<View>(R.id.addressField2) as EditText
        val username = findViewById<View>(R.id.usernameField2) as EditText
        val password = findViewById<View>(R.id.passwordField2) as EditText
        name.setText("")
        password.setText("")
        username.setText("")
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    companion object {
        private val databaseUsers = FirebaseDatabase.getInstance().getReference("users")
        private val databaseServices = FirebaseDatabase.getInstance().getReference("services")
    }
}