package edu.ucne.prestamos.data.DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import edu.ucne.prestamos.model.Prestamo
import kotlinx.coroutines.flow.Flow

@Dao
interface PrestamosDAO{
    @Insert
    suspend fun InsertarPrestamo(Prestamo: Prestamo)

    @Update
    suspend fun ActualizarPrestamo(Prestamo: Prestamo)

    @Delete
    suspend fun BorrarPrestamo(Prestamo: Prestamo)

    @Query("select * from Prestamos where prestamoId = :prestamoId ")
    fun getPrestamos(prestamoId: Int): Flow<Prestamo>

    @Query("select * from Prestamos")
    fun getAll(): Flow<List<Prestamo>>


}