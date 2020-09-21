package com.example.loginapp.localDb

import io.realm.RealmObject

open class UserDetails(
    var email : String = "",
    var password : String = "",
    var name : String = "",
    var phone : String = "",
    var age : String = ""
) : RealmObject()