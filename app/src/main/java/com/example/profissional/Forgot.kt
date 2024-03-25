package com.example.profissional

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profissional.ui.theme.ProfissionalTheme

class Forgot : ComponentActivity() {
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
            ForgotPass()
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ForgotPass(){
        var emaill by remember {
            mutableStateOf("")
        }
        Column(verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp)) {

            Text(text = "Forgot Password", fontSize = 30.sp,
                modifier = Modifier.padding(start = 20.dp))

            Text(text = "Enter your email adress", color = Color.Gray,
                fontSize = 15.sp, modifier = Modifier
                    .padding(start = 20.dp)
                    .padding(top = 5.dp))
            Text(text = "Email", color = Color.Gray,
                fontSize = 15.sp, modifier = Modifier
                    .padding(start = 20.dp)
                    .padding(top = 20.dp))
            OutlinedTextField(value = emaill, onValueChange = {emaill = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .padding(horizontal = 20.dp))

            Button(onClick ={startActivity(Intent(this@Forgot, Code::class.java))}, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 40.dp),
                colors = ButtonDefaults.buttonColors(if(emaill.isEmpty()) Color.Gray else Color.Blue)
                    ,
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Send OTP", color = Color.White,)
                
            }

            Row (modifier = Modifier.padding(start = 90.dp).padding(top = 15.dp)){
                Text(text = "Remember password?Bac to")
                Text(text = "Sign in", color = Color.Blue,
                    modifier = Modifier
                        .clickable { startActivity(Intent(this@Forgot, Welcome::class.java)) })

            }



        }
    }
}
