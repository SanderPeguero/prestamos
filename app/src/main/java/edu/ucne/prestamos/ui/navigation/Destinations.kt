package edu.ucne.prestamos.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Ocupaciones: Destinations("Ocupaciones","Ocupaciones", Icons.Filled.Check)
    object Personas: Destinations("Personas", "Personas", Icons.Filled.Person)
    object Prestamos: Destinations("Prestamos","Prestamos", Icons.Filled.List)
    object Ocupaciones_List: Destinations("Ocupaciones_List","Ocupacioes List", Icons.Filled.Info)
    object Personas_List: Destinations("Personas_List","Personas List", Icons.Filled.Info)
//    object Prestamos_List: Destinations("Prestamos_List","Prestamos_List", Icons.Filled.List)
}