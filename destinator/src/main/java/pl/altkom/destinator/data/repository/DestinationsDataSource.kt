package pl.altkom.destinator.data.repository

import kotlinx.coroutines.flow.Flow
import pl.altkom.destinator.domain.entity.Destination

interface DestinationsDataSource {

    fun getDestinations(): Flow<List<Destination>>
}