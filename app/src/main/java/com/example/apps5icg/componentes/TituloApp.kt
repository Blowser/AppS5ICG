package com.example.apps5icg.componentes

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apps5icg.ui.theme.ICGPurple


@Composable
fun TituloApp(
    texto: String = "ComunicApp",
    color: Color = ICGPurple
) {
    Text(
        text = texto,
        color = color,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 1.sp
    )

    Spacer(Modifier.height(30.dp))
}

