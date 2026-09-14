package com.example.apps5icg.componentes

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.ConnectWithoutContact
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color


@Composable
fun LogoGlyph(
    color: Color,
    modifier: Modifier = Modifier,
    size: Dp = 24.dp)
{Icon(imageVector = Icons.Default.ConnectWithoutContact, contentDescription = null, tint = color, modifier = Modifier.size(size))

}

@Composable
fun EmailGlyph(color: Color, modifier: Modifier = Modifier, size: Dp = 20.dp) { // ícono de sobre para el campo de correo
    Icon(imageVector = Icons.Default.Email, contentDescription = null, tint = color, modifier = modifier.size(size))
}

@Composable
fun LockGlyph(color: Color, modifier: Modifier = Modifier, size: Dp = 20.dp) { // ícono de candado para el campo de contraseña
    Icon(imageVector = Icons.Default.Lock, contentDescription = null, tint = color, modifier = modifier.size(size))
}

@Composable
fun EyeGlyph(color: Color, open: Boolean, modifier: Modifier = Modifier, size: Dp = 20.dp) { // ícono de ojo para mostrar/ocultar la contraseña
    val icon = if (open) Icons.Default.Visibility else Icons.Default.VisibilityOff // ojo abierto si la contraseña es visible, cerrado si está oculta
    Icon(imageVector = icon, contentDescription = null, tint = color, modifier = modifier.size(size))
}

@Composable
fun ArrowForwardGlyph(color: Color, modifier: Modifier = Modifier, size: Dp = 18.dp) { // flecha hacia la derecha, usada en los botones principales
    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null, tint = color, modifier = modifier.size(size))
}

@Composable
fun ArrowBackGlyph(color: Color, modifier: Modifier = Modifier, size: Dp = 20.dp) { // flecha hacia la izquierda, usada para "volver"
    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, tint = color, modifier = modifier.size(size))
}

@Composable
fun PersonGlyph(color: Color, modifier: Modifier = Modifier, size: Dp = 20.dp) { // ícono de persona para el campo "Nombre Completo"
    Icon(imageVector = Icons.Default.Person, contentDescription = null, tint = color, modifier = modifier.size(size))
}

@Composable
fun PhoneGlyph(color: Color, modifier: Modifier = Modifier, size: Dp = 20.dp) { // ícono de teléfono para el campo "Teléfono"
    Icon(imageVector = Icons.Default.Phone, contentDescription = null, tint = color, modifier = modifier.size(size))
}
@Composable
fun UserGlyph(
    color: Color,
    modifier: Modifier = Modifier,
    size: Dp = 20.dp
) {
    Icon(
        imageVector = Icons.Default.Person,
        contentDescription = null,
        tint = color,
        modifier = modifier.size(size)
    )
}
@Composable
fun IdGlyph(
    color: Color,
    modifier: Modifier = Modifier,
    size: Dp = 20.dp
) {
    Icon(
        imageVector = Icons.Default.Badge,
        contentDescription = null,
        tint = color,
        modifier = modifier.size(size)

    )
}


