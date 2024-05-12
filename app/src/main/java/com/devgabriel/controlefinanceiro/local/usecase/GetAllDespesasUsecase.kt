package com.devgabriel.controlefinanceiro.local.usecase

import com.devgabriel.controlefinanceiro.local.entity.Despesa
import com.devgabriel.controlefinanceiro.local.repository.DespesaRepositoryImpl
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllDespesasUsecase @Inject constructor(
    private val repository: DespesaRepositoryImpl
) {

    operator fun invoke(): Flow<List<Despesa>> {
        return repository.getAllDespesas()
    }

}