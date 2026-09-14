package com.example.apps5icg.pantallas.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.apps5icg.componentes.BotonPrimario
import com.example.apps5icg.componentes.AvatarApp
import com.example.apps5icg.componentes.CardApp
import com.example.apps5icg.componentes.CardContenidoApp
import com.example.apps5icg.componentes.EncabezadoApp
import com.example.apps5icg.componentes.FondoDePantalla
import com.example.apps5icg.componentes.TituloApp
import com.example.apps5icg.ui.theme.AppS5ICGTheme
import com.example.apps5icg.ui.theme.ICGPurple
import com.example.apps5icg.ui.theme.ICGTurquoise


@Composable
fun PantallaHome(navController: NavHostController) {

    // FONDO DE PANTALLA (gradiente)
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
                    titulo = "HOME",
                    subtitulo = "Elije una función"
                )
                
                // BOTÓN: Escribir y mostrar
                BotonPrimario(
                    text = "Escribir y mostrar",
                    onClick = { navController.navigate("escribir") }
                )

                Spacer(Modifier.height(30.dp))

                // BOTÓN: Escuchar y transcribir
                BotonPrimario(
                    text = "Escuchar y transcribir",
                    onClick = { /* funcionalidad futura */ }
                )

                Spacer(Modifier.height(30.dp))

                // BOTÓN: Texto a voz
                BotonPrimario(
                    text = "Texto a voz",
                    onClick = { /* funcionalidad futura */ }
                )

                Spacer(Modifier.height(40.dp))

                // BOTÓN: Cerrar sesión
                BotonPrimario(
                    text = "Cerrar sesión",
                    onClick = {
                        // Vuelve al login
                        navController.navigate("login")
                    }
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewPantallaHome() {
    AppS5ICGTheme {
        val navController = rememberNavController() // ← falsete
        PantallaHome(navController)
    }
}