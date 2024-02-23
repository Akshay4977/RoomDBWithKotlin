package com.example.roomwithkotlin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var userTextView: EditText
    lateinit var passTextView: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.login_button)
        userTextView = findViewById(R.id.user_text_view)
        passTextView = findViewById(R.id.pass_text_view)
        button.setOnClickListener {

            if (userTextView.text.isNotEmpty() && passTextView.text.isNotEmpty()) {
                Log.e("inside", "valid creds")
            } else {
                Log.e("inside", "invalid creds")
            }
            //Log.e("inside","-->"+ Temp().a())
        }

        setupActionBarWithNavController(findNavController(R.id.fragment))
    }

}