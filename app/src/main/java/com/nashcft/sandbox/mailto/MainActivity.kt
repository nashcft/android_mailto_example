package com.nashcft.sandbox.mailto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nashcft.sandbox.mailto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
