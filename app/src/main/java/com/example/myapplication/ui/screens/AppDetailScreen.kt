package com.example.myapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.data.AppDetailsState
import com.example.myapplication.ui.components.AppDetailsContent

@Composable
fun AppDetailScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AppDetailViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        if (uiState is AppDetailsState.Content) {
            AppDetailsContent(
                content = uiState as AppDetailsState.Content,
                onBackClick = onBackClick,
                onShareClick = viewModel::onShareClick,
                onInstallClick = viewModel::onInstallClick,
                onReadMoreClick = viewModel::onReadMoreClick,
                onDeveloperClick = viewModel::onDeveloperClick
            )
        }
    }
}