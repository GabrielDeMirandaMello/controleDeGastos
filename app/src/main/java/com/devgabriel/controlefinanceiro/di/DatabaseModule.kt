package com.devgabriel.controlefinanceiro.di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.devgabriel.controlefinanceiro.R
import com.devgabriel.controlefinanceiro.local.dao.DespesaDao
import com.devgabriel.controlefinanceiro.local.db.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun providesDatabase(
        @ApplicationContext context: Context
    ): AppDataBase = Room.databaseBuilder(
        context,
        AppDataBase::class.java,
        context.getString(R.string.app_name_database)
    ).build()

    @Provides
    fun providesDespesaDao(database: AppDataBase): DespesaDao = database.despesaDao()
}