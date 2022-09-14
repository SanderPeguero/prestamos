package edu.ucne.prestamos.repository

import edu.ucne.prestamos.data.AppDatabase
import edu.ucne.prestamos.model.Ocupacion
import javax.inject.Inject

class OcupacionesRepository @Inject constructor(
    val db: AppDatabase
){
    suspend fun InsertarOcupacion(ocupacion: Ocupacion ){
        db.ocupacionDAO.InsertarOcupacion(ocupacion)
    }

    suspend fun ActualizarOcupacion(ocupacion: Ocupacion){
        db.ocupacionDAO.ActualizarOcupacion(ocupacion)
    }

    suspend fun BorrarOcupacion(ocupacion: Ocupacion){
        db.ocupacionDAO.BorrarOcupacion(ocupacion)
    }

    fun getOcupacion(id: Int) = db.ocupacionDAO.getOcupaciones(id)


    fun getAll() = db.ocupacionDAO.getAll()

}