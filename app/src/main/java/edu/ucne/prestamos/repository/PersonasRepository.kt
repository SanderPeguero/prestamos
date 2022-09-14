package edu.ucne.prestamos.repository

import edu.ucne.prestamos.data.AppDatabase
import edu.ucne.prestamos.model.Persona
import javax.inject.Inject

class PersonasRepository @Inject constructor(
    val db: AppDatabase
){
    suspend fun InsertarPersona(persona: Persona ){
        db.personaDAO.InsertarPersona(persona)
    }

    suspend fun ActualizarOcupacion(persona: Persona){
        db.personaDAO.ActualizarPersona(persona)
    }

    suspend fun BorrarPersona(persona: Persona){
        db.personaDAO.BorrarPersona(persona)
    }

    fun getPersona(id: Int) = db.personaDAO.getPersonas(id)


    fun getAll() = db.personaDAO.getAll()

}