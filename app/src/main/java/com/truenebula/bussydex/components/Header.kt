package com.truenebula.bussydex.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.truenebula.bussydex.R

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
        Text(
            text = "BussyDex",
            modifier = Modifier.padding(8.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onPrimary,
        )
//            Box() {
//                Image(
//                    painter = painterResource(id = R.drawable.bussydexheader),
//                    contentDescription = "BussyDex Logo",
//                    contentScale = ContentScale.Fit,
//                    modifier = Modifier.align(Alignment.Center).shadow(elevation = 4.dp, spotColor = Color(0x40000000), ambientColor = Color(0x40000000))
//                )
//            }
        }
}