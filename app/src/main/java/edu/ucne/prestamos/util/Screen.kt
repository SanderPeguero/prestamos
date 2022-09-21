package edu.ucne.prestamos.util

sealed class Screen(val route: String){
    object ocupacionesScreen: Screen("Ocupaciones")
    object personasScreen: Screen("Personas")
    object ocupaciones_ListScreen: Screen("OcupacionesList")
    object personas_ListScreen: Screen("PersonasList")
}