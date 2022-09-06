package edu.ucne.prestamos.data

import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomDatabase
import edu.ucne.prestamos.model.Ocupacion
import edu.ucne.prestamos.data.DAO.OcupacionesDAO

@Database(
    entities = [Ocupacion::class],
    version = 1
)

abstract class AppDatabase : RoomDatabase() {
    abstract val ocupacionDAO : OcupacionesDAO
}






