package com.example.apps5icg.pantallas.registro

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
import com.example.apps5icg.componentes.EmailGlyph
import com.example.apps5icg.componentes.EncabezadoApp
import com.example.apps5icg.componentes.EtiquetaCampo
import com.example.apps5icg.componentes.FondoDePantalla
import com.example.apps5icg.componentes.IdGlyph
import com.example.apps5icg.componentes.LockGlyph
import com.example.apps5icg.componentes.PhoneGlyph
import com.example.apps5icg.componentes.TituloApp
import com.example.apps5icg.ui.theme.AppS5ICGTheme
import com.example.apps5icg.ui.theme.ICGBlack
import com.example.apps5icg.ui.theme.ICGPurple
import com.example.apps5icg.ui.theme.ICGTurquoise

import com.example.apps5icg.componentes.MensajeInformacion
import com.example.apps5icg.componentes.UserGlyph
import com.example.apps5icg.data.UserRepository
@Composable
fun PantallaRegistro(navController: NavHostController) {

    // -----------------------------
    // ESTADOS DE LOS CAMPOS
    // -----------------------------

    var nombre by remember { mutableStateOf("") }
    var rut by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var contrasenha by remember { mutableStateOf("") }
    var confirmarContrasenha by remember { mutableStateOf("") }

    // Mensaje de error o éxito
    var mensaje by remember { mutableStateOf("") }


    // -----------------------------
    // FONDO DE PANTALLA
    // -----------------------------
    FondoDePantalla {
        // -----------------------------
        //FIX DE SCROLL PARA CELULARES O PANTALLAS PEQUEÑAS
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // -----------------------------
            // CARD PRINCIPAL
            // -----------------------------
            CardApp {

                // -----------------------------
                // CONTENIDO DEL CARD
                // -----------------------------
                CardContenidoApp {

                    // Avatar superior
                    AvatarApp(backgroundColor = ICGTurquoise, iconColor = Color.White)

                    // Título de la app
                    TituloApp(color = ICGPurple)

                    // Encabezado de la pantalla
                    EncabezadoApp(
                        titulo = "BIENVENIDO",
                        subtitulo = "Regístrate en nuestra App"
                    )


                    // -----------------------------
                    // INPUT: Nombre

                    EtiquetaCampo(text = "Nombre")
                    Spacer(Modifier.height(10.dp))
                    CampoTexto(
                        value = nombre,
                        onValueChange = { nombre = it },
                        placeholder = "Tu nombre completo",
                        leadingIcon = { UserGlyph(color = ICGBlack) },
                        keyboardType = KeyboardType.Text
                    )

                    Spacer(Modifier.height(20.dp))


                    // -----------------------------
                    // INPUT: Rut

                    EtiquetaCampo(text = "RUT")
                    Spacer(Modifier.height(10.dp))
                    CampoTexto(
                        value = rut,
                        onValueChange = { rut = it },
                        placeholder = "12345678-9",
                        leadingIcon = { IdGlyph(color = ICGBlack) },
                        keyboardType = KeyboardType.Text
                    )

                    Spacer(Modifier.height(20.dp))


                    // -----------------------------
                    // INPUT: Correo

                    EtiquetaCampo(text = "Correo electrónico")
                    Spacer(Modifier.height(10.dp))
                    CampoTexto(
                        value = correo,
                        onValueChange = { correo = it },
                        placeholder = "ejemplo@correo.com",
                        leadingIcon = { EmailGlyph(color = ICGBlack) },
                        keyboardType = KeyboardType.Email
                    )

                    Spacer(Modifier.height(20.dp))


                    // -----------------------------
                    // INPUT: Teléfono

                    EtiquetaCampo(text = "Teléfono")
                    Spacer(Modifier.height(10.dp))
                    CampoTexto(
                        value = telefono,
                        onValueChange = { telefono = it },
                        placeholder = "987654321",
                        leadingIcon = { PhoneGlyph(color = ICGBlack) },
                        keyboardType = KeyboardType.Phone
                    )

                    Spacer(Modifier.height(20.dp))


                    // -----------------------------
                    // INPUT: Contraseña

                    EtiquetaCampo(text = "Crear contraseña")
                    Spacer(Modifier.height(10.dp))
                    CampoTexto(
                        value = contrasenha,
                        onValueChange = { contrasenha = it },
                        placeholder = "Crear contraseña",
                        leadingIcon = { LockGlyph(color = ICGBlack) },
                        keyboardType = KeyboardType.Password
                    )

                    Spacer(Modifier.height(20.dp))


                    // -----------------------------
                    // INPUT: Confirmar contraseña

                    EtiquetaCampo(text = "Confirmar contraseña")
                    Spacer(Modifier.height(10.dp))
                    CampoTexto(
                        value = confirmarContrasenha,
                        onValueChange = { confirmarContrasenha = it },
                        placeholder = "Confirmar contraseña",
                        leadingIcon = { LockGlyph(color = ICGBlack) },
                        keyboardType = KeyboardType.Password
                    )

                    Spacer(Modifier.height(30.dp))


                    // -----------------------------
                    // BOTÓN: Registrar usuario

                    BotonPrimario(
                        text = "Crear cuenta",
                        onClick = {

                            when {

                                nombre.isEmpty() ||
                                        rut.isEmpty() ||
                                        correo.isEmpty() ||
                                        telefono.isEmpty() ||
                                        contrasenha.isEmpty() ||
                                        confirmarContrasenha.isEmpty() -> {

                                    mensaje = "Todos los campos son obligatorios"
                                }

                                !correo.contains("@") -> {

                                    mensaje = "Correo electrónico no válido"
                                }

                                contrasenha.length < 8 -> {

                                    mensaje = "La contraseña debe tener al menos 8 caracteres"
                                }

                                contrasenha != confirmarContrasenha -> {

                                    mensaje = "Las contraseñas no coinciden"
                                }

                                else -> {

                                    UserRepository.registerUser(
                                        nombre = nombre,
                                        rut = rut,
                                        correo = correo,
                                        telefono = telefono,
                                        contrasenha = contrasenha,

                                        onSuccess = {

                                            mensaje =
                                                "Usuario registrado exitosamente"

                                            navController.navigate("login")
                                        },

                                        onError = {

                                            mensaje = it
                                        }
                                    )
                                }
                            }
                        }
                    )


                    // -----------------------------
                    // MENSAJE DE ERROR / ÉXITO

                    MensajeInformacion(texto = mensaje)
                }
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun PreviewPantallaRegistro() {
    AppS5ICGTheme {
        val navController = rememberNavController() // ← falsete
        PantallaRegistro(navController)
    }
}
