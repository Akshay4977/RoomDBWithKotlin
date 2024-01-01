package com.example.roomwithkotlin.fragments.add;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomwithkotlin.R
import com.example.roomwithkotlin.models.User1
import com.example.roomwithkotlin.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        view.add_item_button.setOnClickListener {
            insertItemToDatabase()
        }
        return view
    }


    private fun insertItemToDatabase() {
        val name = name.text.toString()
        val age = age.text.toString()

        if (validate(name, age)) {

            val user = User1(
                0,
                name,
                Integer.parseInt(age)
            )
            userViewModel.addUser(user)


            Toast.makeText(requireContext(), "Added successfully", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Validation error", Toast.LENGTH_LONG).show()
        }
    }

    private fun validate(name: String, age: String): Boolean {
        return !(name.isEmpty() && age.isEmpty())
    }
}