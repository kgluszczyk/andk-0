package pl.altkom.destinator.presentation.viewmodel

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pl.altkom.destinator.domain.entity.Destination
import pl.altkom.destinator.domain.usecase.GetValidDestinations

class DestinationsViewModel(val getValidDestinations: GetValidDestinations) {

    private val _screenState = MutableStateFlow<ScreenState>(ScreenState.Loading)
    val screenState: StateFlow<ScreenState> = _screenState

    var userChoice = 0

    init {
        CoroutineScope(Dispatchers.Default).launch {
            getValidDestinations().collect { destinations ->
                _screenState.value = ScreenState.Content(
                    destinations = destinations,
                    overview = destinations.map { destination ->
                        destination.description
                    }.joinToString { overview -> overview.take(5) },
                    userChoice = userChoice
                )
            }
        }
    }
}

sealed class ScreenState {
    object Loading : ScreenState()

    data class Content(
        val destinations: List<Destination>,
        val overview: String,
        val userChoice: Int
    ) : ScreenState()

    data class Error(val exception: Exception) : ScreenState()
}