package com.example.profissional

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profissional.ui.theme.ProfissionalTheme
import kotlinx.coroutines.launch

class Pager : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val pagerState = rememberPagerState {
                3
            }
            val coroutineScope = rememberCoroutineScope()
            Pager1(pagerState)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 60.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
            ) {
                Row (){
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.padding(end = 70.dp)
                    ) {
                        Button(border = BorderStroke(1.dp, Color.Blue),
                            colors = ButtonDefaults.buttonColors(Color.White) ,
                            shape = RoundedCornerShape(10.dp),
                            onClick = { startActivity(Intent(this@Pager, MainActivity2::class.java))
                        }, modifier = Modifier
                                .height(50.dp)
                                .width(100.dp)) {
                            Text(text = "Skip",
                                color = Color.Blue)
                        }
                    }
                    Column(verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.End,
                        modifier = Modifier.padding(start = 70.dp)) {
                        Button(colors = ButtonDefaults.buttonColors(Color.Blue),
                            shape = RoundedCornerShape(10.dp),
                            onClick = {
                            coroutineScope.launch {
                                when (pagerState.currentPage) {
                                    0 -> pagerState.scrollToPage(1)
                                    1 -> pagerState.scrollToPage(2)
                                    else -> startActivity(Intent(this@Pager, MainActivity2::class.java))
                                }
                            }
                        }, modifier = Modifier
                                .height(50.dp)
                                .width(100.dp)) {
                            Text(text = if(pagerState.currentPage ==0 || pagerState.currentPage ==1)"Next" else "Sign Up")
                        }
                    }

                }





            }
        }
        }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun Pager1(pagerState:PagerState){
        HorizontalPager(state = pagerState) { page->
            when(page){
                0 -> Screen1()
                1 -> Screen2()
                2 ->  Screen3()
            }


        }
    }

    @Composable
    fun Screen1(){
        Column( verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()) {
            Image(painter = painterResource(id = R.drawable.img1), contentDescription ="",
                modifier = Modifier
                    .height(350.dp)
                    .width(350.dp)
                    .padding(top = 40.dp))
            Text(text = "Quick Delivery At Your Doorstep",
                modifier = Modifier.padding(30.dp),
                textAlign = TextAlign.Center, 
                color = Color.Blue,
                fontSize = 30.sp)
            Text(text = "Enjoy quick pick-up and delivery to your destination",
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                color = Color.Gray,
              )
        }
    }
    @Composable
    fun Screen2(){
        Column( verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()) {
            Image(painter = painterResource(id = R.drawable.img), contentDescription ="",
                modifier = Modifier
                    .height(350.dp)
                    .width(350.dp)
                    .padding(top = 40.dp))
            Text(text = "Flexible Payment",
                modifier = Modifier.padding(30.dp),
                textAlign = TextAlign.Center,
                color = Color.Blue,
                fontSize = 30.sp)
            Text(text = "Different modes of payments either before and after delivery without stress",
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }
    }
    @Composable
    fun Screen3() {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_1), contentDescription = "",
                modifier = Modifier
                    .height(350.dp)
                    .width(350.dp)
                    .padding(top = 40.dp)
            )
            Text(
                text = "Real-time Tracking",
                modifier = Modifier.padding(30.dp),
                textAlign = TextAlign.Center,
                color = Color.Blue,
                fontSize = 30.sp
            )
            Text(
                text = "Track your packages/items from the confortof your home till final destination",
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }
    }
}