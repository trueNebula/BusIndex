package com.truenebula.bussydex.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.truenebula.bussydex.model.Repository
import com.truenebula.bussydex.ui.theme.Theme
import com.truenebula.bussydex.ui.views.App

class MainActivity : ComponentActivity() {
    var repository = Repository()
    override fun onCreate(savedInstanceState: Bundle?) {
        if (intent.hasExtra("repo")) {
            repository =  intent.getSerializableExtra("repo") as Repository
        }
        super.onCreate(savedInstanceState)

        setContent {
            Theme {
                App(repository)
            }
        }
    }
}
