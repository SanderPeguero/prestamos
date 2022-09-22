package edu.ucne.prestamos.ui.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import edu.ucne.prestamos.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TopBar(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState
){
    TopAppBar(
        title = { Text(LocalContext.current.getString(R.string.app_name)) },
        backgroundColor = Color(0.153f, 0.153f, 0.153f, 1.0f),
        contentColor = Color(1.0f, 1.0f, 1.0f, 1.0f),
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu Icon")
            }
        },
        actions = {
//            IconButton(onClick = {
//                //TODO: Display Snackbar
//            }) {
//                Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
//            }
//            IconButton(onClick = {
//                //TODO: Display Dialog
//            }) {
//                Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
//            }
        }
    )
}