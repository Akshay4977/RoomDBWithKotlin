package com.example.roomwithkotlin.fragments.update;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.roomwithkotlin.R
import com.example.roomwithkotlin.models.User1
import com.example.roomwithkotlin.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_update, container, false)


        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        view.update_age.setText(args.currentUser.age.toString())
        view.update_name.setText(args.currentUser.name)

        view.update_item_button.setOnClickListener {
            updateItem()
        }

        view.delete_item_button.setOnClickListener {
            deleteItem()
        }
        return view
    }

    private fun updateItem() {
        val name = update_name.text.toString()
        val age = update_age.text.toString()

        if (validate(name, age)) {
            val updatedUser = User1(args.currentUser.id, name, Integer.parseInt(age))
            userViewModel.updateUser(updatedUser)

            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
            Toast.makeText(requireContext(), "Updated successfully", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(requireContext(), "Validation error", Toast.LENGTH_LONG).show()
        }
    }

    private fun deleteItem(){
        val name = update_name.text.toString()
        val age = update_age.text.toString()
        val updatedUser = User1(args.currentUser.id, name, Integer.parseInt(age))
        userViewModel.deleteUser(updatedUser)
        Toast.makeText(requireContext(), "Delete successfully", Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.action_updateFragment_to_listFragment)
    }

    private fun validate(name: String, age: String): Boolean {
        return !(name.isEmpty() && age.isEmpty())
    }
}