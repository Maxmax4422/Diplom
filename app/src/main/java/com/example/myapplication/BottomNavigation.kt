package com.example.myapplication

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigation(
    navController: NavController
) {
    val listItems = listOf(
        BottomItem.HomeScreen,
        BottomItem.SecondScreen,
        BottomItem.ThreeScreen,

        )
    androidx.compose.material.BottomNavigation(
        backgroundColor = Color.White,
        modifier = Modifier.graphicsLayer {
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
            clip = true
        }
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRout = backStackEntry?.destination?.route
        listItems.forEach { item ->
            BottomNavigationItem(
                selected = currentRout == item.route,
                onClick = {
                    navController.navigate(item.route)
                },
                icon = { Icon(painter = painterResource(id = item.iconId),
                    contentDescription ="icon" ) },
                label = { Text(text = item.title, fontSize = 14.sp)},
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Gray


            )
        }

    }
}