package com.truenebula.bussydex.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.truenebula.bussydex.model.Repository
import com.truenebula.bussydex.ui.theme.Theme
import com.truenebula.bussydex.ui.views.UpdateBusView

class UpdateBusActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = intent.getSerializableExtra("repo") as Repository
        val id = intent.getSerializableExtra("id") as Number
        Log.d("AddBusView", repository.busList.toString())
        setContent {
            Theme {
                UpdateBusView(repository, id)
            }
        }
    }

}
