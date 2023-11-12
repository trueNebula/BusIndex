package com.truenebula.bussydex.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header() {
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
        Box {
            Row(
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text(
                    text = "Bus",
                    modifier = Modifier.padding(8.dp, 8.dp, 1.dp, 8.dp),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                )
                Text(
                    text = "syDex",
                    modifier = Modifier.padding(1.dp, 8.dp, 8.dp, 8.dp),
                    textAlign = TextAlign.Center,
                    letterSpacing = 3.sp,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                )
            }
        }
    }
}