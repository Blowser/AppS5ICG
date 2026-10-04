package com.example.apps5icg.funciones.textoavoz

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.apps5icg.componentes.AvatarApp
import com.example.apps5icg.componentes.BotonPrimario
import com.example.apps5icg.componentes.CampoTexto
import com.example.apps5icg.componentes.CardApp
import com.example.apps5icg.componentes.CardContenidoApp
import com.example.apps5icg.componentes.FondoDePantalla
import com.example.apps5icg.componentes.TituloApp
import com.example.apps5icg.ui.theme.AppS5ICGTheme
import com.example.apps5icg.ui.theme.ICGPurple
import com.example.apps5icg.ui.theme.ICGTurquoise
// Motor de Android para convertir texto en voz
import android.speech.tts.TextToSpeech
// Permite obtener el contexto actual de Android dentro de Compose
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
// Permite configurar el idioma del motor de voz
import java.util.Locale
// Permite ejecutar limpieza cuando la pantalla se destruye
import androidx.compose.runtime.DisposableEffect



@Composable
fun PantallaTextoAVoz(navController: NavHostController) {
// -----------------------------
// ESTADOS DE LA PANTALLA
// -----------------------------
// Guarda el texto ingresado por el usuario.
// Cada vez que cambia, Compose actualiza la interfaz.
    var texto by remember { mutableStateOf("") }
// -----------------------------
// CONTEXTO DE ANDROID
// -----------------------------
// Contexto necesario para utilizar servicios nativos
// de Android como TextToSpeech.
    val context = LocalContext.current
// Indica si la pantalla se está ejecutando
// dentro del Preview de Android Studio.
    val isInPreview = LocalInspectionMode.current
// -----------------------------
// MOTOR DE TEXTO A VOZ (TTS)
// -----------------------------
// Crea el motor que convertirá texto en audio.
// En Preview no se inicializa para evitar errores.
    val tts = remember {
        if (!isInPreview) TextToSpeech(context, null) else null
    }
// -----------------------------
// CONFIGURACIÓN DEL TTS
// -----------------------------
// Configura el idioma español y libera recursos
// cuando se abandona la pantalla.
    DisposableEffect(Unit) {
        tts?.language = Locale.forLanguageTag("es-ES")
        onDispose {
            tts?.stop()
            tts?.shutdown()
        }
    }
// -----------------------------
// INTERFAZ DE LA PANTALLA
// -----------------------------

    FondoDePantalla {

        CardApp{

            CardContenidoApp {

                // Avatar
                AvatarApp(backgroundColor = ICGTurquoise, iconColor = Color.White)

                // Título
                TituloApp(color = ICGPurple)

                // Campo de texto
                CampoTexto(
                    value = texto,
                    onValueChange = { texto = it },
                    placeholder = "Texto a reproducir",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = null,
                            tint = ICGTurquoise
                        )
                    },
                    keyboardType = KeyboardType.Text
                )

                Spacer(Modifier.height(30.dp))

                // Botón mostrar
                BotonPrimario(
                    text = "Reproducir voz",
                    onClick = {
// Evita reproducir si el campo está vacío
                        if (texto.isNotBlank()) {
// Convierte el texto escrito en voz
                            tts?.speak(
                                texto, // texto a reproducir
                                TextToSpeech.QUEUE_FLUSH, // limpia reproducciones anteriores
                                null, // parámetros extra
                                null // identificador opcional
                            )
                        }
                    }
                )
                BotonPrimario(
                    text = "Volver al Home",
                    onClick = {
                        navController.navigate("home")
                    }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewPantallaTextoAVoz() {
    AppS5ICGTheme {
        val navController = rememberNavController() // ← falsete
        PantallaTextoAVoz(navController)
    }
}