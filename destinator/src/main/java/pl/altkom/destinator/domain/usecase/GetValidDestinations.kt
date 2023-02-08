package pl.altkom.destinator.domain.usecase

import pl.altkom.destinator.domain.DestinationsRepository

class GetValidDestinations(private val destinationsRepository: DestinationsRepository) {

    operator fun invoke() = destinationsRepository
        .getDestinations()
        .filter {
            it.id > 0
        }
}