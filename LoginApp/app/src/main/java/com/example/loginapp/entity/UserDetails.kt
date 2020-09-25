package com.example.loginapp.entity

import io.realm.RealmObject

open class UserDetails(
    var email : String = "",
    var password : String = "",
    var name : String = "",
    var phone : String = "",
    var age : String = ""
) : RealmObject()