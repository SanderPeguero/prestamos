package edu.ucne.prestamos.ui.ocupaciones

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
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
fun ocupacionesScreen(
    onNavigateBack: () -> Unit,
    viewModel: ocupacionesViewModel = hiltViewModel()
){
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("Entrada de Ocupacion") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.save()
                onNavigateBack()
            }) {
                Icon(imageVector = Icons.Default.Create, contentDescription = "Add a Ocupacion")
            }
        }
    ) {
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(8.dp)

        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Descripcion") },
                value = viewModel.descripcion ,
                onValueChange = { viewModel.descripcion = it}
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Salario") },
                value = viewModel.salario ,
                onValueChange = { viewModel.salario = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
        
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview() {
    ocupacionesScreen({ })
}