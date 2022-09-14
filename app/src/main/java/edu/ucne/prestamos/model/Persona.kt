package edu.ucne.prestamos.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Personas")
data class Persona(
    @PrimaryKey(autoGenerate = true)
    //OcupacionId
    val personaId: Int = 0,

    //Nombres
    val nombres: String = "",

    //Telefono
    val telefono: Double,

    //Celular
    val celular: Double,

    //Email
    val email: String = "",

    //Direccion
    val direccion: String = "",

    //FechaNacimiento
    val fechaNacimiento: String = "",

    //OcupacionId
    val ocupacionId: Int = 0

)