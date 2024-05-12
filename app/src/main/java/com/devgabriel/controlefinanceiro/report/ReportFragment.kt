package com.devgabriel.controlefinanceiro.report

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devgabriel.controlefinanceiro.databinding.FragmentReportBinding

class ReportFragment : Fragment() {
    private lateinit var binding: FragmentReportBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReportBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val sharedPreferences = requireContext().getSharedPreferences("Usuario",
            Context.MODE_PRIVATE
        )
        val username = sharedPreferences.getString("username", "-------")

        binding.usenameTitle.text = username
    }
}