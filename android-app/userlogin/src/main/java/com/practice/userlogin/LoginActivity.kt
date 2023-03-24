package com.practice.userlogin

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practice.userlogin.ui.theme.*

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ForthewinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val colors = Brush.verticalGradient(listOf(Teal200, Skyblue))
    val context = LocalContext.current.applicationContext
    val paddingValues = PaddingValues(horizontal = 0.dp, vertical = 12.dp)

    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .background(Blue)
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
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Forgot Password?",
                    style = MaterialTheme.typography.body1,
                    color = Skyblue,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .align(alignment = End)
                        .clickable {
                            // Handle forgot password click
                            // For example, show a dialog with instructions on how to reset the password
                        }
                )
                Spacer(modifier = Modifier.height(25.dp))
                GradientBorderButtonRound(
                    text = stringResource(R.string.login_button_text, "LOG IN"),
                    colors = colors,
                    context = context,
                    paddingValues = paddingValues
                )
                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = "Or log in with",
                    style = MaterialTheme.typography.body1,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(25.dp))
                GoogleAndFacebookButtons()
                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = "Don't have an account yet?",
                    style = MaterialTheme.typography.body1,
                    color = Color.White
                )
                Text(
                    text = "Sign Up",
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

//Custom gradient button
@Composable
fun GradientBorderButtonRound(
    text: String,
    colors: Brush,
    context: Context,
    paddingValues: PaddingValues
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 4.dp,
                brush = colors,
                shape = RoundedCornerShape(percent = 50)
            )
            // To make the ripple round
            .clip(shape = RoundedCornerShape(percent = 50))
            .clickable {
                Toast
                    .makeText(context, "Round Button Click", Toast.LENGTH_SHORT)
                    .show()
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 26.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(paddingValues)
                .textBrush(colors)
        )
    }
}

//Adds brush colors to a text
fun Modifier.textBrush(brush: Brush) = this
    .graphicsLayer(alpha = 0.99f)
    .drawWithCache {
        onDrawWithContent {
            drawContent()
            drawRect(brush, blendMode = BlendMode.SrcAtop)
        }
    }

@Composable
fun GoogleAndFacebookButtons() {
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        OutlinedButton(
            onClick = { },
            border = BorderStroke(1.dp, Color.Transparent),
            shape = RoundedCornerShape(50, 0, 0, 50), // = 50% percent
            // or shape = CircleShape
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White, backgroundColor = DarkerBlue),
            modifier = Modifier.weight(1f)
        ){
            Text( text = "Google", fontWeight = FontWeight.Medium, fontSize = 26.sp, modifier = Modifier.textBrush(TealSkyblue))
        }
        Spacer(modifier = Modifier.width(5.dp))
        OutlinedButton(
            onClick = { },
            border = BorderStroke(1.dp, Color.Transparent),
            shape = RoundedCornerShape(0,50,50,0), // = 50% percent
            // or shape = CircleShape
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White, backgroundColor = DarkerBlue),
            modifier = Modifier.weight(1f)
        ){
            Text( text = "Facebook", fontWeight = FontWeight.Medium, fontSize = 26.sp, modifier = Modifier.textBrush(TealSkyblue) )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    ForthewinTheme {
        LoginScreen()
    }
}