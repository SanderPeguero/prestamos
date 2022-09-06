package edu.ucne.prestamos.ui.ocupaciones

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ucne.prestamos.model.Ocupacion
import edu.ucne.prestamos.repository.OcupacionesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ocupacionesViewModel @Inject constructor(
    val repository: OcupacionesRepository
): ViewModel() {

    var descripcion by mutableStateOf("")
    var salario by mutableStateOf("")

    fun save(){
        viewModelScope.launch {
            repository.InsertarOcupacion(
                Ocupacion(
                    descripcion = descripcion,
                    salario = salario.toDouble()
                )
            )
        }
    }

}