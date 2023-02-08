package pl.altkom.destinator.data.repository

import pl.altkom.destinator.domain.entity.Destination

interface DestinationsStaticDataSource {

    fun getDestinations(): List<Destination>
}