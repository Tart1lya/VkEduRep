package com.example.myapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.components.AppCard

@Composable
fun AppsListScreen(
    onAppClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AppsListViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(Color.White)
    ) {
        LazyColumn(
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            )
        ) {
            items(
                items = uiState.apps,
                key = { app -> app.id }
            ) { app ->
                AppCard(
                    app = app,
                    onClick = onAppClick
                )
            }
        }
    }
}

internal object AppsListData {
    val SAMPLE_APPS = listOf(
        com.example.myapplication.data.App(1, "Telegram", com.example.myapplication.R.drawable.telegram_logo, "Быстрый и безопасный мессенджер с облачным хранением", "Соцсети"),
        com.example.myapplication.data.App(2, "VK Мессенджер", com.example.myapplication.R.drawable.vk_logo, "Общайтесь с друзьями, отправляйте фото и видео", "Соцсети"),
        com.example.myapplication.data.App(3, "Яндекс Музыка", com.example.myapplication.R.drawable.ya_music, "Миллионы треков, подкасты и персональные рекомендации", "Музыка"),
        com.example.myapplication.data.App(4, "Clash of Clans", com.example.myapplication.R.drawable.clash_of_clans_logo, "Эпическая стратегия: строй деревню, собирай армию, сражайся", "Игры"),
        com.example.myapplication.data.App(5, "2ГИС", com.example.myapplication.R.drawable.twogis_logo, "Офлайн-карты, навигатор, расписание транспорта и организации", "Карты"),
        com.example.myapplication.data.App(6, "Wildberries", com.example.myapplication.R.drawable.wildberries_logo, "Онлайн-магазин одежды, электроники, товаров для дома", "Покупки"),
        com.example.myapplication.data.App(7, "СберБанк Онлайн", com.example.myapplication.R.drawable.sber_logo, "Переводы, оплата услуг, инвестиции и управление картами", "Финансы"),
        com.example.myapplication.data.App(8, "Brawl Stars", com.example.myapplication.R.drawable.brawl_stars_logo, "Динамичные командные сражения от создателей Clash Royale", "Игры"),
        com.example.myapplication.data.App(9, "RuTube", com.example.myapplication.R.drawable.rutube_logo, "Видеохостинг: фильмы, сериалы, блоги и прямые эфиры", "Видео"),
        com.example.myapplication.data.App(10, "Avito", com.example.myapplication.R.drawable.avito_logo, "Покупка и продажа товаров, авто, недвижимости и услуг", "Покупки")
    )
}