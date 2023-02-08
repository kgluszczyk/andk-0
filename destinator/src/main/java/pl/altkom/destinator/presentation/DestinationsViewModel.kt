package pl.altkom.destinator.presentation

import pl.altkom.destinator.data.DestinationsStaticDataSource
import pl.altkom.destinator.domain.entity.Destination
import pl.altkom.destinator.domain.usecase.GetValidDestinations

class DestinationsViewModel(val getValidDestinations: GetValidDestinations) {

    fun getDestinations(): List<Destination> = getValidDestinations()
    fun getDestinationsOverview() = getValidDestinations()
        .filter { it.id > 0 }
        .map {
            it.description
        }.joinToString { it }
}