package com.example.apps5icg.funciones.escribirymostrar

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.apps5icg.componentes.AvatarApp
import com.example.apps5icg.componentes.BotonPrimario
import com.example.apps5icg.componentes.CardApp
import com.example.apps5icg.componentes.CardContenidoApp
import com.example.apps5icg.componentes.FondoDePantalla
import com.example.apps5icg.componentes.TituloApp
import com.example.apps5icg.ui.theme.AppS5ICGTheme
import com.example.apps5icg.ui.theme.ICGPurple
import com.example.apps5icg.ui.theme.ICGTurquoise

@Composable
fun PantallaMostrar(navController: NavHostController, mensaje: String) {

    FondoDePantalla{

        CardApp{

            CardContenidoApp {

                // Avatar (logo)
                AvatarApp(backgroundColor = ICGTurquoise, iconColor = Color.White)

                // Título
                TituloApp(color = ICGPurple)

                // Texto gigante del mensaje
                Text(
                    text = mensaje,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 50.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 1.sp,
                    modifier = Modifier.padding(16.dp)
                )

                Spacer(Modifier.height(40.dp))

                // Botón volver
                BotonPrimario(
                    text = "Volver a escribir",
                    onClick = { navController.navigate("escribir") }
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewPantallaMostrar() {
    AppS5ICGTheme {
        val navController = rememberNavController()
        PantallaMostrar(navController, mensaje = "Texto de prueba")
    }
}
