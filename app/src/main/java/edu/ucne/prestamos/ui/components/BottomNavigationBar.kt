package edu.ucne.prestamos.ui.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import edu.ucne.prestamos.ui.navigation.Destinations
import edu.ucne.prestamos.ui.navigation.currentRoute
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    items: List<Destinations>
){
    val currentRoute = currentRoute(navController)

    BottomNavigation(
//        backgroundColor = Color(0.0f,0.8f,0.8f),
        backgroundColor = Color(0.153f, 0.153f, 0.153f, 1.0f),
        contentColor = Color.White
    ){
        items.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(imageVector = screen.icon, contentDescription = screen.title) },
                label = { Text(screen.title, fontSize = 8.sp) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                },
                alwaysShowLabel = false
            )
        }
    }
}