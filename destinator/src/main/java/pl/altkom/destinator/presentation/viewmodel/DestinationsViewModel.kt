package pl.altkom.destinator.presentation.viewmodel

import pl.altkom.destinator.domain.entity.Destination
import pl.altkom.destinator.domain.usecase.GetValidDestinations

class DestinationsViewModel(val getValidDestinations: GetValidDestinations) {

    fun getDestinations(): List<Destination> = getValidDestinations()
    fun getDestinationsOverview() = getValidDestinations()
        .map {
            it.description
        }.joinToString { it }
}