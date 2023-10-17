package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api

class MainActivity2 : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WebPager(url = "https://forms.yandex.ru/u/6516640d693872a43ed68412/")
            MainScreen(
                onClickBack = {
                 val intent = Intent(this@MainActivity2, BrendActivity::class.java)
                startActivity(intent)

            },
                click = {
                    val intent = Intent(this@MainActivity2, CulltureActivity::class.java)
                    startActivity(intent)
                },
                clickBack = {val intent = Intent(this@MainActivity2, Place::class.java )
                startActivity(intent)})
            }

        }

    }



