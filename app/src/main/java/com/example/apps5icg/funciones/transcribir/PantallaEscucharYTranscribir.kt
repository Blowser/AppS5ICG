package com.example.apps5icg.funciones.transcribir

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController



import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
import com.example.apps5icg.componentes.FondoDePantalla
import com.example.apps5icg.componentes.TituloApp
import com.example.apps5icg.ui.theme.AppS5ICGTheme
import com.example.apps5icg.ui.theme.ICGBlack
import com.example.apps5icg.ui.theme.ICGPurple
import com.example.apps5icg.ui.theme.ICGTurquoise
import com.example.apps5icg.componentes.MicGlyph

import android.app.Activity
import android.content.Intent
import android.speech.RecognizerIntent

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.ui.platform.LocalInspectionMode


@Composable
fun PantallaEscucharYTranscribir(
    navController: NavHostController
) {

    // -----------------------------
    // ESTADOS DE LA PANTALLA
    // -----------------------------

    // Guarda el texto reconocido por el micrófono.
    var textoTranscrito by remember {
        mutableStateOf("")
    }



// Detecta si estamos en Preview.
    val isInPreview = LocalInspectionMode.current

// -----------------------------
// RECONOCEDOR DE VOZ
// -----------------------------

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->

        if (result.resultCode == Activity.RESULT_OK) {

            val datos = result.data
                ?.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS
                )

            textoTranscrito = datos?.firstOrNull() ?: ""
        }
    }

    val intentReconocimiento = remember {

        Intent(
            RecognizerIntent.ACTION_RECOGNIZE_SPEECH
        ).apply {

            putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
            )

            putExtra(
                RecognizerIntent.EXTRA_LANGUAGE,
                "es-CL"
            )

            putExtra(
                RecognizerIntent.EXTRA_PROMPT,
                "Habla ahora..."
            )
        }
    }

    // -----------------------------
    // INTERFAZ DE LA PANTALLA
    // -----------------------------

    FondoDePantalla {

        CardApp {

            CardContenidoApp {

                // Avatar
                AvatarApp(
                    backgroundColor = ICGTurquoise,
                    iconColor = Color.White
                )

                // Título
                TituloApp(
                    color = ICGPurple
                )

                // Campo donde aparecerá la transcripción.
                CampoTexto(
                    value = textoTranscrito,
                    onValueChange = {},
                    placeholder = "Aquí aparecerá el texto escuchado",
                    leadingIcon = {
                        MicGlyph(color = ICGBlack)
                    },
                    keyboardType = KeyboardType.Text
                )

                Spacer(
                    modifier = Modifier.height(30.dp)
                )

                // Inicia el reconocimiento de voz.
                BotonPrimario(
                    text = "Escuchar",
                    onClick = {

                        // Evita ejecutar funciones reales
                        // cuando se renderiza el Preview.
                        if (!isInPreview) {
                            launcher.launch(
                                intentReconocimiento
                            )
                        }
                    }
                )

                // Regresa al menú principal.
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
