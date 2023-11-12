package com.truenebula.bussydex.ui.views

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.truenebula.bussydex.activities.MainActivity
import com.truenebula.bussydex.model.Repository
import com.truenebula.bussydex.ui.components.ViewHeader

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddBusView(repository: Repository) {
    val context = LocalContext.current
    var busName by remember { mutableStateOf("") }
    var busDescription by remember { mutableStateOf("") }
    var spotted by remember { mutableStateOf(false) }
    var dateAdded by remember { mutableStateOf("13/11/2023") }
    var dateSpotted by remember { mutableStateOf("01/01/1970") }

    fun onClickBack() {
        val intent = Intent(context, MainActivity::class.java)
        intent.putExtra("repo", repository)
        context.startActivity(intent)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            ViewHeader("Add Bus", ::onClickBack)
            OutlinedTextField(
                value = busName,
                onValueChange = { text -> busName = text.trimStart { it == '0' } },
                label = { Text(text = "Name...") },
                colors = TextFieldDefaults.textFieldColors(
                    focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
                    focusedIndicatorColor = MaterialTheme.colorScheme.onPrimary,
                    cursorColor = MaterialTheme.colorScheme.onPrimary,
                    containerColor = MaterialTheme.colorScheme.background,
                ),
            )
            OutlinedTextField(
                value = busDescription,
                onValueChange = { text -> busDescription = text.trimStart { it == '0' } },
                label = { Text(text = "Description...") },
                colors = TextFieldDefaults.textFieldColors(
                    focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
                    focusedIndicatorColor = MaterialTheme.colorScheme.onPrimary,
                    cursorColor = MaterialTheme.colorScheme.onPrimary,
                    containerColor = MaterialTheme.colorScheme.background,
                ),
            )
            Box(modifier = Modifier.width(120.dp)) {
                Text(text = "Spotted?", modifier = Modifier.align(Alignment.CenterStart))
                Checkbox(
                    checked = spotted,
                    onCheckedChange = {
                        spotted = it
                    },
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
            OutlinedTextField(
                value = dateAdded,
                onValueChange = { text -> dateAdded = text.trimStart { it == '0' } },
                label = { Text(text = "Date Added") },
                colors = TextFieldDefaults.textFieldColors(
                    focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
                    focusedIndicatorColor = MaterialTheme.colorScheme.onPrimary,
                    cursorColor = MaterialTheme.colorScheme.onPrimary,
                    containerColor = MaterialTheme.colorScheme.background,
                ),
            )
            OutlinedTextField(
                value = dateSpotted,
                onValueChange = { text -> dateSpotted = text.trimStart { it == '0' } },
                label = { Text(text = "Date Spotted") },
                colors = TextFieldDefaults.textFieldColors(
                    focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
                    focusedIndicatorColor = MaterialTheme.colorScheme.onPrimary,
                    cursorColor = MaterialTheme.colorScheme.onPrimary,
                    containerColor = MaterialTheme.colorScheme.background,
                ),
            )
            Button(onClick = {
                repository.addBusRaw(busName, busDescription, spotted, dateAdded, dateSpotted)
                Log.d("Added", repository.busList.toString())
                onClickBack()
            }) {
                Text(text = "+")
            }
        }
    }
}