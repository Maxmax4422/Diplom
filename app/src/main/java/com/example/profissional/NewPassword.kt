package com.example.profissional

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profissional.ui.theme.ProfissionalTheme

class NewPassword : ComponentActivity() {
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
            New()
        }
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun New(){
        var passswordVisibility:Boolean by remember {
            mutableStateOf(false)
        }
        var passswordVisibility2:Boolean by remember {
            mutableStateOf(false)
        }

        var textpas1 by remember{
            mutableStateOf("")
        }
        var textpass2 by remember{
            mutableStateOf("")
        }
        Column(modifier = Modifier.padding(top=30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start) {


            Text(text = "New Password",
                color = Color.Black,
                fontSize = 30.sp,
                modifier = Modifier.padding(start = 20.dp))
            Text(text = "Enter new password",
                color = Color.Gray,
                fontSize = 15.sp,
                modifier = Modifier.padding(start = 20.dp))
            Spacer(modifier = Modifier.size(20.dp))

            Text(text = "Password",
                color = Color.Gray,
                fontSize = 15.sp,
                modifier = Modifier.padding(start = 20.dp))

            OutlinedTextField(value = textpas1, onValueChange = { textpas1 = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                visualTransformation = if (passswordVisibility2) VisualTransformation.None else PasswordVisualTransformation(),
                leadingIcon = {
                    IconButton(onClick = {passswordVisibility2 = !passswordVisibility2}) {
                        Icon(painter = painterResource(id = R.drawable.img_2), contentDescription = "")

                    }
                })
            Spacer(modifier = Modifier.size(20.dp))
            Text(text = "Confirm Password",
                color = Color.Gray,
                fontSize = 15.sp,
                modifier = Modifier.padding(start = 20.dp))
            OutlinedTextField(value =textpass2, onValueChange ={textpass2 = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                visualTransformation = if (passswordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                leadingIcon = {
                    IconButton(onClick = {passswordVisibility = !passswordVisibility}) {
                        Icon(painter = painterResource(id = R.drawable.img_2), contentDescription = "")

                    }
                })
            Row(modifier = Modifier.padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically) {
            }

            Button(onClick = {startActivity(Intent(this@NewPassword, Tablayout::class.java))},
                colors = ButtonDefaults.buttonColors(Color.Blue),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 80.dp)
                    .padding(horizontal = 20.dp)
                    .height(46.dp)
            ) {
                Text(text="Log in", color=Color.White,
                    fontSize = 20.sp)

            }





        }

    }
}

