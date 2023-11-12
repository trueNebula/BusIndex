package com.truenebula.bussydex.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ViewHeader(title: String, onClickBack: () -> Unit) {
    Surface(
        color = MaterialTheme.colorScheme.tertiary,
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .shadow(
                ambientColor = Color.Blue,
                spotColor = Color.Blue,
                elevation = 20.dp,
                clip = true,
                shape = RoundedCornerShape(0.dp, 0.dp, 20.dp, 20.dp)
            ),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
            TextButton(
                onClick = onClickBack,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
            ) {
                Text(
                    text = "x",
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 18.sp,
                )
            }
        }
    }
}