package com.example.myapplication
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    NavigationBar(
        containerColor = Color.White,
        modifier = Modifier.graphicsLayer { shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                                          clip = true},
        contentColor = Color.Black,
    ) {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        listItems.forEach { item ->
            NavigationBarItem(

               

                selected = currentRoute == item.route,
                modifier = Modifier.graphicsLayer { shape = RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp)
                                                  clip = true},
                onClick = {
                    navController.navigate(item.route)
                },
                icon = {
                    Image(
                        painter = painterResource(id = item.iconId),
                        contentDescription = "Icon",
                        modifier = Modifier
                            .size(40.dp)
                            .padding(bottom = 10.dp)

                    )
                },
                                label = {
                    Text(
                        text = item.title,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(top = 25.dp)

                    )
                },

            )
        }
    }
}