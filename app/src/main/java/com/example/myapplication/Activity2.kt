package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.FiraSansFamily
import com.example.myapplication.ui.theme.Green80
import kotlinx.coroutines.launch

class Activity2 : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val pagerState = rememberPagerState(pageCount = {
                3
            })
            val coroutineScope = rememberCoroutineScope()
            Pager(pagerState)
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Row(

                ) {
                    Box(Modifier.padding(8.dp), contentAlignment = Alignment.Center) {
                        Canvas(modifier = Modifier) {
                            drawCircle(
                                color = if (pagerState.currentPage == 0) Color.Blue else Color.Gray,
                                radius = if (pagerState.currentPage == 0) 12f else 8f
                            )
                        }
                    }
                    Box(Modifier.padding(8.dp), contentAlignment = Alignment.Center) {
                        Canvas(modifier = Modifier) {
                            drawCircle(
                                color = if (pagerState.currentPage == 1) Color.Blue else Color.Gray,
                                radius = if (pagerState.currentPage == 1) 12f else 8f
                            )
                        }
                    }
                    Box(Modifier.padding(8.dp), contentAlignment = Alignment.Center) {
                        Canvas(modifier = Modifier) {
                            drawCircle(
                                color = if (pagerState.currentPage == 2) Color.Blue else Color.Gray,
                                radius = if (pagerState.currentPage == 2) 12f else 8f
                            )
                        }
                    }

                }

                Button(onClick = {
                    coroutineScope.launch {
                        when (pagerState.currentPage) {
                            0 -> pagerState.scrollToPage(1)
                            1 -> pagerState.scrollToPage(2)
                            else -> startActivity(Intent(this@Activity2, MainActivity2::class.java))
                        }
                    }
                }) {
                    Text(text = if (pagerState.currentPage == 0 || pagerState.currentPage == 1) "Дальше" else "Вперед")
                }
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun Pager(pagerState: PagerState) {

        HorizontalPager(state = pagerState) { page ->
            when (page) {
                0 -> firstpage()
                1 -> secondpage()
                2 -> lastpage()

            }

        }

    }


    @SuppressLint("ComposableNaming")
    @Preview(showBackground = true)
    @Composable
    fun firstpage() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Green80)
        )
        {
            Image(
                painter = painterResource(id = R.drawable.gerb),
                contentDescription = "img",

                modifier = Modifier
                    .size(250.dp)
                    .padding(top = 30.dp)
            )
            Spacer(modifier = Modifier.size(30.dp))
            Text(

                fontFamily = FiraSansFamily,
                text = "Оренбургская область - субьект Российской Федерации. " +
                        "Входит в Приволжский федеральный округ, является частью Уральского экономического района.",
                textAlign = TextAlign.Center, fontSize = 16.sp, color = Color.White,
                modifier = Modifier.padding(horizontal = 15.dp)
            )
            Spacer(modifier = Modifier.size(30.dp))
            Text(
                fontFamily = FiraSansFamily,
                text = "ОБразована 7 декабря 1934 года Указом Президиума" +
                        " Верховного Совета СССР путем выделения её из Средневолжского края. В период с 1938 по 1957 год называлась Чкаловской областью. ",
                textAlign = TextAlign.Center, color = Color.White, fontSize = 16.sp,
                modifier = Modifier.padding(horizontal = 15.dp)
            )
            Spacer(modifier = Modifier.size(30.dp))
            Text(fontFamily = FiraSansFamily,
                text = "Истоирчески области предшествовала Оренбургская губерния, образованная указом императрицы Елизаветы Петровны в 1744 году.",
                textAlign = TextAlign.Center, color = Color.White, fontSize = 16.sp,
                modifier = Modifier.padding(horizontal = 15.dp)
            )
            Spacer(modifier = Modifier.size(30.dp))
            Text(fontFamily = FiraSansFamily,
                text = "Административный цетр - город Оренбург",
                textAlign = TextAlign.Center,
                color = Color.White, fontSize = 16.sp,
                modifier = Modifier.padding(horizontal = 15.dp)
            )


        }

    }

    @SuppressLint("ComposableNaming")
    @Preview(showBackground = true)
    @Composable
    fun secondpage(
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Green80)
        )
        {
            Image(
                painter = painterResource(id = R.drawable.pasler),
                contentDescription = "image_pasler",
                modifier = Modifier
                    .padding(20.dp)
                    .size(300.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(Color.White),

                contentScale = ContentScale.FillHeight



            )
            Text(fontFamily = FiraSansFamily,
                text = "Паслер Денис Владимирович - Губернатор Оренбургской области - председатель Правительства Оренбургской области ",


                textAlign = TextAlign.Center,
                color = Color.White, fontSize = 18.sp
            )
            Spacer(modifier = Modifier.size(5.dp))
            Text(fontFamily = FiraSansFamily,
                text = "Адрес: 460015, г. Оренбург, Дом Советов", textAlign = TextAlign.Center,
                color = Color.White, fontSize = 18.sp
            )
            Spacer(modifier = Modifier.size(5.dp))
            Text(fontFamily = FiraSansFamily,
                text = "Телефоны: (3532) 77-69-31, 78-60-10", textAlign = TextAlign.Center,
                color = Color.White, fontSize = 18.sp
            )
            Spacer(modifier = Modifier.size(5.dp))
            Text(fontFamily = FiraSansFamily,
                text = "Факс:(3532) 77-38-02", textAlign = TextAlign.Center,
                color = Color.White, fontSize = 18.sp
            )
            Spacer(modifier = Modifier.size(5.dp))
            Text(fontFamily = FiraSansFamily,
                text = "Факс:(3532) 77-38-02", textAlign = TextAlign.Center,
                color = Color.White, fontSize = 18.sp
            )
            Spacer(modifier = Modifier.size(5.dp))
            Text(fontFamily = FiraSansFamily,
                text = "Email: office@gov.orb.ru", textAlign = TextAlign.Center,
                color = Color.White, fontSize = 18.sp
            )


        }


    }

    @SuppressLint("ComposableNaming")
    @Preview(showBackground = true)
    @Composable
    fun lastpage() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Green80)

        ) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.img_1),
                    contentDescription = "bisiness",
                    modifier = Modifier.padding(top = 30.dp),
                    )
                Image(painter = painterResource(id =R.drawable.rocket ),
                    contentDescription ="" ,
                    modifier = Modifier.padding(top = 70.dp, ).padding(start = 40.dp))


            }
            Spacer(modifier = Modifier.size(20.dp))

            Text(fontFamily = FiraSansFamily,
                text = " АНО Цетр поддержки предпринимательства и " +
                        "развития экспорта Оренбургской области", textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(fontFamily = FiraSansFamily,
                text = "8(800)200-14-45", textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 24.sp
            )
            Text(fontFamily = FiraSansFamily,
                text = " Готовы вас услышать", textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 24.sp
            )
            Text(fontFamily = FiraSansFamily,
                text = "г. Оренбург, ул. Шарлыкское шоссе, 1/2.", textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 24.sp
            )
            Text(fontFamily = FiraSansFamily,
                text = "info@mb-orb.ru", textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 24.sp
            )
            Text(fontFamily = FiraSansFamily,
                text = "График работы:", textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 24.sp
            )
            Text(fontFamily = FiraSansFamily,
                text = "Понедельник - Четверг с 9:00 до 18:00", textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 24.sp
            )
            Text(fontFamily = FiraSansFamily,
                text = "Пятница с 9:00 дл 17:00", textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 24.sp
            )
            Text(fontFamily = FiraSansFamily,
                text = "Перерыв с 13:00 до 14:00", textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.size(50.dp))


        }

    }


}














