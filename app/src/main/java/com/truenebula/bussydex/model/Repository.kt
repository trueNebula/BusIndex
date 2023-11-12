package com.truenebula.bussydex.model

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.gson.Gson
import com.truenebula.bussydex.ui.views.serializeList
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.Date

class Repository : Serializable {
    var busList: MutableList<Bus> = mutableListOf()

    init {
        busList = mutableListOf()
    }

    private fun getLastId(): Number {
        Log.d("Size", busList.size.toString())
        return busList.size
    }

    fun getBus(id: Number): Bus? {
        busList.forEach {
            if (it.id == id) {
                return it
            }
        }
        return null
    }

    fun addBus(busName: String, busDescription: String): Bus {
        val id = getLastId()
        val newBus = Bus(id, busName, busDescription, dateAdded = getFormattedDateString())
        Log.d("Add", "${newBus.name}, ${newBus.description}, ${newBus.dateAdded}")

        busList.add(newBus)
        return newBus
    }

    fun addBusRaw(
        busName: String,
        busDescription: String,
        spotted: Boolean,
        dateAdded: String,
        dateSpotted: String
    ): Bus {
        val id = getLastId()
        val newBus = Bus(id, busName, busDescription, dateAdded = getFormattedDateString())
        Log.d("AddRaw", "${newBus.name}, ${newBus.description}, ${newBus.dateAdded}")

        busList.add(newBus)
        return newBus
    }

    fun updateBus(
        id: Number,
        busName: String,
        busDescription: String,
        spotted: Boolean,
        dateAdded: String,
        dateSpotted: String,
    ): Boolean {
        busList.forEach {
            if (it.id == id) {
                it.name = busName
                it.description = busDescription
                it.spotted = spotted
                it.dateAdded = dateAdded
                it.dateSpotted = dateSpotted

                return true
            }
        }
        return false
    }

    fun deleteBus(id: Number): Boolean {
        busList.forEach {
            if (it.id == id) {
                busList.remove(it)
                return true
            }
        }
        return false
    }

    @SuppressLint("SimpleDateFormat")
    fun getFormattedDateString(): String {
        val dateFormat = SimpleDateFormat("dd-MM-yyyy")
        return dateFormat.format(Date())
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

}