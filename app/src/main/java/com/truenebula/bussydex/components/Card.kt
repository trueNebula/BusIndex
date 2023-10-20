package com.truenebula.bussydex.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp

@Composable
fun Card() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .padding(10.dp)
            .shadow(elevation = 4.dp, clip = true, shape = RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.primaryContainer, shape = RoundedCornerShape(20.dp)),

//        color = MaterialTheme.colorScheme.primaryContainer,

    ) {

    }

}