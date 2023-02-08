package pl.altkom.destinator.data

import pl.altkom.destinator.domain.entity.Destination

interface DestinationsStaticDataSource {

    fun getDestinations(): List<Destination>
}