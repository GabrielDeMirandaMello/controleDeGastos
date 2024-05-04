package com.devgabriel.controlefinanceiro

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.devgabriel.controlefinanceiro.databinding.ActivityHomeBinding
import com.devgabriel.controlefinanceiro.databinding.CustomBottomSheetBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initNavigation()

        val bottomNavigation = findViewById<FloatingActionButton>(R.id.added_releases)
        bottomNavigation.setOnClickListener {
            showBottomSheetDialog()
        }
    }

    private fun initNavigation(){
        val navHotFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHotFragment.navController
        NavigationUI.setupWithNavController(binding.btnv, navController)
    }

    private fun showBottomSheetDialog() {
        val dialog = BottomSheetDialog(this, R.style.BottomSheetDialog).apply {
            window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        }

        val sheetBinding: CustomBottomSheetBinding =
            CustomBottomSheetBinding.inflate(layoutInflater, null, false)

        dialog.setContentView(sheetBinding.root)
        dialog.show()
    }
}