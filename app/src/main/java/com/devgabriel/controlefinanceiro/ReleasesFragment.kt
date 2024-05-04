package com.devgabriel.controlefinanceiro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.devgabriel.controlefinanceiro.databinding.FragmentReleasesBinding
import com.devgabriel.controlefinanceiro.models.Despesa

class ReleasesFragment : Fragment() {
    private lateinit var binding: FragmentReleasesBinding
    private lateinit var DespesaAdapter: DespesaAdapter
    private var despesaList: List<Despesa> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentReleasesBinding.inflate(inflater, container, false)



        var recyclerView = binding.recyclerView
        val dataSource = DataSource.createDataSet()
        DespesaAdapter = DespesaAdapter(requireContext(), despesaList)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = DespesaAdapter

        DespesaAdapter.updateData(dataSource)
        return binding.root
    }


}