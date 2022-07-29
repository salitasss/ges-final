package com.example.practice.model


data class User(
    var uid: String? = null,
    var email: String? = null,
    var role: String? = null,
    var status: String? = null,
    var timestamp: MutableMap<String, String>? = null,
    val name: String? = null,
)
