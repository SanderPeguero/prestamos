package edu.ucne.prestamos.ui.personas_List


import android.content.Context
import android.speech.tts.TextToSpeech
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ucne.prestamos.model.Persona
import edu.ucne.prestamos.repository.PersonasRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class personas_List(
    val personas: List<Persona> = emptyList()
)

@HiltViewModel
class personas_ListViewModel @Inject constructor(
    val repository: PersonasRepository
): ViewModel(){
    private val _uiState = MutableStateFlow(personas_List())
    val uiState: StateFlow<personas_List> = _uiState.asStateFlow()

    init{
        viewModelScope.launch {
            repository.getAll().collect { list ->
                _uiState.update {
                    it.copy( personas = list )
                }
            }
        }
    }

    fun borrarPersona(persona: Persona){
        viewModelScope.launch(
            Dispatchers.IO
        ){
            repository.BorrarPersona(persona)
        }
    }
}