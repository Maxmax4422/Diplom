package com.example.profissional

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profissional.ui.theme.ProfissionalTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import androidx.compose.runtime.remember as remember1

class Code : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfissionalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
            Codd()
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Codd() {
        var text1 by remember1 {
            mutableStateOf("")
        }
        var text2 by remember1 {
            mutableStateOf("")
        }
        var text3 by remember1 {
            mutableStateOf("")
        }
        var text4 by remember1 {
            mutableStateOf("")
        }
        var text5 by remember1 {
            mutableStateOf("")
        }
        var text6 by remember1 {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "OTP Verification",
                fontSize = 30.sp,
                modifier = Modifier.padding(start = 20.dp)
            )
            Text(
                text = "Enter the 6 digit numbers sent to your email",
                color = Color.Gray,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .padding(top = 15.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                BasicTextField(
                    value = text1, onValueChange = { text1 = it },
                    modifier = Modifier
                        .height(32.dp)
                        .width(32.dp)
                        .border(1.dp, color = Color.Gray)
                        .padding(top = 5.dp),
                    textStyle = TextStyle(
                        textAlign = TextAlign.Center
                    )
                )

                Box(
                    modifier = Modifier
                        .height(32.dp)
                        .width(32.dp)
                        .border(1.dp, color = Color.Gray),
                    contentAlignment = Center
                )
                {
                    BasicTextField(
                        value = text2, onValueChange = { text2 = it },
                        textStyle = TextStyle(textAlign = TextAlign.Center)
                    )
                }

                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .border(1.dp, color = Color.Gray),
                    contentAlignment = Center
                ) {
                    BasicTextField(
                        value = text3, onValueChange = { text3 = it },
                        textStyle = TextStyle(textAlign = TextAlign.Center)
                    )
                }

                Box(modifier = Modifier
                    .size(32.dp)
                    .border(1.dp, color = Color.Gray),
                    contentAlignment = Center){
                    BasicTextField(
                        value = text4, onValueChange = { text4 = it },
                        textStyle = TextStyle(textAlign = TextAlign.Center)
                    )
                }
                Box(modifier = Modifier
                    .size(32.dp)
                    .border(1.dp, color = Color.Gray),
                    contentAlignment = Center){
                    BasicTextField(
                        value = text5, onValueChange = { text5 = it },
                        textStyle = TextStyle(textAlign = TextAlign.Center)
                    )
                }

                Box(modifier = Modifier
                    .size(32.dp)
                    .border(1.dp, color = Color.Gray),
                    contentAlignment = Center
                ){
                    BasicTextField(
                        value = text6, onValueChange = { text6 = it },
                        textStyle = TextStyle(textAlign = TextAlign.Center)
                    )
                }

            }
            Text(
                text = "If you did not receive code resend after 1:00",
                modifier = Modifier
                    .padding(start = 70.dp)
                    .padding(top = 15.dp), color = Color.Gray
            )
            Button(
                onClick = { startActivity(Intent(this@Code, NewPassword::class.java)) },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 50.dp),
                colors = ButtonDefaults.buttonColors(
                    if (text1.isEmpty()) Color.Gray else Color.Blue,
                    if (text2.isEmpty()) Color.Gray else Color.Blue,
                    if (text3.isEmpty()) Color.Gray else Color.Blue,
                    if (text4.isEmpty()) Color.Gray else Color.Blue
                )
            )
            {
                Text(text = "Set New Password", color = Color.White)

            }


        }
    }


}

