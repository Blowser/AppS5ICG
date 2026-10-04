package com.example.apps5icg.data

import com.google.firebase.firestore.FirebaseFirestore

object UserRepository {

    // Conexión con Firestore
    private val db = FirebaseFirestore.getInstance()

    // Colección donde se guardarán los usuarios
    private const val USERS_COLLECTION = "usuarios"

    fun registerUser(
        nombre: String,
        rut: String,
        correo: String,
        telefono: String,
        contrasenha: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

        db.collection(USERS_COLLECTION)
            .whereEqualTo("correo", correo)
            .get()
            .addOnSuccessListener { result ->

                if (!result.isEmpty) {

                    onError("El correo electrónico ya está registrado")

                } else {

                    val newUser = User(
                        nombre = nombre,
                        rut = rut,
                        correo = correo,
                        telefono = telefono,
                        contrasenha = contrasenha
                    )

                    db.collection(USERS_COLLECTION)
                        .add(newUser)
                        .addOnSuccessListener {
                            onSuccess()
                        }
                        .addOnFailureListener { e ->
                            onError(
                                e.message
                                    ?: "Error al registrar usuario"
                            )
                        }
                }
            }
            .addOnFailureListener { e ->
                onError(
                    e.message
                        ?: "Error de conexión"
                )
            }
    }

    fun loginUser(
        correo: String,
        contrasenha: String,
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit
    ) {

        db.collection(USERS_COLLECTION)
            .whereEqualTo("correo", correo)
            .whereEqualTo("contrasenha", contrasenha)
            .get()
            .addOnSuccessListener { result ->

                if (result.isEmpty) {

                    onError("Credenciales incorrectas")

                } else {

                    val user =
                        result.documents.first()
                            .toObject(User::class.java)

                    onSuccess(
                        user?.nombre ?: ""
                    )
                }
            }
            .addOnFailureListener { e ->

                onError(
                    e.message
                        ?: "Error al conectarse al servidor"
                )
            }
    }
}