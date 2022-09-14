package edu.ucne.prestamos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import edu.ucne.prestamos.ui.theme.PrestamosTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.ucne.prestamos.ui.ocupaciones_List.ocupaciones_ListScreen
import edu.ucne.prestamos.ui.ocupaciones.ocupacionesScreen
import edu.ucne.prestamos.ui.personas.personasScreen
import edu.ucne.prestamos.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrestamosTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController( )
                    
                    NavHost(
                        navController = navController,
                        startDestination = Screen.personasScreen.route
                    ){
                        composable(Screen.ocupaciones_ListScreen.route){
                            ocupaciones_ListScreen(
                                onClick = { navController.navigate(Screen.ocupacionesScreen.route)}
                            )
                        }
                        composable(Screen.ocupacionesScreen.route){
                            ocupacionesScreen({ navController.navigateUp() })
                        }
                        composable(Screen.personasScreen.route){
                            personasScreen({ navController.navigateUp() })
                        }

                    }

                }
            }
        }
    }
}
