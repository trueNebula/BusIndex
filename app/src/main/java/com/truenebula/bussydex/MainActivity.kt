package com.truenebula.bussydex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.truenebula.bussydex.ui.theme.Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Theme {
                App()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    Theme {
        App()
    }
}