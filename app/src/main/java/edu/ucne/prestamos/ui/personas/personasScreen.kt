package edu.ucne.prestamos.ui.personas

import android.widget.DatePicker
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun personasScreen(
    onNavigateBack: () -> Unit,
    viewModel: personasViewModel = hiltViewModel()
){
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("Registro de Personas") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.save()
                onNavigateBack()
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add a Ocupacion")
            }
        }
    ) {
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(8.dp)

        ) {
            //TextField Nombres
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Nombres") },
                value = viewModel.nombres ,
                onValueChange = { viewModel.nombres = it}
            )
            //TextField Telefono
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Telefono") },
                value = viewModel.telefono ,
                onValueChange = { viewModel.telefono = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            //TextField Celular
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Celular") },
                value = viewModel.celular ,
                onValueChange = { viewModel.celular = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            //TextField Email
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Email") },
                value = viewModel.email ,
                onValueChange = { viewModel.email = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            //TextField Direccion
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Direccion") },
                value = viewModel.direccion ,
                onValueChange = { viewModel.direccion = it}
            )
            //TextField FechaNacimiento
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Fecha de Nacimiento") },
                value = viewModel.fechaNacimiento ,
                onValueChange = { viewModel.fechaNacimiento = it}

            )
        }
        
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview() {

}