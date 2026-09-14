package com.example.apps5icg


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.apps5icg.funciones.escribirymostrar.PantallaEscribir
import com.example.apps5icg.funciones.escribirymostrar.PantallaMostrar
import com.example.apps5icg.pantallas.home.PantallaHome
import com.example.apps5icg.pantallas.login.PantallaLogin
import com.example.apps5icg.pantallas.recuperar.PantallaRecuperar
import com.example.apps5icg.pantallas.registro.PantallaRegistro
import com.example.apps5icg.ui.theme.AppS5ICGTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppS5ICGTheme {
                AppNavegacion()
            }
        }
    }
}


@Composable
fun AppNavegacion() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") { PantallaLogin(navController) }
        composable("registro") { PantallaRegistro(navController) }
        composable("recuperar") { PantallaRecuperar(navController) }
        composable("home") {PantallaHome(navController)}
        composable("escribir") {PantallaEscribir(navController)}
        composable("mostrar?mensaje={mensaje}") { backStackEntry ->
            val mensaje = backStackEntry.arguments?.getString("mensaje") ?: ""
            PantallaMostrar(navController, mensaje)
        }






        /*
        composable("mostrar") { PMostrar(navController) }
        composable("escuchar") { PEscuchar(navController) }
        composable("tts") { TTS(navController) }*/


    }
}


