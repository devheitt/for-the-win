package com.github.for_the_win.ui.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.for_the_win.ui.theme.DarkerBlue
import com.github.for_the_win.ui.theme.TealSkyblue

@Composable
fun SocialButtons() {
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
            Text( text = "Google", fontWeight = FontWeight.Medium, fontSize = 26.sp, modifier = Modifier.textBrush(
                TealSkyblue
            ))
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
            Text( text = "Facebook", fontWeight = FontWeight.Medium, fontSize = 26.sp, modifier = Modifier.textBrush(
                TealSkyblue
            ) )
        }
    }
}