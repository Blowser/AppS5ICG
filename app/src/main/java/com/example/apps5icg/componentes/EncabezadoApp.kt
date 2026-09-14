package com.example.apps5icg.componentes

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EncabezadoApp(
    titulo: String,
    subtitulo: String,
    colorTitulo: Color = MaterialTheme.colorScheme.onSurface,
    colorSubtitulo: Color = MaterialTheme.colorScheme.onSurface,
    tamanhoTitulo: TextUnit = 30.sp,
    tamanhoSubtitulo: TextUnit = 16.sp,
    espacioFinal: Dp = 40.dp
) {
    Text(
        text = titulo,
        color = colorTitulo,
        fontSize = tamanhoTitulo,
        fontWeight = FontWeight.Bold,
        letterSpacing = 1.sp
    )

    Spacer(Modifier.height(10.dp))

    Text(
        text = subtitulo,
        color = colorSubtitulo,
        fontSize = tamanhoSubtitulo,
        fontWeight = FontWeight.Normal,
        letterSpacing = 1.sp
    )

    Spacer(Modifier.height(espacioFinal))
}
