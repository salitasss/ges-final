package com.example.practice

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference
import java.lang.Exception

// Firebase imports
abstract class User : Person {
    var role: String? = null
        private set

    constructor(name: String?, username: String?, password: String?) {
        this.name = name
        this.username = username
        this.password = password
        role = ""
        id = ""
        init()
    }

    constructor(username: String?, password: String?) {
        this.username = username
        this.password = password
        name = null
        id = ""
        init()
    }

    private fun init() {
        try {
            databaseUsers = FirebaseDatabase.getInstance().getReference("users")
        } catch (e: Exception) {
        }
    }

    fun addRole(role: String?) {
        this.role = role
    }

    fun save(): Boolean {
        if (name != null && username != null && password != null && role != null) {
            val id = databaseUsers!!.push().key // get unique database key
            val DB = DataBaseUser(id, name, username, password, role)
            this.id = id
            databaseUsers!!.child(id!!).setValue(DB) // save in database
            return true
        }
        return false
    }

    override fun login(): Boolean {
        return false
    }

    companion object {
        private var databaseUsers: DatabaseReference? = null
    }
}