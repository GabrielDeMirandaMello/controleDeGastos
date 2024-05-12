package com.devgabriel.controlefinanceiro

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.devgabriel.controlefinanceiro.databinding.CardDespesaBinding
import com.devgabriel.controlefinanceiro.databinding.FragmentReleasesBinding
import com.devgabriel.controlefinanceiro.local.models.Despesa

class DespesaAdapter(
    private val context: Context,
    private var despesas: List<Despesa>
) : RecyclerView.Adapter<DespesaAdapter.DespesaViewHolder>() {

    private var items: List<Despesa> = ArrayList()

    class DespesaViewHolder constructor(private val binding: CardDespesaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val nameDespesa = binding.nameLancamento
        val valorDespesa = binding.valorLancamento
        val dataDespesa = binding.dataLancamento
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DespesaViewHolder {
        val binding = CardDespesaBinding.inflate(LayoutInflater.from(context), parent, false)
        return DespesaViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: DespesaViewHolder, position: Int) {
        val currentDespesa = items[position]

        holder.nameDespesa.text = currentDespesa.nome
        holder.valorDespesa.text = currentDespesa.valor
        holder.dataDespesa.text = currentDespesa.data
    }

    fun updateData(despesas: List<Despesa>){
        items = despesas
        notifyDataSetChanged()
    }

}