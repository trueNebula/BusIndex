package com.truenebula.bussydex

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.truenebula.bussydex.components.BusCard
import com.truenebula.bussydex.components.FabArea
import com.truenebula.bussydex.components.Header
import com.truenebula.bussydex.components.Modal
import com.truenebula.bussydex.model.Bus
import java.text.SimpleDateFormat
import java.util.Date

fun serializeList(list: List<Bus>): String {
    val gson = Gson()
    return gson.toJson(list)
}

fun saveListToStorage(context: Context, key: String, list: MutableList<Bus>) {
    val jsonString = serializeList(list)
    Log.i("LOCAL", jsonString)
    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("LocalBusList", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()

    editor.putString(key, jsonString)
    editor.apply()
}

fun getListFromStorage(context: Context, key: String): MutableList<Bus> {
    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("LocalBusList", Context.MODE_PRIVATE)
    val jsonString = sharedPreferences.getString(key, null)
    val gson = Gson()

    if (jsonString != null) {
        Log.i("LOCAL LOAD", jsonString)
    }

    return if (jsonString != null) {
        gson.fromJson(jsonString, Array<Bus>::class.java).toMutableList()
    } else {
        mutableListOf()
    }
}

@SuppressLint("SimpleDateFormat")
fun getFormattedDateString(): String {
    val dateFormat = SimpleDateFormat("dd-MM-yyyy")
    return dateFormat.format(Date())
}

@Composable
fun App() {
    AppContent()
}

@Composable
fun AppContent() {
    val bus1 = Bus("Bus 24B", "lmao desc\nlmaooo", false)
    val bus2 = Bus("Bus 35", "lmao desc2", true)
    val context = LocalContext.current
    val busList: MutableList<Bus> = getListFromStorage(context, "LocalBusList")

    if(busList.isEmpty()) {
        busList.add(bus1)
        busList.add(bus2)
        saveListToStorage(context, "LocalBusList", busList)
    }

    val listState = remember { busList.toMutableStateList() }
    val isAdmin = remember { mutableStateOf(false) }
    val isModalOpen = remember { mutableStateOf(false) }

    fun onAddBus(busName: String, busDescription: String) {
        val newBus = Bus(busName, busDescription, dateAdded = getFormattedDateString())
        Log.d("Add", "${newBus.name}, ${newBus.description}, ${newBus.dateAdded}")

        listState.add(newBus)
        saveListToStorage(context, "LocalBusList", listState)
    }

    fun onUpdateBus(bus: Bus, spotted: Boolean) {
        listState.forEach {
            if (it == bus) {
                it.spotted = spotted
                it.dateSpotted = getFormattedDateString()
            }
        }

        saveListToStorage(context, "LocalBusList", listState)
        Log.d("BusList", listState.toString())
    }

    fun onDeleteBus(bus: Bus) {
        Log.d("Bus", "Removed $bus.name")
        listState.remove(bus)
        saveListToStorage(context, "LocalBusList", listState)
        Log.d("BusList", listState.toString())
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(top = 80.dp)
        ) {
            listState.forEach { bus ->
                Log.d("Column", bus.toString())
                BusCard(bus, isAdmin.value, ::onUpdateBus, ::onDeleteBus)
            }
        }
        Header()
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = (-20).dp, y = (-30).dp)
        ) {
            FabArea(isAdmin, isModalOpen)
        }
        Modal(open = isModalOpen, ::onAddBus)
    }

}