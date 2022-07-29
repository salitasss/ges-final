package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View

import android.widget.*
import com.example.practice.databinding.ActivitySignUpBinding
import com.example.practice.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import java.util.ArrayList
import java.util.HashSet

class SignUpActivity : AppCompatActivity() {
    private var usernamesUsed: HashSet<String?>? = null
    private var users: ArrayList<DataBaseUser?>? = null
    private var services: ArrayList<DataBaseService?>? = null

    private lateinit var auth: FirebaseAuth

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var name: EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var createBtn: Button

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)

        setContentView(binding.root)

        auth = Firebase.auth

        binding.alreadyTextView.setOnClickListener {
            this@SignUpActivity.finish()
        }

        name = binding.nameField2
        email = binding.emailField2
        password = binding.passwordField2

        progressBar = binding.progressBar

        createBtn = binding.createButton
        createBtn.setOnClickListener {

            if(!isValidForm()) return@setOnClickListener

            createBtn.visibility = View.GONE
            progressBar.visibility = View.VISIBLE

            val userN = User(name = name.text.toString(), email = email.text.toString(), role = "patient", timestamp = ServerValue.TIMESTAMP, status = "A")
            register(userN, password = password.text.toString())
        }
        /*val button1 = findViewById<Button>(R.id.createButton)
        val button2 = findViewById<Button>(R.id.backButton)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)*/
        /*usernamesUsed = HashSet()
        users = ArrayList()
        services = ArrayList()
        updateUsers()
        updateServices()*/
    }

    private fun register(userN: User, password: String) {

        auth.createUserWithEmailAndPassword(userN.email!!, password)
            .addOnSuccessListener { userAuth ->
                Toast.makeText(applicationContext, "User registered", Toast.LENGTH_SHORT).show()
                FirebaseDatabase.getInstance().getReference("users").child(userAuth.user?.uid.toString()).setValue(userN).addOnSuccessListener {
                    this@SignUpActivity.finish()
                }
                    .addOnFailureListener {
                        createBtn.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(applicationContext, "Error: ${it.message}", Toast.LENGTH_SHORT).show()
                    }

            }
            .addOnFailureListener {
                Toast.makeText(applicationContext, "Error: ${it.message}", Toast.LENGTH_SHORT).show()
                createBtn.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
            }


    }

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
            } else if (text.length < 6) {
                error = "Min 6 characters"
                isValid = false
            }
        }

        name.apply {
            val text = text.toString()
            if(text.isBlank()){
                error = "Required"
                isValid = false
            }
        }

        return isValid
    }

    /*fun updateUsers() {
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
                val intent = Intent(this, PatientUserActivity::class.java)
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
    }*/
}