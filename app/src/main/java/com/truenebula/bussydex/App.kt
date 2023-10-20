package com.truenebula.bussydex

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.truenebula.bussydex.components.Card
import com.truenebula.bussydex.components.Header

@Composable
fun App() {
    AppContent()
}

@Composable
fun AppContent() {
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        Header()
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "lmao")
        Card()
    }
}