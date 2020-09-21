package com.example.loginapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loginapp.R
import kotlinx.android.synthetic.main.fragment_display_details.*

class DisplayDetailsFragment : Fragment() {

    private lateinit var name : String
    private lateinit var phone : String
    private lateinit var age : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        name = requireArguments().getString("name").toString()
        phone = requireArguments().getString("phone").toString()
        age = requireArguments().getString("age").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        userName.text = name
        userPhone.text = phone
        userAge.text = age
    }

}