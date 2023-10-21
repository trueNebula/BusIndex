package com.truenebula.bussydex.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.truenebula.bussydex.Bus

@Composable
fun Card(bus: Bus) {
    val spottedState = remember { mutableStateOf(bus.spotted) }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .padding(10.dp)
            .shadow(elevation = 12.dp, clip = true, shape = RoundedCornerShape(20.dp)),
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(20.dp)
                ),
            color = MaterialTheme.colorScheme.primaryContainer,
        ) {
            Row(
                modifier = Modifier
                    .padding(18.dp, 14.dp, 18.dp, 14.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(300.dp)
                        .height(102.dp)
//                        .background(Color.Magenta)

                ) {
                    Column {
                        Text(
                            text = bus.name,
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onPrimary,
                            textAlign = TextAlign.Left,
                            modifier = Modifier.padding(bottom = 2.dp),
                        )
                        Text(
                            text = bus.description,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onPrimary,
                            textAlign = TextAlign.Left,
                            modifier = Modifier.padding(top = 4.dp),
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(102.dp)
//                        .background(Color.Black)
                ) {
                    Checkbox(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .scale(1.6F),
                        colors = CheckboxDefaults.colors(
                            checkedColor = MaterialTheme.colorScheme.background,
                            uncheckedColor = MaterialTheme.colorScheme.background,
                            ),
                        checked = spottedState.value,
                        onCheckedChange = {
                            spottedState.value = !spottedState.value
                            bus.spotted = spottedState.value
                            Log.d("Bus Spotted State", bus.spotted.toString())
                        })
                }
            }
        }
    }
}