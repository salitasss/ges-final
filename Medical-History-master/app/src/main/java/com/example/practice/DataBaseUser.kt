package com.example.practice

import java.io.Serializable
import java.util.ArrayList

/**
 * Used strictly for saving user data to the database
 */
class DataBaseUser : Serializable {


    var name: String? = null
    var username: String? = null
    var password: String? = null
    var id: String? = null
    var role: String? = null



    constructor(id: String?, name: String?, username: String?, password: String?, role: String?) {
        this.name = name
        this.username = username
        this.password = password
        this.role = role
        this.id = id
    }

    constructor(id: String?, username: String?, password: String?, role: String?) {
        this.username = username
        this.password = password
        this.role = role
        this.id = id
    }

    constructor(id: String?, username: String?, password: String?) {
        this.username = username
        this.password = password
        role = "Admin"
        this.id = id
    }

    @JvmName("getUsername1")
    fun getUsername(): String? {
        return username
    }

    fun getPasswordname(): String? {
        return password
    }
    constructor() {}
}