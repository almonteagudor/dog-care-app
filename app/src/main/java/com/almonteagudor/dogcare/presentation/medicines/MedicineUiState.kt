package com.almonteagudor.dogcare.presentation.medicines

import com.almonteagudor.dogcare.domain.model.Medicine

data class MedicineUiState(
    val isLoading: Boolean = false,
    val medicines: List<Medicine> = emptyList(),
    val error: String? = null
)
