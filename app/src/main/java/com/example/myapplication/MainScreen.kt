package com.example.myapplication

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(onClickBack: () -> Unit, click:()->Unit, clickBack:()->Unit) {
    val navController = rememberNavController()
    Scaffold(bottomBar = { BottomNavigation(navController = navController) },
    )
    {
        Box(
            modifier = Modifier
                //.padding(it)
                .fillMaxSize()
                ) {

            NavGraph(
                navHostController = navController,
                onClickBack,
                click,
                clickBack

            )
        }

    }


}
