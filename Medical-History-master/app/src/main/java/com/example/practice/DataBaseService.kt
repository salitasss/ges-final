package com.example.practice


import java.io.Serializable

/**
 * Used strictly for saving user data to the database
 */
class DataBaseService : Serializable {
    var name: String? = null

    var id: String? = null




    constructor(id: String?, name: String?) {
        this.name = name

        this.id = id
    }

    fun print() {
        println("Name: " + name + ", ID: " + id)
    }

    constructor() {}
}