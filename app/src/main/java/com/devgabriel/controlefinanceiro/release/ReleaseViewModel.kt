package com.devgabriel.controlefinanceiro.release

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import com.devgabriel.controlefinanceiro.local.usecase.DeleteDespesaUsecase
import com.devgabriel.controlefinanceiro.local.usecase.GetAllDespesasUsecase
import com.devgabriel.controlefinanceiro.local.usecase.InsertDespesaUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ReleaseViewModel @Inject constructor(
    private val deleteDespesaUsecase: DeleteDespesaUsecase,
    private val getAllDespesasUsecase: GetAllDespesasUsecase,
    private val insertDespesaUsecase: InsertDespesaUsecase
): ViewModel() {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getAll() {
        //Pegar todos os
    }
}