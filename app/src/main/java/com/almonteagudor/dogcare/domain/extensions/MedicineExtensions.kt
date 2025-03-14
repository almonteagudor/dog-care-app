package com.almonteagudor.dogcare.domain.extensions

import com.almonteagudor.dogcare.data.network.dto.MedicineDto
import com.almonteagudor.dogcare.domain.model.Medicine

fun Medicine.toDto(): MedicineDto {
    return MedicineDto(
        id = this.id,
        name = this.name,
        description = this.description,
    )
}