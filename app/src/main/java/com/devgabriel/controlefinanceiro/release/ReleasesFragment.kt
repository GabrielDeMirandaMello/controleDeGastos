package com.devgabriel.controlefinanceiro.release

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.devgabriel.controlefinanceiro.DataSource
import com.devgabriel.controlefinanceiro.DespesaAdapter
import com.devgabriel.controlefinanceiro.databinding.FragmentReleasesBinding
import com.devgabriel.controlefinanceiro.local.models.Despesa
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

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

        var db = Firebase.firestore

        db.collection("despesas").get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d("TAG", "DocumentSnapshot data: ${document.documents.size}")
                } else {
                    Log.d("TAG", "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("TAG", "get failed with ", exception)
            }

        DespesaAdapter.updateData(dataSource)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val sharedPreferences = requireContext().getSharedPreferences("Usuario", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("username", "-------")

        binding.usenameTitle.text = username
    }

}