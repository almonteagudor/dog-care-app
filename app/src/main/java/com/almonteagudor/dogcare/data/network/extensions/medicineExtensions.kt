package com.almonteagudor.dogcare.data.network.extensions

import com.almonteagudor.dogcare.data.network.dto.MedicineDto
import com.almonteagudor.dogcare.domain.model.Medicine

fun MedicineDto.toDomain(): Medicine {
    return Medicine(
        id = this.id,
        name = this.name,
        description = this.description,
    )
}