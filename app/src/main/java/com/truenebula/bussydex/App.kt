package com.truenebula.bussydex

import com.truenebula.bussydex.components.Modal
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.truenebula.bussydex.components.BusCard
import com.truenebula.bussydex.components.FabArea
import com.truenebula.bussydex.components.Header
import com.truenebula.bussydex.model.Bus
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun App() {
    AppContent()
}

@Composable
fun AppContent() {
    val bus1 = Bus("Bus 24B", "lmao desc\nlmaooo", false)
    val bus2 = Bus("Bus 35", "lmao desc2", true)

    val busList:MutableList<Bus> = mutableListOf(bus1, bus2)
    val listState = remember {
        busList.toMutableStateList()
    }
    val isAdmin = remember { mutableStateOf(false)}
    val isModalOpen = remember { mutableStateOf(false)}

    fun onDeleteCard(bus: Bus) {
        Log.d("Bus", "Removed $bus.name")
        listState.remove(bus)
        Log.d("BusList", listState.toString())
    }

    fun onAddBus(busName: String, busDescription: String) {
        val dateFormat = SimpleDateFormat("dd-MM-yyyy")
        val newBus = Bus(busName, busDescription, dateAdded = dateFormat.format(Date()))
        Log.d("Add", "${newBus.name}, ${newBus.description}, ${newBus.dateAdded}")

        listState.add(newBus)

    }

    Box(modifier = Modifier.fillMaxSize()) {
        Header()
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 80.dp)
        ) {
            listState.forEach { bus ->
                Log.d("Column", bus.toString())
                BusCard(bus, isAdmin.value, ::onDeleteCard)
            }
        }
        Box(modifier = Modifier
            .align(Alignment.BottomEnd)
            .offset(x = (-20).dp, y = (-30).dp)
        ) {
            FabArea(isAdmin, isModalOpen)
        }
        Modal(open = isModalOpen, ::onAddBus)
    }

}