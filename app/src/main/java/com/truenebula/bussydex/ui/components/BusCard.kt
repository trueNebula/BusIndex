package com.truenebula.bussydex.ui.components

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.truenebula.bussydex.model.Bus

@Composable
fun BusCard(
    bus: Bus,
    isAdmin: Boolean = false,
    onUpdateBus: (input: Bus, spotted: Boolean) -> Unit,
    onUpdateRaw: (input: Bus) -> Unit,
    onDeleteBus: (input: Bus) -> Unit
) {
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
                    MaterialTheme.colorScheme.primaryContainer, shape = RoundedCornerShape(20.dp)
                ),
            color = MaterialTheme.colorScheme.primaryContainer,
        ) {
            Row(
                modifier = Modifier.padding(18.dp, 14.dp, 18.dp, 14.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(200.dp)
                        .height(102.dp)
                ) {
                    Column {
                        Text(
                            text = bus.name,
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onPrimary,
                            textAlign = TextAlign.Left,
                            maxLines = 1,
                        )
                        Text(
                            text = bus.description,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onPrimary,
                            textAlign = TextAlign.Left,
                            modifier = Modifier.padding(top = 2.dp),
                            maxLines = 2,
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(102.dp)
                ) {
                    androidx.compose.animation.AnimatedVisibility(
                        visible = !isAdmin,
                        enter = fadeIn(),
                        exit = fadeOut(),
                        modifier = Modifier.align(Alignment.Center)
                    ) {
                        Checkbox(modifier = Modifier
                            .scale(1.6F),
                            colors = CheckboxDefaults.colors(
                                checkedColor = MaterialTheme.colorScheme.background,
                                uncheckedColor = MaterialTheme.colorScheme.background,
                            ),
                            checked = spottedState.value,
                            onCheckedChange = {
                                spottedState.value = !spottedState.value
                                onUpdateBus(bus, spottedState.value)
                            })
                    }

                    androidx.compose.animation.AnimatedVisibility(
                        visible = isAdmin,
                        enter = fadeIn(),
                        exit = fadeOut(),
                        modifier = Modifier.align(Alignment.Center)
                    ) {
                        Row() {
                            TextButton(
                                onClick = { onUpdateRaw(bus) },
                                modifier = Modifier
                            ) {
                                Text(
                                    text = "\uF0AD", style = MaterialTheme.typography.headlineMedium,
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    textAlign = TextAlign.Center
                                )
                            }
                            TextButton(
                                onClick = { onDeleteBus(bus) },
                                modifier = Modifier
                            ) {
                                Text(
                                    text = "\uF1F8", style = MaterialTheme.typography.headlineMedium,
                                    color = Color(0xFFFF0000),
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }

                }
            }
        }
    }
}
