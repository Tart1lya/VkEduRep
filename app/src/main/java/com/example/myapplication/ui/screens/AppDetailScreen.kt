package com.example.myapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.myapplication.data.AppDetails
import com.example.myapplication.data.AppDetailsState
import com.example.myapplication.ui.components.AppDetailsContent

@Composable
fun AppDetailScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        AppDetailsContent(
            content = AppDetailsState.Content(
                appDetails = AppDetails(
                    id = "1",
                    name = "Гильдия Героев: Экшен ММО РПГ",
                    developer = "VK Play",
                    category = com.example.myapplication.data.Category.GAME,
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
            ),
            onBackClick = onBackClick,
            onShareClick = {},
            onInstallClick = {},
            onReadMoreClick = {},
            onDeveloperClick = {}
        )
    }
}
