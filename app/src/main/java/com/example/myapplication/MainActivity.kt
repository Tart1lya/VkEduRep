package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

data class App(
    val id: Int,
    val name: String,
    val icon: Int,
    val description: String,
    val section: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color(0xff2c71f4)
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(innerPadding)
                    ) {
                        Head()
                        AppsScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun Head() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.rustore_color_logo),
            modifier = Modifier.size(width = 150.dp, height = 75.dp),
            contentDescription = "RuStore"
        )
        Image(
            painter = painterResource(id = R.drawable.menu_logo),
            modifier = Modifier.size(25.dp),
            contentDescription = "Menu"
        )
    }
}

@Composable
fun AppsScreen() {
    val apps = listOf(
        App(
            id = 1,
            name = "Telegram",
            icon = R.drawable.telegram_logo,
            description = "Быстрый и безопасный мессенджер с облачным хранением",
            section = "Соцсети"
        ),
        App(
            id = 2,
            name = "VK Мессенджер",
            icon = R.drawable.vk_logo,
            description = "Общайтесь с друзьями, отправляйте фото и видео",
            section = "Соцсети"
        ),
        App(
            id = 3,
            name = "Яндекс Музыка",
            icon = R.drawable.ya_music,
            description = "Миллионы треков, подкасты и персональные рекомендации",
            section = "Музыка"
        ),
        App(
            id = 4,
            name = "Clash of Clans",
            icon = R.drawable.clash_of_clans_logo,
            description = "Эпическая стратегия: строй деревню, собирай армию, сражайся",
            section = "Игры"
        ),
        App(
            id = 5,
            name = "2ГИС",
            icon = R.drawable.twogis_logo,
            description = "Офлайн-карты, навигатор, расписание транспорта и организации",
            section = "Карты"
        ),
        App(
            id = 6,
            name = "Wildberries",
            icon = R.drawable.wildberries_logo,
            description = "Онлайн-магазин одежды, электроники, товаров для дома",
            section = "Покупки"
        ),
        App(
            id = 7,
            name = "СберБанк Онлайн",
            icon = R.drawable.sber_logo,
            description = "Переводы, оплата услуг, инвестиции и управление картами",
            section = "Финансы"
        ),
        App(
            id = 8,
            name = "Brawl Stars",
            icon = R.drawable.brawl_stars_logo,
            description = "Динамичные командные сражения от создателей Clash Royale",
            section = "Игры"
        ),
        App(
            id = 9,
            name = "RuTube",
            icon = R.drawable.rutube_logo,
            description = "Видеохостинг: фильмы, сериалы, блоги и прямые эфиры",
            section = "Видео"
        ),
        App(
            id = 10,
            name = "Avito",
            icon = R.drawable.avito_logo,
            description = "Покупка и продажа товаров, авто, недвижимости и услуг",
            section = "Покупки"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(Color.White)
    ) {
        AppsList(
            apps = apps,
            onCardClick = { app ->
                println("Клик по приложению: ${app.name} из секции ${app.section}")
            }
        )
    }
}

@Composable
fun AppCard(
    app: App,
    modifier: Modifier = Modifier,
    onCardClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onCardClick)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Image(
                painter = painterResource(id = app.icon),
                contentDescription = app.name,
                modifier = Modifier.size(64.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = app.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = app.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = app.section,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium
                )
            }
        }
        HorizontalDivider(
            modifier = Modifier,
            thickness = 1.dp,
            color = Color(0xFFE0E0E0)
        )
    }
}

@Composable
fun AppsList(
    apps: List<App>,
    onCardClick: (App) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(
            start = 16.dp,
            end = 16.dp,
            bottom = 16.dp
        ),
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        items(
            items = apps,
            key = { app -> app.id }
        ) { app ->
            AppCard(
                app = app,
                onCardClick = { onCardClick(app) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppCardPreview() {
    MyApplicationTheme {
        AppCard(
            app = App(
                id = 1,
                name = "Telegram",
                icon = android.R.drawable.ic_dialog_email,
                description = "Быстрый и безопасный мессенджер",
                section = "Соцсети"
            ),
            onCardClick = {}
        )
    }
}
