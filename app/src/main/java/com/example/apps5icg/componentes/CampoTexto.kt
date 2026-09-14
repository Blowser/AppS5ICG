package com.example.apps5icg.componentes


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apps5icg.ui.theme.ICGGray
import com.example.apps5icg.ui.theme.ICGTurquoise

@Composable
fun EtiquetaCampo(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        color = MaterialTheme.colorScheme.onSurface,
        fontSize = 15.sp,
        fontWeight = FontWeight.Medium,
        modifier = modifier
    )
}

@Composable
fun CampoTexto( // campo de texto compartido por todas las pantallas del flujo de autenticación
    value: String, // texto actual del campo (estado controlado desde afuera)
    onValueChange: (String) -> Unit, // callback que se dispara al escribir
    placeholder: String, // texto de ejemplo que se muestra cuando el campo está vacío
    leadingIcon: @Composable () -> Unit, // ícono a la izquierda (email, candado, persona, teléfono, etc.)
    keyboardType: KeyboardType, // tipo de teclado a mostrar (Email, Password, Phone, Text)
    modifier: Modifier = Modifier, // modifier adicional, sin restricciones por defecto
    visualTransformation: VisualTransformation = VisualTransformation.None, // sin transformación por defecto (texto visible)
    trailingIcon: (@Composable () -> Unit)? = null, // ícono opcional a la derecha (ej. mostrar/ocultar contraseña)
    containerColor: Color = ICGGray, // color de fondo del campo (celeste por defecto, estilo login)
    borderColor: Color = Color.Transparent // color de borde (transparente por defecto, sin borde visible)
){
    OutlinedTextField(
        value = value, // texto mostrado dentro del campo
        onValueChange = onValueChange, // se reenvía el callback recibido
        modifier = modifier
            .fillMaxWidth() // el campo ocupa todo el ancho del contenedor
            .clip(RoundedCornerShape(14.dp)), // recorta las esquinas antes de dibujar el fondo
        placeholder = { Text(text = placeholder, color = ICGTurquoise) }, // texto de ejemplo en gris
        leadingIcon = leadingIcon, // ícono izquierdo recibido por parámetro
        trailingIcon = trailingIcon, // ícono derecho recibido por parámetro (puede ser null)
        singleLine = true, // el campo no permite saltos de línea
        visualTransformation = visualTransformation, // aplica la transformación recibida (ej. ocultar contraseña)
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType), // configura el teclado según el tipo de dato
        shape = RoundedCornerShape(14.dp), // misma forma redondeada usada en el clip
        colors = OutlinedTextFieldDefaults.colors( // personaliza los colores por defecto de Material3
            focusedContainerColor = containerColor, // fondo cuando el campo tiene foco
            unfocusedContainerColor = containerColor, // fondo cuando el campo no tiene foco
            disabledContainerColor = containerColor, // fondo cuando el campo está deshabilitado
            focusedBorderColor = borderColor, // color de borde con foco
            unfocusedBorderColor = borderColor // color de borde sin foco
        )
    )
}