package com.almonteagudor.dogcare.data.repository

import com.almonteagudor.dogcare.data.network.MedicineApiService
import com.almonteagudor.dogcare.data.network.extensions.toDomain
import com.almonteagudor.dogcare.domain.extensions.toDto
import com.almonteagudor.dogcare.domain.model.Medicine
import com.almonteagudor.dogcare.domain.repository.MedicineRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MedicineRepositoryImpl @Inject constructor(
    private val apiService: MedicineApiService
) : MedicineRepository {

    override fun getMedicines(): Flow<List<Medicine>> = flow {
        val medicines = apiService.getMedicines().map { it.toDomain() }
        emit(medicines)
    }

    override suspend fun addMedicine(medicine: Medicine) {
        val medicineDto = medicine.toDto()
        apiService.addMedicine(medicineDto.id, medicineDto)
    }
}