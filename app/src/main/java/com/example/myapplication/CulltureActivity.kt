package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.FiraSansFamily
import com.example.myapplication.ui.theme.Green80
import com.example.myapplication.ui.theme.Pink40

class CulltureActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
            topBar = { IconBa()}
        ) {
            Box(
                modifier = Modifier
                    //.padding(it)
                    .fillMaxSize()
            ) {
               CultureScreen()


            }


        }

        }

    }
    @Composable
    fun IconBa(


    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer { shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                clip  = true}
                .height(50.dp)
                .background(Pink40),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Культура",
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                color = Color.White
            )
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.CenterStart
            ) {
                androidx.compose.material3.Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .clickable { onBackPressed() }
                )
            }


        }

    }


    @Preview
    @Composable
    fun CultureScreen() {

        Column(

            modifier = Modifier
                .fillMaxSize()
                .background(Green80)
                .padding(top = 30.dp)
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.theatre),
                contentDescription = "oren",
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .clickable {
                        val intent = Intent(
                            this@CulltureActivity,
                            TheatrePiero::class.java
                        )
                        startActivity(intent)
                    },


                contentScale = ContentScale.FillWidth

            )

            Text(
                text = "«Театр кукол Пьеро»",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = FiraSansFamily,

                )
            Image(
                painter = painterResource(id = R.drawable.theatre_2),
                contentDescription = "oren",
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .clickable {
                        val intent = Intent(this@CulltureActivity, DramTheatre::class.java)
                        startActivity(intent)
                    },

                contentScale = ContentScale.FillWidth

            )
            Text(
                text = "«Драм театр им. Горького»",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = FiraSansFamily,
            )
            Image(
                painter = painterResource(id = R.drawable.museum),
                contentDescription = "lk",
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .clickable {
                        val intent = Intent(this@CulltureActivity, MuseumHistory::class.java)
                        startActivity(intent)
                    },
                contentScale = ContentScale.FillWidth


            )
            Text(
                text = "Музей истории Оренбурга»",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = FiraSansFamily,
            )



        }
    }


}

