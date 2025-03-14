package com.almonteagudor.dogcare.domain.repository

import com.almonteagudor.dogcare.domain.model.Medicine
import kotlinx.coroutines.flow.Flow

interface MedicineRepository {
    fun getMedicines(): Flow<List<Medicine>>

    suspend fun addMedicine(medicine: Medicine)
}