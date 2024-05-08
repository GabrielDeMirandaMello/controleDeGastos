package com.devgabriel.controlefinanceiro

import android.content.Context
import android.graphics.Color
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.devgabriel.controlefinanceiro.databinding.ActivityHomeBinding
import com.devgabriel.controlefinanceiro.databinding.CustomBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore

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

        sheetBinding.btnAdicionarDespesa.setOnClickListener {
            addDespesa(sheetBinding)
        }
        with(dialog.behavior) {
            state = BottomSheetBehavior.STATE_EXPANDED
        }
        dialog.show()
    }
    private fun addDespesa(sheetBinding: CustomBottomSheetBinding) {
        var nome = sheetBinding.nameDespesa.text.toString()
        var valor = "R$ " + sheetBinding.valorDespesa.text.toString()
        var data = sheetBinding.dataDespesa.text.toString()


        val despesa = hashMapOf(
            "nome" to nome,
            "valor" to valor,
            "data" to data
        )
        val sharedPreferences = getSharedPreferences("Usuario", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("username", "-------")
        val db = FirebaseFirestore.getInstance()

        db.collection("despesas")
            .document(username.toString()).set(despesa)
            .addOnSuccessListener { documentReference ->
                Log.d("TAG", "Despesa adicionada com ID: ${documentReference}")
                exibirSnackBar("Despesa adicionada com sucesso")
                // Fechar a Activity atual
                finish()
            }
            .addOnFailureListener { e ->
                Log.w("TAG", e.cause.toString(), e)
                exibirSnackBar("Erro ao adicionar despesa")
            }
    }
    fun exibirSnackBar(mensagem: String) {

        Snackbar.make(
            findViewById(android.R.id.content),
            mensagem,
            Snackbar.LENGTH_SHORT
        ).show()

    }
}