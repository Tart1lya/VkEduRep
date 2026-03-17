package com.example.myapplication.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.AppDetails
import com.example.myapplication.data.AppDetailsState
import com.example.myapplication.data.Category
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppDetailViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<AppDetailsState>(
        AppDetailsState.Content(
            appDetails = AppDetails(
                id = "1",
                name = "Гильдия Героев: Экшен ММО РПГ",
                developer = "VK Play",
                category = Category.GAME,
                ageRating = 12,
                size = 223.7f,
                screenshotUrlList = listOf(
                    "https://via.placeholder.com/300x500.png?text=Screen+1",
                    "https://via.placeholder.com/300x500.png?text=Screen+2",
                    "https://via.placeholder.com/300x500.png?text=Screen+3"
                ),
                iconUrl = "https://via.placeholder.com/150.png?text=Icon",
                description = "Легендарный рейд героев в Фэнтези РПГ. Станьте героем гильдии и поразите мастера подземелья!"
            ),
            descriptionCollapsed = false
        )
    )
    val uiState: StateFlow<AppDetailsState> = _uiState.asStateFlow()

    fun onReadMoreClick() {
        viewModelScope.launch {
            val currentState = _uiState.value
            if (currentState is AppDetailsState.Content) {
                _uiState.value = currentState.copy(
                    descriptionCollapsed = !currentState.descriptionCollapsed
                )
            }
        }
    }

    fun onInstallClick() { }
    fun onDeveloperClick() { }
    fun onShareClick() { }
}