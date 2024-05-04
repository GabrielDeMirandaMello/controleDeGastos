package com.devgabriel.controlefinanceiro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devgabriel.controlefinanceiro.databinding.ActivityHomeBinding
import com.devgabriel.controlefinanceiro.databinding.CustomBottomSheetBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SheetBottomCustom: AppCompatActivity() {

    private lateinit var binding: CustomBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CustomBottomSheetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdicionarDespesa.setOnClickListener {
            addDespesa()
        }
    }

    private fun addDespesa() {

    }
}