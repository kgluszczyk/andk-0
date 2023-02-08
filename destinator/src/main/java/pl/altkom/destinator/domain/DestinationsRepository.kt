package pl.altkom.destinator.domain

import kotlinx.coroutines.flow.Flow
import pl.altkom.destinator.domain.entity.Destination

interface DestinationsRepository {

    fun getDestinations(): Flow<List<Destination>>
}