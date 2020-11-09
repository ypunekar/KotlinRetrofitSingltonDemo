package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var text:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        text=findViewById(R.id.textView)

        viewModel.user.observe(this, Observer { user ->
            println("DEBUG: $user")
            text.setText("${user.email},\n ${user.username}, \n${user.image}")
        })

        viewModel.setUserId("1")

        //println("DEBUG: ExampleSingleton: ${ExampleSingleton}")
    }


    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJobs()
    }
}































