package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(
    navHostController: NavHostController,
    onClickBack: () -> Unit,
    click:()->Unit,
    clickBack:()->Unit

) {
    NavHost(
        navController = navHostController,
        startDestination = "Главная",


    ) {
        composable("Главная") {
            HomeScreen(onClickBack, click, clickBack)
        }
        composable("Обращение") {
            WebPager(url = "https://forms.yandex.ru/u/6516640d693872a43ed68412/")
        }
        composable("О программе") {
            ThreeScreen()
        }
    }

}