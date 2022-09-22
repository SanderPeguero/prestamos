package edu.ucne.prestamos.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Prestamos")
data class Prestamo(

    @PrimaryKey(autoGenerate = true)
    val prestamoId: Int = 0,

    val fecha: String = "",

    val vence: String = "",

    val personaId: Int = 0,

    val concepto: String = "",

    val monto: Double = 0.0,

    val balance: Double = 0.0,

)