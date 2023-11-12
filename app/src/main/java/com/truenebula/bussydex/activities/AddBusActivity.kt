package com.truenebula.bussydex.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.truenebula.bussydex.model.Repository
import com.truenebula.bussydex.ui.theme.Theme
import com.truenebula.bussydex.ui.views.AddBusView

class AddBusActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository =  intent.getSerializableExtra("repo") as Repository
        Log.d("AddBusView", repository.busList.toString())
        setContent {
            Theme {
                AddBusView(repository)
            }
        }
    }

}

