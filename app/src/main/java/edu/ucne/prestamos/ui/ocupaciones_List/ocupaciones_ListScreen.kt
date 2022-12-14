package edu.ucne.prestamos.ui.ocupaciones_List

import android.content.Context
import android.content.Intent
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.prestamos.model.Ocupacion
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ocupaciones_ListScreen(
    onClick: () -> Unit,
    viewModel: ocupaciones_ListViewModel = hiltViewModel()
){
    Scaffold(

        topBar = {
            CenterAlignedTopAppBar(title = { Text("Lista de Ocupaciones") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onClick){
                Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar Ocupacion")
            }
        }

    ) {
        val uiState by viewModel.uiState.collectAsState()
        
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
        ) {
            ocupaciones_List(
                ocupaciones = uiState.ocupaciones,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )
        }
    }
}

@Composable
fun ocupaciones_List(
    ocupaciones: List<Ocupacion>,
    viewModel: ocupaciones_ListViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
){
    LazyColumn(modifier = modifier ){
        items(ocupaciones){
            ocupacion -> ocupacionesRow(ocupacion, viewModel)
        }
    }
}

@Composable
fun ocupacionesRow(ocupacion: Ocupacion, viewModel: ocupaciones_ListViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(
            text = ocupacion.descripcion,
            style = MaterialTheme.typography.titleLarge
        )


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Salario: ${ocupacion.salario}"
            )

            IconButton(
                modifier = Modifier,
                onClick = { viewModel.borrarOcupacion(ocupacion) }
            ) {
                Icon(imageVector = Icons.Outlined.Delete, contentDescription = "Delete", tint = Color.Black )
            }

        }


        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            color = Color.LightGray
        )
    }


}

@Composable
@Preview(showSystemUi = true)
fun Preview() {
    val lista = listOf(
        Ocupacion(
            descripcion = "Ingeniero",
            salario = 300000.00
        ),
        Ocupacion(
            descripcion = "Piloto",
            salario = 400000.00
        )
    )
    ocupaciones_List(ocupaciones = lista)
}