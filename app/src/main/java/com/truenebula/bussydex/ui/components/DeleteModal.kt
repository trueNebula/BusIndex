package com.truenebula.bussydex.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun DeleteModal(
    open: MutableState<Boolean>,
    id: MutableState<Int>,
    onDeleteBus: (id: Number) -> Unit
) {
    if (open.value) {
        Dialog(
            onDismissRequest = { open.value = false },
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
                    modifier = Modifier
                        .width(300.dp)
                        .height(130.dp)
                        .align(Alignment.Center)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(64.dp)
                    ) {
                        Text(
                            text = "Are you sure?",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onPrimary,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 40.dp, vertical = 10.dp)
                    ) {
                        Button(
                            onClick = {
                                onDeleteBus(id.value)
                                open.value = false
                            },
                            modifier = Modifier.align(Alignment.BottomStart)
                        ) {
                            Text(
                                text = "Yes",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onPrimary,
                                textAlign = TextAlign.Center,
                            )
                        }
                        Button(
                            onClick = {
                                open.value = false
                            },
                            modifier = Modifier.align(Alignment.BottomEnd)
                        ) {
                            Text(
                                text = "No",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onPrimary,
                                textAlign = TextAlign.Center,
                            )
                        }
                    }
                }
            }

        }
    }
}
