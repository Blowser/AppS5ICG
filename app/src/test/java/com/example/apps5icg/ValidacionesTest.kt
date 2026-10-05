package com.example.apps5icg

import org.junit.Assert.*
import org.junit.Test

class ValidacionesTest {

    @Test
    fun correoValido() {

        val correo = "shrek@gmail.com"

        assertTrue(
            correo.contains("@")
        )
    }

    @Test
    fun correoInvalido() {

        val correo = "shrekgmail.com"

        assertFalse(
            correo.contains("@")
        )
    }

    @Test
    fun passwordLarga() {

        val password = "cebollas123"

        assertTrue(
            password.length >= 8
        )
    }

    @Test
    fun passwordsCoinciden() {

        val password = "dosgatosnegros"
        val confirmacion = "dosgatosnegros"

        assertEquals(
            password,
            confirmacion
        )
    }
}