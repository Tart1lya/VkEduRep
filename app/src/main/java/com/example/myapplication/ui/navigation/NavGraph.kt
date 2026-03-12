package com.example.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.ui.screens.AppDetailScreen
import com.example.myapplication.ui.screens.AppsListData
import com.example.myapplication.ui.screens.AppsListScreen

internal object Screen {
    const val APPS_LIST = "apps_list"
    const val APP_DETAIL = "app_detail"
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.APPS_LIST,
        modifier = modifier
    ) {
        composable(Screen.APPS_LIST) {
            AppsListScreen(
                apps = AppsListData.SAMPLE_APPS,
                onAppClick = { navController.navigate(Screen.APP_DETAIL) }
            )
        }
        composable(Screen.APP_DETAIL) {
            AppDetailScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}