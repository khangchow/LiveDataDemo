package com.chow.livedatablog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.chow.livedatablog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var yourViewModel: YourViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //get YourViewModel from ViewModelProvider
        yourViewModel = ViewModelProvider(this)[YourViewModel::class.java]

        binding.apply {
            //Set up LiveData observer
            yourViewModel.data.observe(this@MainActivity) {
                //Update your UI here with new value
                tvName.text = "Hello $it!"
            }

            btnUpdate.setOnClickListener {
                yourViewModel.getUsername(etName.text.toString())
            }
        }
    }
}