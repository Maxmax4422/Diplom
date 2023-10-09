package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.myapplication.ui.theme.Purple40

class OrenHladoCombinat : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

           Scaffold (topBar = {IconBac()})
           {
               Box(modifier = Modifier
                   .padding(it)
                   .fillMaxSize())
               {
                   WebViewPage(url = "https://www.audit-it.ru/contragent/1025600893988_ooo-orenburgskiy-khladokombinat?ysclid=ln2trbwmsh873821419")


               }

           }

        }

    }

    @Composable
    fun IconBac(


    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Purple40),
            contentAlignment = Alignment.Center
        ){
            Text(text = "ООО \"ОРЕНБУРГСКИЙ ХЛАДОКОМБИНАТ\"\n",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color.White
            )
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.CenterStart){
                Icon(
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


    @SuppressLint("SuspiciousIndentation")
    @Composable
    fun WebViewPage(url: String) {
        AndroidView(factory = {
            WebView(it).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
              webViewClient = WebViewClient()
                loadUrl(url)

            }
        }, update = {
            it.loadUrl(url)

        })

    }
}

