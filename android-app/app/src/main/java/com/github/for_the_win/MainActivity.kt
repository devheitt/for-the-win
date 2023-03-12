package com.github.for_the_win

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.for_the_win.ui.theme.ForthewinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ForthewinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                    CardGameMenu()
                }
            }
        }
    }
}

@Composable
fun CardGameMenu() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Card Game",
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        )
        Spacer(Modifier.height(32.dp))
        Button(
            onClick = { /* Do something */ },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(60.dp)
                .background(
                    color = Color(0xFF444444),
                    shape = RoundedCornerShape(30.dp)
                ),
            contentPadding = PaddingValues(12.dp)
        ) {
            Text(
                text = "New Game",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = { /* Do something */ },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(60.dp)
                .background(
                    color = Color(0xFF444444),
                    shape = RoundedCornerShape(30.dp)
                ),
            contentPadding = PaddingValues(12.dp)
        ) {
            Text(
                text = "Load Game",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = { /* Do something */ },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(60.dp)
                .background(
                    color = Color(0xFF444444),
                    shape = RoundedCornerShape(30.dp)
                ),
            contentPadding = PaddingValues(12.dp)
        ) {
            Text(
                text = "Settings",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = { /* Do something */ },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(60.dp)
                .background(
                    color = Color(0xFF444444),
                    shape = RoundedCornerShape(30.dp)
                ),
            contentPadding = PaddingValues(12.dp)
        ) {
            Text(
                text = "Exit",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ForthewinTheme {
        CardGameMenu()
    }
}