package edu.ucne.prestamos.ui.prestamos

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
import edu.ucne.prestamos.ui.prestamos.prestamosViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun prestamosScreen(
    onNavigateBack: () -> Unit,
    viewModel: prestamosViewModel = hiltViewModel()
){
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("Registro de Prestamos") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.save()
                onNavigateBack()
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add a Prestamos")
            }
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(8.dp)

        ) {
            //TextField Fecha
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Fecha") },
                value = viewModel.fecha ,
                onValueChange = { viewModel.fecha = it}
            )
            //TextField Vence
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Vence") },
                value = viewModel.vence ,
                onValueChange = { viewModel.vence = it}
            )
            //TextField PersonaId
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "PersonaId") },
                value = viewModel.personaId ,
                onValueChange = { viewModel.personaId = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            //TextField Concepto
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Concepto") },
                value = viewModel.concepto ,
                onValueChange = { viewModel.concepto = it}
            )
//            //TextField Monto
//            OutlinedTextField(
//                modifier = Modifier.fillMaxWidth(),
//                label = { Text(text = "Monto") },
//                value = viewModel.monto ,
//                onValueChange = { viewModel.monto = it},
//                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//            )
//            //TextField Balance
//            OutlinedTextField(
//                modifier = Modifier.fillMaxWidth(),
//                label = { Text(text = "Balance") },
//                value = viewModel.balance ,
//                onValueChange = { viewModel.balance = it},
//                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//            )
        }

    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview() {

}