package com.example.profissional

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CarCrash
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ManageAccounts
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material.icons.outlined.CarCrash
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Man
import androidx.compose.material.icons.outlined.ManageAccounts
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Wallet
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profissional.ui.theme.ProfissionalTheme

class Tablayout : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tabItems = listOf(
            TabItem(
                title = "Home",
                unselectedIcon = Icons.Outlined.Home,
                selectedIcon = Icons.Filled.Home
            ),
            TabItem(
                title = "Wallet",
                unselectedIcon = Icons.Outlined.Wallet,
                selectedIcon = Icons.Filled.Wallet
            ),
            TabItem(
                title = "Home",
                unselectedIcon = Icons.Outlined.CarCrash,
                selectedIcon = Icons.Filled.CarCrash
            ),
            TabItem(
                title = "Home",
                unselectedIcon = Icons.Outlined.ManageAccounts,
                selectedIcon = Icons.Filled.ManageAccounts
            )
        )
        setContent {
            ProfissionalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var selectedTabIndex by remember {
                        mutableStateOf(0)
                    }
                    val pagerState = rememberPagerState {
                        tabItems.size
                    }
                    LaunchedEffect(selectedTabIndex) {
                        pagerState.animateScrollToPage(selectedTabIndex)
                    }
                    LaunchedEffect(pagerState.currentPage) {
                        selectedTabIndex = pagerState.currentPage
                    }
                    Scaffold(bottomBar = {
                        TabRow(selectedTabIndex = selectedTabIndex) {


                            tabItems.forEachIndexed { index, item ->
                                Tab(selected = index == selectedTabIndex,
                                    unselectedContentColor = Color.Gray,
                                    selectedContentColor = Color.Blue,
                                    onClick = {
                                        selectedTabIndex = index
                                    },
                                    text = {
                                        Text(text = item.title)
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = if (index == selectedTabIndex) {
                                                item.unselectedIcon
                                            } else item.selectedIcon,
                                            contentDescription = item.title
                                        )
                                    }
                                )
                            }

                        }
                    }) {
                        Box(modifier = Modifier.padding(it)) {

                            HorizontalPager(state = pagerState) { page ->
                                when (page) {
                                    0 -> Screen1()
                                    1 -> Screen2()
                                    2 -> Screen3()
                                    3 -> Screen4()

                                }

                            }

                        }

                    }


                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Screen1() {
        var search by remember {
            mutableStateOf("")
        }
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(top = 50.dp)
        ){
            OutlinedTextField(value = search, onValueChange ={search = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp))
            Spacer(modifier = Modifier.size(15.dp))
            Image(painter = painterResource(id = R.drawable.heloo), contentDescription =  "",
                modifier = Modifier
                    .height(91.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp))
            
            Spacer(modifier = Modifier.size(40.dp))
            
            Row(verticalAlignment = Alignment.CenterVertically, 
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 20.dp)) {
                Image(painter = painterResource(id = R.drawable.card_1), contentDescription = "",
                    modifier = Modifier
                        .height(64.dp)
                        .width(166.dp))
                Spacer(modifier = Modifier.size(10.dp))
                Image(painter = painterResource(id = R.drawable.card_2), contentDescription = "",
                    modifier = Modifier
                        .height(64.dp)
                        .width(166.dp))
                Spacer(modifier = Modifier.size(10.dp))
                Image(painter = painterResource(id = R.drawable.card_2), contentDescription = "",
                    modifier = Modifier
                        .height(64.dp)
                        .width(166.dp))
                Spacer(modifier = Modifier.size(10.dp))
                Image(painter = painterResource(id = R.drawable.card_2), contentDescription = "",
                    modifier = Modifier
                        .height(64.dp)
                        .width(166.dp))
                
                
            }




        }
    }

    @Composable
    fun Screen2() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Hello2")
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun Screen3() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Hello3")
        }
    }

    @Composable
    fun Screen4() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Hello4")
        }
    }
}

data class TabItem(
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector
)

