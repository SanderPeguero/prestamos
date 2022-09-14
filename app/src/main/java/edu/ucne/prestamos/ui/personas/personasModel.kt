package edu.ucne.prestamos.ui.personas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ucne.prestamos.model.Persona
import edu.ucne.prestamos.repository.PersonasRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class personasViewModel @Inject constructor(
    val repository: PersonasRepository
): ViewModel() {

    var nombres by mutableStateOf("")
    var telefono by mutableStateOf("")
    var celular by mutableStateOf("")
    var email by mutableStateOf("")
    var direccion by mutableStateOf("")
    var fechaNacimiento by mutableStateOf("")
    var ocupacionId by mutableStateOf(0)

    fun save(){
        viewModelScope.launch {
            repository.InsertarPersona(
                Persona(
                    nombres = nombres,
                    telefono = telefono.toDouble(),
                    celular = celular.toDouble(),
                    email = email,
                    direccion = direccion,
                    fechaNacimiento = fechaNacimiento,
                    ocupacionId =  ocupacionId
                )
            )
        }
    }

}