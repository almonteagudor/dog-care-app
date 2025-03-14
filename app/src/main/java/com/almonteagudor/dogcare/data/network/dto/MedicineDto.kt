package com.almonteagudor.dogcare.data.network.dto

import com.google.gson.annotations.SerializedName

data class MedicineDto(
    @SerializedName("medicine_id") val id: String,
    @SerializedName("medicine_name") val name: String,
    @SerializedName("medicine_description") val description: String,
)