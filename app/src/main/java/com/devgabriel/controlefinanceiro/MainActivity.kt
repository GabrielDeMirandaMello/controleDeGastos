package com.devgabriel.controlefinanceiro

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devgabriel.controlefinanceiro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSingIn.setOnClickListener{
            addUsernameToSharedPreferences()
        }
    }
    override fun onStart() {
        super.onStart()
        val sharedPreferences = getSharedPreferences("Usuario", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("username", "")
        if (username != "") {
            redirectToRelease()
        }
    }

    private fun redirectToRelease() {
        startActivity(Intent(baseContext, HomeActivity::class.java))
    }

    private fun addUsernameToSharedPreferences() {
        val username = binding.editTextUsername.text.toString()
        val sharedPreferences = getSharedPreferences("Usuario", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("username", username)
        editor.apply()
        redirectToRelease()
    }
}