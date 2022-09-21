package edu.ucne.prestamos.ui.personas_List

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
import edu.ucne.prestamos.model.Persona
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun personas_ListScreen(
    onClick: () -> Unit,
    viewModel: personas_ListViewModel = hiltViewModel()
){
    Scaffold(

        topBar = {
            CenterAlignedTopAppBar(title = { Text("Lista de Personas") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onClick){
                Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar Persona")
            }
        }

    ) {
        val uiState by viewModel.uiState.collectAsState()
        
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
        ) {
            personas_List(
                personas = uiState.personas,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )
        }
    }
}

@Composable
fun personas_List(
    personas: List<Persona>,
    viewModel: personas_ListViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
){
    LazyColumn(modifier = modifier ){
        items(personas){
            persona -> personasRow(persona, viewModel)
        }
    }
}

@Composable
fun personasRow(persona: Persona, viewModel: personas_ListViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(
            text = persona.nombres,
            style = MaterialTheme.typography.titleLarge
        )


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Direccion: ${persona.direccion}"
            )

            IconButton(
                modifier = Modifier,
                onClick = { viewModel.borrarPersona(persona) }
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
//    val lista = listOf(
//        Ocupacion(
//            descripcion = "Ingeniero",
//            salario = 300000.00
//        ),
//        Ocupacion(
//            descripcion = "Piloto",
//            salario = 400000.00
//        )
//    )
    personas_List()
}