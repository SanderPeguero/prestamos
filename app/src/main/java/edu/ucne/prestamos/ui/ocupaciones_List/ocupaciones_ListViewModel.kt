package edu.ucne.prestamos.ui.ocupaciones_List


import android.content.Context
import android.speech.tts.TextToSpeech
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ucne.prestamos.model.Ocupacion
import edu.ucne.prestamos.repository.OcupacionesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ocupaciones_List(
    val ocupaciones: List<Ocupacion> = emptyList()
)

@HiltViewModel
class ocupaciones_ListViewModel @Inject constructor(
    val repository: OcupacionesRepository
): ViewModel(){
    private val _uiState = MutableStateFlow(ocupaciones_List())
    val uiState: StateFlow<ocupaciones_List> = _uiState.asStateFlow()

    init{
        viewModelScope.launch {
            repository.getAll().collect { list ->
                _uiState.update {
                    it.copy( ocupaciones = list )
                }
            }
        }
    }

    fun borrarOcupacion(ocupacion: Ocupacion){
        viewModelScope.launch(
            Dispatchers.IO
        ){
            repository.BorrarOcupacion(ocupacion)
        }
    }
}