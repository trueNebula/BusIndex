package com.truenebula.bussydex

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.truenebula.bussydex.components.Card
import com.truenebula.bussydex.components.FabArea
import com.truenebula.bussydex.components.Header
import com.truenebula.bussydex.model.Bus

@Composable
fun App() {
    AppContent()
}

@Composable
fun AppContent() {
    val bus1 = Bus("Bus 24B", "lmao desc\nlmaooo", false)
    val bus2 = Bus("Bus 35", "lmao desc2", true)
    val busList:MutableList<Bus> = mutableListOf(bus1, bus2)

    Box(modifier = Modifier.fillMaxSize()) {
        Header()
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 80.dp)
        ) {
            busList.forEach { bus ->
                Card(bus)
            }
        }
        Box(modifier = Modifier
            .align(Alignment.BottomEnd)
            .offset(x = (-20).dp, y = (-30).dp)
        ) {
            FabArea()
        }
    }

}