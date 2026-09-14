package com.example.apps5icg.pantallas.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
import com.example.apps5icg.componentes.LockGlyph
import com.example.apps5icg.componentes.MensajeInformacion
import com.example.apps5icg.componentes.TituloApp
import com.example.apps5icg.datos.usuarios
import com.example.apps5icg.ui.theme.AppS5ICGTheme
import com.example.apps5icg.ui.theme.ICGBlack
import com.example.apps5icg.ui.theme.ICGPurple
import com.example.apps5icg.ui.theme.ICGTurquoise

@Composable
fun PantallaLogin(navController: NavHostController) {

    // -----------------------------
    // ESTADOS DEL LOGIN
    // -----------------------------

    // Guarda el correo que el usuario escribe en el input
    var correo by remember { mutableStateOf("") }

    // Guarda la contraseña que el usuario escribe
    var contrasenha by remember { mutableStateOf("") }

    // Guarda el mensaje de error o éxito del login
    var mensaje by remember { mutableStateOf("") }


    // -----------------------------
    // FONDO DE LA PANTALLA (gradiente + padding)
    // -----------------------------
    FondoDePantalla {

        // -----------------------------
        // CARD PRINCIPAL (contenedor blanco/gris)
        // -----------------------------
        CardApp {

            // -----------------------------
            // CONTENIDO DEL CARD (padding interno + alineación)
            // -----------------------------
            CardContenidoApp {

                // Avatar circular con el logo de la app
                AvatarApp(backgroundColor = ICGTurquoise, iconColor = Color.White)

                // Título grande de la app
                TituloApp(color = ICGPurple)

                // Encabezado de la pantalla (título + subtítulo)
                EncabezadoApp(
                    titulo = "BIENVENIDO",
                    subtitulo = "Inicia Sesión para continuar"
                )


                // -----------------------------
                // CAMPO DE CORREO
                // -----------------------------

                // Etiqueta del campo
                EtiquetaCampo(text = "Correo electrónico")

                Spacer(Modifier.height(10.dp))

                // Input donde el usuario escribe su correo
                CampoTexto(
                    value = correo,                 // valor actual del input
                    onValueChange = { correo = it }, // actualiza el estado al escribir
                    placeholder = "ejemplo@correo.com",
                    leadingIcon = { EmailGlyph(color = ICGBlack) },
                    keyboardType = KeyboardType.Email
                )


                Spacer(Modifier.height(20.dp))


                // -----------------------------
                // FILA: "Contraseña" + "¿Olvidé mi contraseña?"
                // -----------------------------
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    // Etiqueta del campo de contraseña
                    EtiquetaCampo(text = "Contraseña")

                    // Enlace para ir a la pantalla de recuperación
                    Text(
                        text = "¿Olvidé mi contraseña?",
                        color = ICGTurquoise,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.clickable {
                            navController.navigate("recuperar")
                        }
                    )
                }


                Spacer(Modifier.height(10.dp))


                // -----------------------------
                // CAMPO DE CONTRASEÑA
                // -----------------------------
                CampoTexto(
                    value = contrasenha,                 // valor actual del input
                    onValueChange = { contrasenha = it }, // actualiza el estado al escribir
                    placeholder = "Contraseña",
                    leadingIcon = { LockGlyph(color = ICGBlack) },
                    keyboardType = KeyboardType.Password
                )


                Spacer(Modifier.height(30.dp))


                // -----------------------------
                // BOTÓN DE LOGIN
                // -----------------------------
                BotonPrimario(
                    text = "Iniciar sesión",
                    onClick = {

                        // Busca un usuario en la lista que coincida con correo + contraseña
                        val encontrado = usuarios.find {
                            it.correo == correo && it.contrasenha == contrasenha
                        }

                        // Si existe → login exitoso
                        if (encontrado != null) {
                            mensaje = "Inicio de sesión exitoso"
                            navController.navigate("home")

                            // Si no existe → credenciales incorrectas
                        } else {
                            mensaje = "Credenciales incorrectas"
                        }
                    }
                )


                Spacer(Modifier.height(10.dp))


                // -----------------------------
                // LINK PARA IR A REGISTRO
                // -----------------------------
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    EtiquetaCampo(text = "¡No tienes cuenta?")

                    Text(
                        text = "Registrate acá",
                        color = ICGTurquoise,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.clickable {
                            navController.navigate("registro")
                        }
                    )
                }


                // -----------------------------
                // MENSAJE DE ERROR / INFORMACIÓN
                // -----------------------------
                MensajeInformacion(texto = mensaje)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewPantallaLogin() {
    AppS5ICGTheme {
        val navController = rememberNavController() // ← FALSETE
        PantallaLogin(navController)
    }
}
