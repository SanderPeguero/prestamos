package edu.ucne.prestamos.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Ocupaciones")
data class Ocupacion(
    @PrimaryKey(autoGenerate = true)
    //OcupacionId
    val ocupacionId: Int = 0,

    //Descripcion
    val descripcion: String = "",

    //Salario
    val salario: Double
)