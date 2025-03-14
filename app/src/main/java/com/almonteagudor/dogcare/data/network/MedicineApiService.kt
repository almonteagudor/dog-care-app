package com.almonteagudor.dogcare.data.network

import com.almonteagudor.dogcare.data.network.dto.MedicineDto
import retrofit2.http.GET

interface MedicineApiService {
    @GET("medicines")
    suspend fun getMedicines(): List<MedicineDto>
}