package com.github.for_the_win.ui.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//Custom gradient button
@Composable
fun GradientBorderButtonRound(
    text: String,
    colors: Brush,
    paddingValues: PaddingValues,
    displayProgressBar: Boolean = false,
    modifier: Modifier
) {
    if (!displayProgressBar) {
            Box(
                modifier = modifier,
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
        } else {
        CircularProgressIndicator(
            modifier = Modifier.size(50.dp),
            color = MaterialTheme.colors.primary,
            strokeWidth = 6.dp
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