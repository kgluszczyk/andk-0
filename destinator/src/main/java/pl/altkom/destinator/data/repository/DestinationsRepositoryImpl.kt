package pl.altkom.destinator.data.repository

import pl.altkom.destinator.domain.DestinationsRepository

class DestinationsRepositoryImpl(private val destinationsDataSource: DestinationsDataSource) :
    DestinationsRepository {
    override fun getDestinations() = destinationsDataSource.getDestinations()
}