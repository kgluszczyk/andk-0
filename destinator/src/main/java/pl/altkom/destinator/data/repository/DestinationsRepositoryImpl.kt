package pl.altkom.destinator.data.repository

import pl.altkom.destinator.data.DestinationsStaticDataSource
import pl.altkom.destinator.data.datasource.DestinationsStaticDataSourceImpl
import pl.altkom.destinator.domain.DestinationsRepository

class DestinationsRepositoryImpl(private val destinationsStaticDataSource: DestinationsStaticDataSource) :
    DestinationsRepository {
    override fun getDestinations() = destinationsStaticDataSource.getDestinations()
}