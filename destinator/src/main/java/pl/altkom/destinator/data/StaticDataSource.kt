package pl.altkom.destinator.data

import pl.altkom.destinator.domain.entity.Destination

object StaticDataSource {

    val destinations = listOf<Destination>(
        Destination(id = 0,  description = "Bardzo fajne", name = "Tajlandia"),
        Destination(id = 1,  description = "Bardzo fajne1", name = "Tajlandia1"),
        Destination(id = 2,  description = "Bardzo fajne2", name = "Tajlandia2"),
        Destination(id = 3,  description = "Bardzo fajne3", name = "Tajlandia3")
    )
}