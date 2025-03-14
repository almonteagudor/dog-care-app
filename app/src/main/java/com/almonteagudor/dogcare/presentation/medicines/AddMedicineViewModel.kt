package com.almonteagudor.dogcare.presentation.medicines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.almonteagudor.dogcare.domain.model.Medicine
import com.almonteagudor.dogcare.domain.repository.MedicineRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class AddMedicineViewModel @Inject constructor(
    private val repository: MedicineRepository
) : ViewModel() {

     fun addMedicine(
        name: String,
        description: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val newMedicine = Medicine(
                    id = UUID.randomUUID().toString(),
                    name = name,
                    description = description
                )
                repository.addMedicine(newMedicine)
                onSuccess()
            } catch (e: Exception) {
                onError(e.message ?: "Error desconocido")
            }
        }
    }
}