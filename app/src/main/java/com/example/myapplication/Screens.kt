package com.example.myapplication

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.myapplication.ui.theme.FiraSansFamily
import com.example.myapplication.ui.theme.Green80

@Composable
fun HomeScreen(
    onClickBack: () -> Unit,
    click: () -> Unit,
    clickBack:()->Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Green80)
    ) {

    }

    Column(

        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    )

    {
        Image(
            painter = painterResource(id = R.drawable.brend_2),
            contentDescription = "brand",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(top = 50.dp)
                .sizeIn(minHeight = 162.dp, minWidth = 182.dp)
                .clickable { onClickBack.invoke() },


            )

        Spacer(modifier = Modifier.size(30.dp))
        Image(

            painter = painterResource(id = R.drawable.culture_2),
            contentDescription = "culture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .sizeIn(minHeight = 162.dp, minWidth = 182.dp)
                .clickable { click.invoke() },


            )
        Spacer(modifier = Modifier.size(30.dp))
        Image(
            painter = painterResource(id = R.drawable.places_2),
            contentDescription = "places",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .sizeIn(minWidth = 182.dp, minHeight = 162.dp)
                .clickable { clickBack.invoke() }
        )

    }


}


@Composable
fun WebPager(url: String) {
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }
    }, update = {
        it.loadUrl(url)
    })
}


@Composable
fun ThreeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Green80),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id =R.drawable.gerb), contentDescription = "")

        Text(text = "Это приложкение предназначено для того," +
                " чтобы помочь людям узнать больше о достопримечательностях, культуре и брендах нашей области, " +
                "о ее красоте и знначимости для всей страны ",
            textAlign = TextAlign.Center,
            color = Color.White,
            fontFamily = FiraSansFamily,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 20.dp))

    }
}