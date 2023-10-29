package com.truenebula.bussydex.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Modal(
    open: MutableState<Boolean>,
    onAddBus: (busName: String, busDescription: String) -> Unit
) {
    var busName by remember { mutableStateOf("") }
    var busDescription by remember { mutableStateOf("") }

    if (open.value)
        Dialog(
            onDismissRequest = { open.value = false },
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
                    modifier = Modifier
                        .width(340.dp)
                        .height(550.dp)
                        .align(Alignment.Center)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(64.dp)
                    ) {
                        Text(
                            text = "Add Bus",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onPrimary,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.Center)
                        )
                        TextButton(
                            onClick = { open.value = false },
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                        ) {
                            Text(
                                text = "x",
                                color = MaterialTheme.colorScheme.onSecondary,
                                fontSize = 18.sp,
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(bottom = 20.dp)
                    ) {
                        // Inputs
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()

                        ) {
                            Column(
                                modifier = Modifier
                                    .height(400.dp)
                                    .align(Alignment.TopCenter),
                            ) {
                                OutlinedTextField(
                                    modifier = Modifier.padding(8.dp),
                                    colors = TextFieldDefaults.textFieldColors(
                                        focusedLabelColor = MaterialTheme.colorScheme.onSecondary,
                                        focusedIndicatorColor = MaterialTheme.colorScheme.onSecondary,
                                        cursorColor = MaterialTheme.colorScheme.onSecondary,
                                        containerColor = MaterialTheme.colorScheme.background,
                                    ),
                                    value = busName,
                                    onValueChange = { text ->
                                        busName = text.trimStart { it == '0' }
                                    },
                                    label = { Text("Name...") }
                                )
                                OutlinedTextField(
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .fillMaxHeight(),
                                    colors = TextFieldDefaults.textFieldColors(
                                        focusedLabelColor = MaterialTheme.colorScheme.onSecondary,
                                        focusedIndicatorColor = MaterialTheme.colorScheme.onSecondary,
                                        cursorColor = MaterialTheme.colorScheme.onSecondary,
                                        containerColor = MaterialTheme.colorScheme.background,
                                    ),
                                    value = busDescription,
                                    onValueChange = { text ->
                                        busDescription = text.trimStart { it == '0' }
                                    },
                                    label = { Text("Description...") }
                                )


                            }
                        }

                        // Button
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.BottomCenter)
                        ) {
                            Button(
                                onClick = {
                                    onAddBus(busName, busDescription)
                                    open.value = false
                                },
                                modifier = Modifier.align(Alignment.Center)

                            ) {
                                Text(
                                    text = "Add",
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