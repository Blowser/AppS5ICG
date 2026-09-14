package com.example.apps5icg.componentes

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apps5icg.ui.theme.ICGTurquoise


@Composable
fun BotonPrimario( // botón compartido por todas las pantallas del flujo de autenticación
    text: String, // texto a mostrar, ej. "Iniciar sesión"
    onClick: () -> Unit, // callback que se dispara al tocar el botón
    modifier: Modifier = Modifier, // modifier adicional, sin restricciones por defecto
    containerColor: Color = ICGTurquoise, // color de fondo del botón (teal oscuro por defecto)
    showArrowIcon: Boolean = true // controla si se dibuja la flecha a la derecha del texto
) {
    Button(
        onClick = onClick, // se reenvía el callback recibido
        modifier = modifier
            .fillMaxWidth() // el botón ocupa todo el ancho del contenedor
            .height(52.dp), // altura fija del botón
        shape = RoundedCornerShape(14.dp), // esquinas redondeadas
        colors = ButtonDefaults.buttonColors( // personaliza los colores por defecto de Material3
            containerColor = containerColor, // color de fondo recibido por parámetro
            contentColor = Color.White // color de texto/ícono, siempre blanco
        )
    ) {
        Text(text = text, fontSize = 16.sp, fontWeight = FontWeight.SemiBold) // texto del botón
        if (showArrowIcon) { // solo se agrega la flecha si el llamador la pidió (por defecto sí)
            Spacer(modifier = Modifier.width(8.dp)) // separación entre el texto y la flecha
            ArrowForwardGlyph(color = Color.White) // ícono de flecha, dibujado en blanco
        }
    }
}