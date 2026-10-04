package com.example.apps5icg.funciones.transcribir

import android.speech.tts.TextToSpeech
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.ui.Modifier

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.navigation.compose.rememberNavController
import com.example.apps5icg.componentes.AvatarApp
import com.example.apps5icg.componentes.BotonPrimario
import com.example.apps5icg.componentes.CampoTexto
import com.example.apps5icg.componentes.CardApp
import com.example.apps5icg.componentes.CardContenidoApp
import com.example.apps5icg.componentes.EmailGlyph
import com.example.apps5icg.componentes.FondoDePantalla
import com.example.apps5icg.componentes.TituloApp
import com.example.apps5icg.funciones.textoavoz.PantallaTextoAVoz
import com.example.apps5icg.ui.theme.AppS5ICGTheme
import com.example.apps5icg.ui.theme.ICGBlack
import com.example.apps5icg.ui.theme.ICGPurple
import com.example.apps5icg.ui.theme.ICGTurquoise

@Composable
fun PantallaEscucharYTranscribir(navController: NavHostController)  {
    // ESTADOS DE LA PANTALLA
// -----------------------------
// Guarda el texto ingresado por el usuario.
// Cada vez que cambia, Compose actualiza la interfaz.
    var textoTranscrito by remember {
        mutableStateOf("")
    }
    FondoDePantalla {

        CardApp{

            CardContenidoApp {

                // Avatar
                AvatarApp(backgroundColor = ICGTurquoise, iconColor = Color.White)

                // Título
                TituloApp(color = ICGPurple)

                CampoTexto(
                    value = textoTranscrito,                 // valor actual del input
                    onValueChange = {}, //
                    placeholder = "texto transcrito",
                    leadingIcon = { MicGlyph(color = ICGBlack) },
                    keyboardType = KeyboardType.Email
                )



                Spacer(Modifier.height(30.dp))

                // Botón mostrar
                BotonPrimario(
                    text = "Escuchar",
                    onClick = {
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
fun PreviewPantallaEscucharYTranscribir() {
    AppS5ICGTheme {
        val navController = rememberNavController() // ← falsete
        PantallaEscucharYTranscribir(navController)
    }
}
