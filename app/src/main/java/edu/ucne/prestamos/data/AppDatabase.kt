package edu.ucne.prestamos.data

import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomDatabase
import edu.ucne.prestamos.model.Ocupacion
import edu.ucne.prestamos.model.Persona
import edu.ucne.prestamos.model.Prestamo
import edu.ucne.prestamos.data.DAO.OcupacionesDAO
import edu.ucne.prestamos.data.DAO.PersonasDAO
import edu.ucne.prestamos.data.DAO.PrestamosDAO

@Database(
    entities = [Ocupacion::class, Persona::class, Prestamo::class],
    version = 3
)

abstract class AppDatabase : RoomDatabase() {
    abstract val ocupacionDAO : OcupacionesDAO
    abstract val personaDAO : PersonasDAO
    abstract val prestamoDAO: PrestamosDAO

}






