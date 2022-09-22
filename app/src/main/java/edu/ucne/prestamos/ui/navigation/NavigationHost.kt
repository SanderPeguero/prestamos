package edu.ucne.prestamos.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.ucne.prestamos.ui.navigation.Destinations.*
import edu.ucne.prestamos.ui.ocupaciones.ocupacionesScreen
import edu.ucne.prestamos.ui.ocupaciones_List.ocupaciones_ListScreen
import edu.ucne.prestamos.ui.personas.personasScreen
import edu.ucne.prestamos.ui.personas_List.personas_ListScreen
import edu.ucne.prestamos.ui.prestamos.prestamosScreen
//import edu.ucne.prestamos.ui.prestamos.prestamosScreen
import edu.ucne.prestamos.util.Screen

@Composable
fun NavigationHost(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = Ocupaciones.route
    ) {

        composable(Ocupaciones_List.route) {
            ocupaciones_ListScreen(
                onClick = { navController.navigate(Screen.ocupacionesScreen.route)}
            )
        }

        composable(Ocupaciones.route) {
            ocupacionesScreen({ navController.navigateUp() })
        }

        composable(Personas.route) {
            personasScreen({ navController.navigateUp() })
        }

        composable(Personas_List.route) {
            personas_ListScreen(
                onClick = { navController.navigate(Screen.personasScreen.route)}
            )
        }

        composable(Prestamos.route) {
            prestamosScreen({ navController.navigateUp() })
        }

//        composable(Prestamos_List.route) {
//            prestamos_ListScreen(
//                onClick = { navController.navigate(Screen.personasScreen.route)}
//            )
//        }

    }
}