package com.example.loginapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.loginapp.R
import kotlinx.android.synthetic.main.fragment_new_user_login_details.*

class NewUserLoginDetailsFragment : Fragment() {

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_user_login_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
        goToDetails.setOnClickListener(goToPasswordFragmentListener)
    }

    private val goToPasswordFragmentListener = View.OnClickListener {
        val userEnteredEmail : String = enterEmail.text.toString()
        val userEnteredPassword : String = enterPassword.text.toString()

        if (!userEnteredEmail.endsWith(".com", false)) {
            enterEmail.error = "Invalid Email."
        } else if (userEnteredPassword == "") {
            enterPassword.error = "Password too weak."
        } else {
            val bundle: Bundle = bundleOf("email" to userEnteredEmail, "password" to userEnteredPassword)
            navController.navigate(R.id.action_newUserLoginDetailsFragment_to_detailsFragment, bundle)
        }
    }
}