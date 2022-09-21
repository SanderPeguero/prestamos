package edu.ucne.prestamos.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.ucne.prestamos.ui.navigation.Destinations.*
import edu.ucne.prestamos.ui.ocupaciones_List.ocupaciones_ListScreen
import edu.ucne.prestamos.ui.personas.personasScreen
import edu.ucne.prestamos.ui.personas_List.personas_ListScreen
import edu.ucne.prestamos.util.Screen

@Composable
fun NavigationHost(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = Pantalla1.route
    ) {

        composable(Pantalla1.route) {
            ocupaciones_ListScreen(
                onClick = { navController.navigate(Screen.ocupacionesScreen.route)}
            )
        }

        composable(Pantalla2.route) {
            personas_ListScreen(
                onClick = { navController.navigate(Screen.personasScreen.route)}
            )
        }

        composable(Pantalla3.route) {
            personasScreen({ navController.navigateUp() })
        }
    }
}