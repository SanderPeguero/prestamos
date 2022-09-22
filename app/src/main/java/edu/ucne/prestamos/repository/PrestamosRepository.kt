package edu.ucne.prestamos.repository

import edu.ucne.prestamos.data.AppDatabase
import edu.ucne.prestamos.model.Prestamo
import javax.inject.Inject

class PrestamosRepository @Inject constructor(
    val db: AppDatabase
){
    suspend fun InsertarPrestamo(prestamo: Prestamo ){
        db.prestamoDAO.InsertarPrestamo(prestamo)
    }

    suspend fun ActualizarPrestamo(prestamo: Prestamo){
        db.prestamoDAO.ActualizarPrestamo(prestamo)
    }

    suspend fun BorrarPrestamo(prestamo: Prestamo){
        db.prestamoDAO.BorrarPrestamo(prestamo)
    }

    fun getPrestamo(id: Int) = db.prestamoDAO.getPrestamos(id)


    fun getAll() = db.prestamoDAO.getAll()

}