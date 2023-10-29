package com.truenebula.bussydex.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.truenebula.bussydex.R

val alataFamily = FontFamily(
    Font(R.font.alata, FontWeight.Normal),
)

val basicFamily = FontFamily(
    Font(R.font.basic, FontWeight.Normal),
)

val faFamily = FontFamily(
    Font(R.font.fa5_solid, FontWeight.Normal),
)

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = alataFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 15.sp,
        letterSpacing = 0.5.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = alataFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 15.sp,
        letterSpacing = 0.5.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = basicFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    bodySmall = TextStyle(
        fontFamily = basicFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 25.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = faFamily,
        fontWeight = FontWeight(900),
        fontSize = 32.sp,
        lineHeight = 25.sp,
        letterSpacing = 0.sp,
        shadow = Shadow(Color(0x66130E01), offset = Offset(0.0f, 5.0f), blurRadius = 3f)
    ),
    headlineLarge = TextStyle(
        fontFamily = faFamily,
        fontWeight = FontWeight(900),
        fontSize = 32.sp,
        lineHeight = 0.sp,
        letterSpacing = 0.sp,
        shadow = Shadow(Color(0x66130E01), offset = Offset(5f, -5f), blurRadius = 3f)
    )
)