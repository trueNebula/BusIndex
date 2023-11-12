package com.truenebula.bussydex.ui.views

import android.content.Intent
import com.google.gson.Gson
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.truenebula.bussydex.activities.AddBusActivity
import com.truenebula.bussydex.activities.UpdateBusActivity
import com.truenebula.bussydex.ui.components.BusCard
import com.truenebula.bussydex.ui.components.FabArea
import com.truenebula.bussydex.ui.components.Header
import com.truenebula.bussydex.ui.components.Modal
import com.truenebula.bussydex.model.Bus
import com.truenebula.bussydex.model.Repository
import com.truenebula.bussydex.ui.components.DeleteModal

fun serializeList(list: List<Bus>): String {
    val gson = Gson()
    return gson.toJson(list)
}

@Composable
fun App(repository: Repository) {

    val context = LocalContext.current

//    repository.busList = repository.getListFromStorage(context, "LocalBusList")
    Log.d("Init repo", repository.busList.toString())
//    if (repository.busList.isEmpty()) {
//        repository.addBus("Bus 24B", "lmao desc\nlmaooo")
//        repository.addBus("Bus 35", "lmao desc2", true)
//        repository.saveListToStorage(context, "LocalBusList", repository.busList)
//    }

    val listState = remember { repository.busList.toMutableStateList() }
    val isAdmin = remember { mutableStateOf(false) }
    val isModalOpen = remember { mutableStateOf(false) }
    val isDeleteModalOpen = remember { mutableStateOf(false) }
    val selectedBusId = remember { mutableStateOf(-1) }

    fun onAddBus(busName: String, busDescription: String) {
        listState.add(repository.addBus(busName, busDescription))
//        repository.saveListToStorage(context, "LocalBusList", listState)
        Log.d("BusList", repository.busList.toString())

    }

    fun onUpdateBus(bus: Bus, spotted: Boolean) {
        Log.d("ID", bus.toString())
        repository.updateBus(
            bus.id,
            bus.name,
            bus.description,
            spotted,
            bus.dateAdded,
            repository.getFormattedDateString()
        )
//        repository.saveListToStorage(context, "LocalBusList", listState)
        Log.d("BusList", repository.busList.toString())
    }

    fun onUpdateRaw(bus: Bus) {
        val intent = Intent(context, UpdateBusActivity::class.java)
        intent.putExtra("repo", repository)
        intent.putExtra("id", bus.id)
        context.startActivity(intent)
    }

    fun onDeleteBus(id: Number) {
        Log.d("Bus", "Removed $id")
        repository.deleteBus(id)
        listState.removeIf {
            it.id == id
        }
//        repository.saveListToStorage(context, "LocalBusList", listState)
        Log.d("BusList", repository.busList.toString())
    }

    fun onClickDeleteCard(bus: Bus) {
        isDeleteModalOpen.value = true
        selectedBusId.value = bus.id as Int
        Log.d("deleteModal", isDeleteModalOpen.value.toString())
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(top = 80.dp)
        ) {
            listState.forEach { bus ->
                Log.d("Column", bus.toString())
                BusCard(bus, isAdmin.value, ::onUpdateBus, ::onUpdateRaw, ::onClickDeleteCard)
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
        Row {
            Button(onClick = {
                val intent = Intent(context, AddBusActivity::class.java)
                intent.putExtra("repo", repository)
                context.startActivity(intent)
            }) {
                Text(text = "Add")
            }
        }
        Modal(open = isModalOpen, ::onAddBus)
        DeleteModal(open = isDeleteModalOpen, selectedBusId, ::onDeleteBus)
    }

}