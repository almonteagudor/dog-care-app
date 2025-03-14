package com.almonteagudor.dogcare.data.network

import com.almonteagudor.dogcare.data.network.dto.MedicineDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MedicineApiService {
    @GET("medicines")
    suspend fun getMedicines(): List<MedicineDto>

    @POST("medicines/{id}")
    suspend fun addMedicine(@Path("id") id: String, @Body medicine: MedicineDto)
}