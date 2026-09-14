package com.example.apps5icg.funciones.escribirymostrar

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


@Composable
fun PantallaEscribir(navController: NavHostController) {

    var texto by remember { mutableStateOf("") }

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
                    placeholder = "Escribe tu mensaje aquí",
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
                    text = "Mostrar en pantalla",
                    onClick = {
                        navController.navigate("mostrar?mensaje=$texto")
                    }
                )

                BotonPrimario(
                    text = "Volver al Home",
                    onClick = { navController.navigate("home") }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewPantallaEscribir() {
    AppS5ICGTheme {
        val navController = rememberNavController() // ← falsete
        PantallaEscribir(navController)
    }
}