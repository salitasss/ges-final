package com.example.practice

import android.widget.EditText


class Patient : User {
    constructor(name:String?, username: String?, password: String?) : super(
        name,
        username,
        password
    ) {
        super.addRole("Patient")
    }

    constructor(username: String?, password: String?) : super(username, password) {
        super.addRole("Patient")
    }

    override val _username: Any?
        get() = TODO("Not yet implemented")
}