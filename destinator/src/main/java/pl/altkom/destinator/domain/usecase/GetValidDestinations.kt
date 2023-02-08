package pl.altkom.destinator.domain.usecase

import pl.altkom.destinator.data.DestinationsStaticDataSource

class GetValidDestinations {

    operator fun invoke() = DestinationsStaticDataSource.destinations
}