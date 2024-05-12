package com.devgabriel.controlefinanceiro.local.repository

import com.devgabriel.controlefinanceiro.local.dao.DespesaDao
import com.devgabriel.controlefinanceiro.local.entity.Despesa
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DespesaRepositoryImpl @Inject constructor(
    private val despesaDao: DespesaDao
) {


    fun getAllDespesas(): Flow<List<Despesa>> {
        return despesaDao.getAllDespesas()
    }


    fun insertDespesa(despesa: Despesa): Long {
        return despesaDao.insertDespesa(despesa)
    }


    fun deleteDespesa(despesa: Despesa): Long {
        return despesaDao.deleteDespesa(despesa)
    }
}