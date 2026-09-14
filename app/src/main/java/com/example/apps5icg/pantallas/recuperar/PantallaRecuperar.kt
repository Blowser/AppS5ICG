package com.example.apps5icg.pantallas.recuperar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.apps5icg.componentes.AvatarApp
import com.example.apps5icg.componentes.BotonPrimario
import com.example.apps5icg.componentes.CampoTexto
import com.example.apps5icg.componentes.CardApp
import com.example.apps5icg.componentes.CardContenidoApp
import com.example.apps5icg.componentes.EmailGlyph
import com.example.apps5icg.componentes.EncabezadoApp
import com.example.apps5icg.componentes.EtiquetaCampo
import com.example.apps5icg.componentes.FondoDePantalla
import com.example.apps5icg.componentes.MensajeInformacion
import com.example.apps5icg.componentes.TituloApp
import com.example.apps5icg.datos.usuarios

import com.example.apps5icg.ui.theme.AppS5ICGTheme
import com.example.apps5icg.ui.theme.ICGBlack
import com.example.apps5icg.ui.theme.ICGPurple
import com.example.apps5icg.ui.theme.ICGTurquoise


@Composable
fun PantallaRecuperar(navController: NavHostController) {


    // ESTADOS DEL FORMULARIO
    // Guarda el correo que el usuario escribe
    var correo by remember { mutableStateOf("") }

    // Guarda el mensaje de éxito o error
    var mensaje by remember { mutableStateOf("") }


    // FONDO DE PANTALLA (gradiente + padding)
    FondoDePantalla {

        // CARD PRINCIPAL
        CardApp {

            // CONTENIDO DEL CARD

            CardContenidoApp {

                // Ícono superior
                AvatarApp(backgroundColor = ICGTurquoise, iconColor = Color.White)

                // Título de la app
                TituloApp(color = ICGPurple)

                // Encabezado de la pantalla
                EncabezadoApp(
                    titulo = "REESTABLECER CONTRASEÑA",
                    subtitulo = "Ingresa tu correo para recuperar tu clave"
                )

                // INPUT: Correo electrónico
                EtiquetaCampo(text = "Correo electrónico")
                Spacer(Modifier.height(10.dp))

                CampoTexto(
                    value = correo,                 // valor actual del input
                    onValueChange = { correo = it }, // actualiza el estado al escribir
                    placeholder = "ejemplo@correo.com",
                    leadingIcon = { EmailGlyph(color = ICGBlack) },
                    keyboardType = KeyboardType.Email
                )


                Spacer(Modifier.height(30.dp))


                // BOTÓN: Buscar usuario
                BotonPrimario(
                    text = "Confirmar",
                    onClick = {

                        // Busca un usuario con ese correo
                        val encontrado = usuarios.find { it.correo == correo }

                        // Si existe → mensaje de éxito
                        mensaje = if (encontrado != null) {
                            "Se envió un correo para recuperar su contraseña"
                        } else {
                            "No se encontró un usuario con el correo proporcionado"
                        }
                    }
                )


                Spacer(Modifier.height(10.dp))


                // LINK: Volver al login
                Text(
                    text = "Volver al inicio",
                    color = ICGTurquoise,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.clickable {
                        navController.navigate("login")
                    }
                )



                // MENSAJE DE ERROR / ÉXITO
                MensajeInformacion(texto = mensaje)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewPantallaRecuperar() {
    AppS5ICGTheme {
        val navController = rememberNavController() // ← falsete
        PantallaRecuperar(navController)
    }
}

