package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            splash()

        }
        Handler().postDelayed({startActivity(Intent(this, Activity2::class.java))
        finish()}, 3000)



    }
    @Preview(showBackground = true)
    @Composable
    fun splash(
    ){
        Column(
            modifier = Modifier.fillMaxSize()

        ){
            Image(painter = painterResource(id =R.drawable.map_2),
                 contentDescription = "image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillHeight)




        }


        }


    }



