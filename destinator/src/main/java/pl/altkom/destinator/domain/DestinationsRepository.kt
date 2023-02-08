package pl.altkom.destinator.domain

import pl.altkom.destinator.domain.entity.Destination

interface DestinationsRepository {

    fun getDestinations(): List<Destination>
}