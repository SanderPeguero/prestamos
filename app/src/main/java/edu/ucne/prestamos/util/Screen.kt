package edu.ucne.prestamos.util

sealed class Screen(val route: String){
    object ocupaciones_ListScreen: Screen("OcupacionesList")
    object ocupacionesScreen: Screen("Ocupaciones")
    object personasScreen: Screen("Personas")
}