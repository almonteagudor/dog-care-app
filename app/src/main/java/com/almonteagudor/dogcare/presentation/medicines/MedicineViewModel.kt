package com.almonteagudor.dogcare.presentation.medicines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.almonteagudor.dogcare.domain.repository.MedicineRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MedicineViewModel @Inject constructor(
    private val repository: MedicineRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(MedicineUiState(isLoading = true))
    val uiState: StateFlow<MedicineUiState> = _uiState

    init {
        viewModelScope.launch {
            repository.getMedicines()
                .onStart {
                    _uiState.value = MedicineUiState(isLoading = true)
                }
                .catch { exception ->
                    _uiState.value = MedicineUiState(isLoading = false, error = exception.message)
                }
                .collect { medicines ->
                    _uiState.value = MedicineUiState(isLoading = false, medicines = medicines)
                }
        }
    }
}