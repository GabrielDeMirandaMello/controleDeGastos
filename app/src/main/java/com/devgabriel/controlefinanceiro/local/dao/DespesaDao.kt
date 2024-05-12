package com.devgabriel.controlefinanceiro.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devgabriel.controlefinanceiro.local.entity.Despesa
import kotlinx.coroutines.flow.Flow

@Dao
interface DespesaDao {

    @Query("SELECT * FROM despesa")
    fun getAllDespesas(): Flow<List<Despesa>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertDespesa(despesa: Despesa): Long

    @Delete
    fun deleteDespesa(despesa: Despesa): Long
}