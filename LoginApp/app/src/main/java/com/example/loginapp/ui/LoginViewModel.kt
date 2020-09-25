package com.example.loginapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loginapp.localDb.UserDetails
import com.example.loginapp.repository.UserDetailsRepository

class LoginViewModel : ViewModel() {
    private val mUserName : MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val userName : LiveData<String> by lazy { mUserName }
    private val mUserPhone : MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val userPhone : LiveData<String> by lazy { mUserPhone }
    private val mUserAge : MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val userAge : LiveData<String> by lazy { mUserAge }

    fun readFromDatabase(email : String, password : String) : UserDetails? {
        val userDetailsRepository = UserDetailsRepository()
        val userDetails = userDetailsRepository.readUserDetails(email, password)
        if (userDetails != null) {
            mUserName.value = userDetails.name
            mUserPhone.value = userDetails.phone
            mUserAge.value = userDetails.age
        }
        return userDetails
    }

    fun getUserName() : String {
        return userName.value as String
    }

    fun getUserPhone() : String {
        return userPhone.value as String
    }

    fun getUserAge() : String {
        return userAge.value as String
    }

}