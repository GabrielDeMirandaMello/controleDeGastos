package com.devgabriel.controlefinanceiro.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devgabriel.controlefinanceiro.local.dao.DespesaDao
import com.devgabriel.controlefinanceiro.local.entity.Despesa

@Database(entities = [Despesa::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun despesaDao(): DespesaDao
}