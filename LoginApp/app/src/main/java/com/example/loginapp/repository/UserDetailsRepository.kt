package com.example.loginapp.repository

import com.example.loginapp.entity.UserDetails
import com.example.loginapp.localDb.RealmUserDetailsOperation

class UserDetailsRepository {

    fun writeUserDetails(
        email : String,
        password : String,
        name : String,
        phone : String,
        age : String
    ) {
        RealmUserDetailsOperation.writeUserDetailsToRealm(email, password, name, phone, age)
    }

    fun readUserDetails(email : String, password: String) : UserDetails? {
        return RealmUserDetailsOperation.readUserDetailsFromRealm(email, password)
    }

    fun closeRealm() {
        RealmUserDetailsOperation.closeRealmInstance()
    }

}