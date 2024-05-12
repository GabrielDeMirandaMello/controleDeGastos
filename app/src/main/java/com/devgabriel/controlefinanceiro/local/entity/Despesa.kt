package com.devgabriel.controlefinanceiro.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "despesa")
data class Despesa(
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    @ColumnInfo(name = "nome")
    val nome: String,

    @ColumnInfo(name = "valor")
    val valor: String,

    @ColumnInfo(name = "data")
    val data: String
)
