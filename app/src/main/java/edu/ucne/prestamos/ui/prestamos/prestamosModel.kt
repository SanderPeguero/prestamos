package edu.ucne.prestamos.ui.prestamos

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ucne.prestamos.model.Prestamo
import edu.ucne.prestamos.repository.PrestamosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class prestamosViewModel @Inject constructor(
    val repository: PrestamosRepository
): ViewModel() {

    var fecha by mutableStateOf("")
    var vence by mutableStateOf("")
    var personaId by mutableStateOf("")
    var concepto by mutableStateOf("")
    var monto by mutableStateOf(0)
    var balance by mutableStateOf(0)

    fun save(){
        viewModelScope.launch {
            repository.InsertarPrestamo(
                Prestamo(
                    fecha = fecha,
                    vence = vence,
                    personaId = personaId.toInt(),
                    concepto = concepto,
                    monto = monto.toDouble(),
                    balance = balance.toDouble()
                )
            )
        }
    }

}