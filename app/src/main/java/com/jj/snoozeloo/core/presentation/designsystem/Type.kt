package com.jj.snoozeloo.core.presentation.designsystem

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jj.snoozeloo.R

val montserrat = FontFamily(
    Font(
        R.font.montserrat_light,
        weight = FontWeight.Light),

    Font(R.font.montserrat_regular,
        weight = FontWeight.Normal),


    Font(R.font.montserrat_medium,
        weight = FontWeight.Medium),


    Font(R.font.montserrat_semibold,
        weight = FontWeight.SemiBold),


    Font(R.font.montserrat_bold,
        weight = FontWeight.Bold),
    )


val Typography = Typography(
    bodySmall = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 20.sp,
//        color = RuniqueGray
    ),
    bodyMedium = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 22.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),
    labelLarge = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 24.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = montserrat,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
//        color = RuniqueWhite
    ),
)