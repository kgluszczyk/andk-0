package pl.altkom.destinator.domain.usecase

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filter
import pl.altkom.destinator.domain.DestinationsRepository

class GetValidDestinations(private val destinationsRepository: DestinationsRepository) {
    operator fun invoke() = destinationsRepository
        .getDestinations()
        .filter {
            it.size > 2
        }
}