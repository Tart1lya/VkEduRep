package com.example.myapplication.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppsListViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(AppsListUiState())
    val uiState: StateFlow<AppsListUiState> = _uiState.asStateFlow()

    private val _snackbarEvent = MutableStateFlow<String?>(null)
    val snackbarEvent: StateFlow<String?> = _snackbarEvent.asStateFlow()

    init {
        loadApps()
    }

    private fun loadApps() {
        viewModelScope.launch {
            _uiState.value = AppsListUiState(
                apps = AppsListData.SAMPLE_APPS,
                isLoading = false
            )
        }
    }

    fun onLogoClick() {
        viewModelScope.launch {
            _snackbarEvent.value = "RuStore - лучший магазин приложений!"
        }
    }

    fun onSnackbarShown() {
        viewModelScope.launch {
            _snackbarEvent.value = null
        }
    }
}

data class AppsListUiState(
    val apps: List<com.example.myapplication.data.App> = emptyList(),
    val isLoading: Boolean = true
)