package com.practice.userlogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.practice.userlogin.ui.theme.*

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ForthewinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colors.background
                ) {
                    SignUpScreen()
                }
            }
        }
    }
}

@Composable
fun SignUpScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val colors = Brush.verticalGradient(listOf(Teal200, Skyblue))
    val context = LocalContext.current.applicationContext
    val paddingValues = PaddingValues(horizontal = 0.dp, vertical = 12.dp)

    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .background(Color(0xFF1E4564))
                    .fillMaxSize()
                    .padding(horizontal = 30.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(R.drawable.ftw_logo),
                    contentDescription = "App logo",
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                )
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Skyblue,
                        unfocusedBorderColor = Color.White,
                        focusedLabelColor = Skyblue,
                        unfocusedLabelColor = Color.White,
                        textColor = Color.White,
                        disabledTextColor = Color.Black,
                        cursorColor = Skyblue
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Username") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Skyblue,
                        unfocusedBorderColor = Color.White,
                        focusedLabelColor = Skyblue,
                        unfocusedLabelColor = Color.White,
                        textColor = Color.White,
                        disabledTextColor = Color.Black,
                        cursorColor = Skyblue
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Skyblue,
                        unfocusedBorderColor = Color.White,
                        focusedLabelColor = Skyblue,
                        unfocusedLabelColor = Color.White,
                        textColor = Color.White,
                        disabledTextColor = Color.Black,
                        cursorColor = Skyblue
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Retype Password") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Skyblue,
                        unfocusedBorderColor = Color.White,
                        focusedLabelColor = Skyblue,
                        unfocusedLabelColor = Color.White,
                        textColor = Color.White,
                        disabledTextColor = Color.Black,
                        cursorColor = Skyblue
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(25.dp))
                GradientBorderButtonRound(
                    text = stringResource(R.string.signup_button_texts,"SIGN UP"),
                    colors = colors,
                    context = context,
                    paddingValues = paddingValues
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Or sign up with",
                    style = MaterialTheme.typography.body1,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                GoogleAndFacebookButtons()
                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = "Already have an account?",
                    style = MaterialTheme.typography.body1,
                    color = Color.White
                )
                Text(
                    text = "Log In",
                    style = MaterialTheme.typography.body1,
                    color = Skyblue,
                    modifier = Modifier.clickable{
                        // Handle Sign Up button
                    }
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    ForthewinTheme {
        SignUpScreen()
    }
}