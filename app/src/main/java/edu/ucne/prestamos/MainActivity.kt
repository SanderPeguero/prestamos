package edu.ucne.prestamos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import edu.ucne.prestamos.ui.theme.PrestamosTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.ucne.prestamos.ui.ocupaciones_List.ocupaciones_ListScreen
import edu.ucne.prestamos.ui.personas_List.personas_ListScreen
import edu.ucne.prestamos.ui.ocupaciones.ocupacionesScreen
import edu.ucne.prestamos.ui.personas.personasScreen
import edu.ucne.prestamos.ui.navigation.Destinations.*
import edu.ucne.prestamos.ui.navigation.NavigationHost
import edu.ucne.prestamos.ui.components.BottomNavigationBar
import edu.ucne.prestamos.ui.components.Drawer
import edu.ucne.prestamos.ui.components.TopBar

import edu.ucne.prestamos.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
//            PrestamosTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    val navController = rememberNavController( )
//
//                    NavHost(
//                        navController = navController,
//                        startDestination = Screen.personas_ListScreen.route
//                    ){
//                        composable(Screen.ocupaciones_ListScreen.route){
//                            ocupaciones_ListScreen(
//                                onClick = { navController.navigate(Screen.ocupacionesScreen.route)}
//                            )
//                        }
//                        composable(Screen.ocupacionesScreen.route){
//                            ocupacionesScreen({ navController.navigateUp() })
//                        }
//                        composable(Screen.personasScreen.route){
//                            personasScreen({ navController.navigateUp() })
//                        }
//                        composable(Screen.personas_ListScreen.route){
//                            personas_ListScreen(
//                                onClick = { navController.navigate(Screen.personasScreen.route)}
//                            )
//                        }
//
//                    }
//
//                }
//            }
        }
    }
}

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState(
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    )
    val scope = rememberCoroutineScope()

    val navigationItems = listOf(
        Pantalla1,
        Pantalla2,
        Pantalla3
    )

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = { BottomNavigationBar(navController = navController, items = navigationItems) },
        floatingActionButton = { FloatingActionButton(onClick = {}) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Fab Icon")
        } },
        isFloatingActionButtonDocked = false,
        floatingActionButtonPosition = FabPosition.End,
        topBar = { TopBar( scope, scaffoldState ) },
        drawerContent = { Drawer(scope, scaffoldState, navController, items = navigationItems) },
        drawerGesturesEnabled = true

    ) {
        NavigationHost(navController)
    }

}
