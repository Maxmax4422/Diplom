package com.example.profissional

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profissional.ui.theme.ProfissionalTheme
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import kotlinx.coroutines.launch

class MainActivity2 : ComponentActivity() {
    private lateinit var supabase: SupabaseClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supabase = MyApp.supabase
        setContent {
            ProfissionalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
            Text()
        }
    }

  private suspend fun SignUp(emailVal:String, passwordVal:String){
      supabase.auth.signUpWith(Email) {
          email = emailVal
          password = passwordVal

      }



    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview(showBackground = true)
    @Composable
    fun Text() {
        val coroutineScope = rememberCoroutineScope()

        var name by remember {
            mutableStateOf("")
        }
        var phone by remember {
            mutableStateOf("")
        }
        var emailText by remember {
            mutableStateOf("")
        }
        var passwordText by remember {
            mutableStateOf("")
        }
        var confirm by remember {
            mutableStateOf("")
        }

        var passwordVisibility: Boolean by remember { mutableStateOf(false) }
        var checked by remember { mutableStateOf(true) }

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(top = 20.dp)
        ) {
            Text(
                "Create an Account",
                color = Color.Black,
                fontSize = 30.sp,
                modifier = Modifier.padding(start = 20.dp)
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                "Complete the sign up process to get started",
                modifier = Modifier.padding(start = 20.dp),
                color = Color.Gray
            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                "Full name",
                color = Color.Gray,
                modifier = Modifier.padding(start = 20.dp)
            )
            OutlinedTextField(
                value = name, onValueChange = { name = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                "Phone Number",
                color = Color.Gray,
                modifier = Modifier.padding(start = 20.dp)
            )
            OutlinedTextField(
                value = phone, onValueChange = { phone = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                "Email Adress",
                color = Color.Gray,
                modifier = Modifier.padding(start = 20.dp)
            )
            OutlinedTextField(
                value = emailText, onValueChange = { emailText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                "Password",
                color = Color.Gray,
                modifier = Modifier.padding(start = 20.dp)
            )
            Box(){

                OutlinedTextField(value = passwordText, onValueChange = { passwordText = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation())
                Box(contentAlignment = Alignment.CenterEnd, modifier = Modifier.fillMaxSize().padding(end = 20.dp)){
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(
                            painter = painterResource(id = R.drawable.img_2),
                            contentDescription = "",
                        )

                    }

                }
            }
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                "Confirm Password",
                color = Color.Gray,
                modifier = Modifier.padding(start = 20.dp)
            )
            Box(){
                OutlinedTextField(
                value = confirm, onValueChange = { confirm = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            )
            Box(contentAlignment = Alignment.CenterEnd,
                modifier = Modifier.fillMaxSize().padding(end = 20.dp)){
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(
                        painter = painterResource(id = R.drawable.img_2),
                        contentDescription = "",
                    )


                }

            }}

            Spacer(modifier = Modifier.size(10.dp))
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.padding(horizontal = 10.dp)
            ) {
                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked_ ->
                        checked = checked_
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Blue,
                        uncheckedColor = Color.Gray
                    )
                )

                Text(
                    "By tcking this box, you agree to our Terms and conditions and private policy",
                    modifier = Modifier.padding(start = 2.dp)
                )
            }
            Button(
                onClick = {
                          coroutineScope.launch {
                              try {
                                  SignUp(emailVal = emailText, passwordVal = passwordText)
                                  startActivity(
                                      Intent(this@MainActivity2, Tablayout::class.java)
                                  )
                              } catch (e: Exception) {
                                  Toast.makeText(this@MainActivity2, "Ошибка при авторизации", Toast.LENGTH_SHORT).show()
                              }

                          }



                },
                colors = if (checked) ButtonDefaults.buttonColors(Color.Blue) else ButtonDefaults.buttonColors(
                    Color.Gray
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxSize()
                    .padding(horizontal = 20.dp),
                enabled = checked
            ) {
                Text("Sign Up", color = Color.White, fontSize = 20.sp)


            }
            Spacer(modifier = Modifier.size(10.dp))
            Row(
                modifier = Modifier.padding(start = 70.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text("Already have an account?")
                Text("Sign in",
                    color = Color.Blue,
                    modifier = Modifier
                        .clickable {
                            startActivity(
                                Intent(
                                    this@MainActivity2,
                                    Welcome::class.java
                                )
                            )
                        }
                        .padding(start = 10.dp))


            }


        }
    }

}

