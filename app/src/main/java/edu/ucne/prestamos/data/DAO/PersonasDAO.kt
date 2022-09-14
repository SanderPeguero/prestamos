package edu.ucne.prestamos.data.DAO


import androidx.lifecycle.LiveData
import androidx.room.*
import edu.ucne.prestamos.model.Persona
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonasDAO{
    @Insert
    suspend fun InsertarPersona(Persona: Persona)

    @Update
    suspend fun ActualizarPersona(Persona: Persona)

    @Delete
    suspend fun BorrarPersona(Persona: Persona)

    @Query("select * from Personas where personaId = :personaId ")
    fun getPersonas (personaId: Int): Flow<Persona>

    @Query("select * from Personas")
    fun getAll(): Flow<List<Persona>>


}