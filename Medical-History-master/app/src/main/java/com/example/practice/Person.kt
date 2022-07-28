package com.example.practice

import java.io.Serializable

abstract class Person : Serializable {
    abstract val _username: Any?
    protected var name: String? = null
    protected var username: String? = null
    protected var password: String? = null
    var id: String? = null
    fun get_name(): String? {
        return name
    }

    fun get_username(): String? {
        return username
    }

    fun get_password(): String? {
        return password
    }

    fun print() {
        println("Name: $name, Username: $username, Password: $password")
    }

    abstract fun login(): Boolean
}