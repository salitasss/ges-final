package com.example.practice

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.util.Patterns
import android.view.View

import android.widget.*
import com.example.practice.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

//import org.joda.time.Minutes
import java.util.ArrayList

class SignInActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySignInBinding


    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var loginBtn: Button

    var users: ArrayList<DataBaseUser?>? = null
    var services: ArrayList<DataBaseService?>? = null
    private var activeUser: Person? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)

        setContentView(binding.root)
        auth = Firebase.auth

        val currentUser = auth.currentUser
        if(currentUser != null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this@SignInActivity.finish()
        }


        loginBtn = binding.signInButton
        //val button3 = findViewById<Button>(R.id.BackButton)
        //button1.setOnClickListener(this)
        //button3.setOnClickListener(this)
        email = binding.usernameField2
        password = binding.passwordField2
        progressBar = binding.progressBar
        //users = ArrayList()
        //services = ArrayList()
        //updateUsers()
        //updateServices()
        loginBtn.setOnClickListener {
            if(!isValidForm()) return@setOnClickListener

            loginBtn.visibility = View.GONE
            progressBar.visibility = View.VISIBLE

            login(email.text.toString(), password.text.toString())
        }

        binding.signUpTextView.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun login(email: String, password: String) {

        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                Log.d("Login", "signInWithEmail:success")
                val user = auth.currentUser
                val intent = Intent(this, PatientIntroActivity::class.java)
                startActivity(intent)
                this@SignInActivity.finish()
            }
            .addOnFailureListener {
                loginBtn.visibility = View.VISIBLE
                progressBar.visibility = View.GONE

                Toast.makeText(baseContext, ""+it.message,
                    Toast.LENGTH_SHORT).show()
            }
    }

    /*fun updateUsers() {
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
    }*/

    /*fun updateServices() {
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
    }*/

    /*override fun onClick(v: View) {
        when (v.id) {
            R.id.signInButton -> if (validateForm()) {
                if (activeUser is Patient) {
                    openPatient()
                }
            }
            R.id.BackButton -> openMain()
        }
    }*/
/*
    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(this.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
*/
    private fun isValidForm(): Boolean {

        var isValid = true


        email.apply {
            val text = text.toString()
            if(text.isBlank()){
                error = "Required"
                isValid = false
            } else if (!Patterns.EMAIL_ADDRESS.matcher(text).matches()) {
                error = "Invalid email"
                isValid = false
            }

        }

        password.apply {
            val text = text.toString()
            if(text.isBlank()){
                error = "Required"
                isValid = false
            }
        }

        return isValid
    }

    /*fun openPatient() {
        val intent = Intent(this, PatientUserActivity::class.java)
        intent.putExtra("user", activeUser)
        intent.putExtra("users", users)
        intent.putExtra("services", services)
        startActivity(intent)
    }*/


    /*fun openMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("user", activeUser)
        startActivity(intent)
    }*/

    companion object {
        //private val databaseUsers = FirebaseDatabase.getInstance().getReference("users")
        //private val databaseServices = FirebaseDatabase.getInstance().getReference("services")
    }
}