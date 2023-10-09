package com.example.myapplication

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(
    navHostController: NavHostController,
    onClickBack: () -> Unit,
    click:()->Unit

) {
    NavHost(
        navController = navHostController,
        startDestination = "Главная",
        modifier = Modifier.padding(top = 15.dp)


    ) {
        composable("Главная") {
            HomeScreen(onClickBack, click)
        }
        composable("Обращение") {
            WebPager(url = "https://forms.yandex.ru/u/6516640d693872a43ed68412/")
        }
        composable("О программе") {
            ThreeScreen()
        }
    }

}