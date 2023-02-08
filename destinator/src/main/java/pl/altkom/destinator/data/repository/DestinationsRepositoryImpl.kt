package pl.altkom.destinator.data.repository

import pl.altkom.destinator.domain.DestinationsRepository

class DestinationsRepositoryImpl(private val destinationsStaticDataSource: DestinationsStaticDataSource) :
    DestinationsRepository {
    override fun getDestinations() = destinationsStaticDataSource.getDestinations()
}