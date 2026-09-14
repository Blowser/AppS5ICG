package com.example.apps5icg.datos

import com.example.apps5icg.modelo.Usuario

val usuarios = mutableListOf(
    Usuario(
        nombre = "Pablo",
        rut = "12345678-9",
        correo = "pablo@gmail.com",
        telefono = "12345678",
        contrasenha = "123456"
    ),
    Usuario(
        nombre = "Luis",
        rut = "98765432-1",
        correo = "luis@gmail.com",
        telefono = "87654321",
        contrasenha = "abcdef"
    ),
    Usuario(
        nombre = "Pedro",
        rut = "11223344-5",
        correo = "pedro@gmail.com",
        telefono = "44556677",
        contrasenha = "qwerty"
    ),
    Usuario(
        nombre = "Nacho",
        rut = "20456789-3",
        correo = "ig.cortez@duocuc.cl",
        telefono = "99999999",
        contrasenha = "dosgatosnegros"
    )
)

const val MAX_USUARIOS = 5
