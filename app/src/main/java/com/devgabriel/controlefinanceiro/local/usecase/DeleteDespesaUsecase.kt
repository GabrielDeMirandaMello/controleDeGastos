package com.devgabriel.controlefinanceiro.local.usecase

import com.devgabriel.controlefinanceiro.local.entity.Despesa
import com.devgabriel.controlefinanceiro.local.repository.DespesaRepositoryImpl
import javax.inject.Inject

class DeleteDespesaUsecase @Inject constructor(
    private val repository: DespesaRepositoryImpl
){

    suspend operator fun invoke(despesa: Despesa): Long{
        return repository.deleteDespesa(despesa)
    }
}