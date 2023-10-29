package com.truenebula.bussydex.components

import android.util.Log
import android.view.MotionEvent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun FabArea(open: MutableState<Boolean>, isModalOpen: MutableState<Boolean>) {

    Box(
        modifier = Modifier
            .height(144.dp)
            .width(80.dp)
    ) {
        Box(modifier = Modifier.align(Alignment.BottomCenter).scale(1.2F)) {
            FAB(open)
        }

        Box(modifier = Modifier.align(Alignment.TopCenter).scale(1.2F)) {
            AnimatedVisibility(
                visible = open.value,
                enter = fadeIn() + slideInVertically { 80 },
                exit = fadeOut() + slideOutVertically { 80 },
            ) {
                FabExtra(isModalOpen)
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FAB(open: MutableState<Boolean>) {
    val clicked = remember {
        mutableStateOf(false)
    }

    val scale =
        animateFloatAsState(targetValue = if (clicked.value) 0.9F else 1F, label = "scale")
    val textRotation =
        animateFloatAsState(targetValue = if (open.value) 135F else 0F, label = "rot")

    FloatingActionButton(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.background,
        shape = CircleShape,
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp
        ),
        modifier = Modifier
            .scale(scale.value)
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        clicked.value = true
                    }
                    MotionEvent.ACTION_UP -> {
                        clicked.value = false
                        open.value = !open.value
                    }
                }
                true
            },
        onClick = {

        },
    ) {
        AnimatedVisibility(visible = !open.value, enter = fadeIn(), exit = fadeOut()) {
            Text(
                text = "\uF0AD",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .rotate(textRotation.value),
                textAlign = TextAlign.Center,
            )
        }

        AnimatedVisibility(visible = open.value, enter = fadeIn(), exit = fadeOut()) {
            Text(
                text = "+",
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 48.sp,
                modifier = Modifier
                    .rotate(textRotation.value),
                textAlign = TextAlign.Center,
            )
        }


    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FabExtra(isModalOpen: MutableState<Boolean>) {
    val clicked = remember {
        mutableStateOf(false)
    }

    val scale =
        animateFloatAsState(targetValue = if (clicked.value) 0.9F else 1F, label = "scale")

    FloatingActionButton(
        onClick = {  },
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.background,
        shape = CircleShape,
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp
        ),
        modifier = Modifier
            .scale(scale.value)
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        clicked.value = true
                    }

                    MotionEvent.ACTION_UP -> {
                        clicked.value = false
                        isModalOpen.value = true
                        Log.d("modal", isModalOpen.value.toString())
                    }
                }
                true
            },
    ) {
        Text(
            text = "+",
            style = MaterialTheme.typography.headlineMedium,
            fontSize = 48.sp,
            textAlign = TextAlign.Center
        )
    }
}