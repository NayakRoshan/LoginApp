package com.example.loginapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.loginapp.R
import com.example.loginapp.repository.UserDetailsRepository
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var emailEntered : String
    private lateinit var passwordEntered : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        emailEntered = requireArguments().getString("email").toString()
        passwordEntered = requireArguments().getString("password").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
        setAutoTextViewAdapter()
        finishSignUp.setOnClickListener(finishSignUpListener)
    }

    private val finishSignUpListener = View.OnClickListener {
        val nameEntered : String = name.text.toString()
        val phoneEntered : String = phone.text.toString()
        val ageSelected : String = age.text.toString()

        val userDetailsRepository =
            UserDetailsRepository()
        userDetailsRepository.writeUserDetails(
            emailEntered,
            passwordEntered,
            nameEntered,
            phoneEntered,
            ageSelected
        )

        navController.navigate(R.id.action_detailsFragment_to_mainFragment)
    }

    private fun setAutoTextViewAdapter() {
        val dropDownListItems : List<String> = listOf("10 to 20", "20 to 30", "30 to 40", "40 to 50", "50+")
        val adapter = ArrayAdapter(requireContext(),
            R.layout.fragment_drop_down_view, dropDownListItems)
        age.setAdapter(adapter)
    }
}