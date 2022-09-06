package edu.ucne.prestamos.data.DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import edu.ucne.prestamos.model.Ocupacion
import kotlinx.coroutines.flow.Flow

@Dao
interface OcupacionesDAO{
    @Insert
    suspend fun InsertarOcupacion(Ocupacion: Ocupacion)

    @Update
    suspend fun ActualizarOcupacion(Ocupacion: Ocupacion)

    @Delete
    suspend fun BorrarOcupacion(Ocupacion: Ocupacion)

    @Query("select * from Ocupaciones where ocupacionId = :ocupacionId ")
    fun getOcupaciones (ocupacionId: Int): Flow<Ocupacion>

    @Query("select * from Ocupaciones")
    fun getAll(): Flow<List<Ocupacion>>


}