package com.example.loginapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.loginapp.R
import kotlinx.android.synthetic.main.fragment_new_user_login_details.*

class NewUserLoginDetailsFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var signUpViewModel: SignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        signUpViewModel = ViewModelProvider(requireActivity()).get(SignUpViewModel::class.java)
        return inflater.inflate(R.layout.fragment_new_user_login_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
        setGoToDetailsButtonListener()
    }

    private val goToPasswordFragmentListener = View.OnClickListener {
        val userEnteredEmail : String = enterEmail.text.toString()
        val userEnteredPassword : String = enterPassword.text.toString()

        if (!userEnteredEmail.endsWith(".com", false)) {
            enterEmail.error = resources.getString(R.string.email_error)
        } else if (userEnteredPassword == "") {
            enterPassword.error = resources.getString(R.string.password_error)
        } else {
            signUpViewModel.setUserEmail(userEnteredEmail)
            signUpViewModel.setUserPassword(userEnteredPassword)
            navController.navigate(R.id.action_newUserLoginDetailsFragment_to_detailsFragment)
        }
    }

    private fun setGoToDetailsButtonListener() {
        goToDetails.setOnClickListener(goToPasswordFragmentListener)
    }
}