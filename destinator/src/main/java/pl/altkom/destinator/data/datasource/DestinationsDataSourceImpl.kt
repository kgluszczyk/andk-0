package pl.altkom.destinator.data.datasource

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import pl.altkom.destinator.data.repository.DestinationsDataSource
import pl.altkom.destinator.domain.entity.Destination

class DestinationsDataSourceImpl : DestinationsDataSource {
    private val default = listOf(
        Destination(id = 0, description = "Bardzo fajne", name = "Tajlandia"),
        Destination(id = 1, description = "Bardzo fajne1", name = "Tajlandia1"),
        Destination(id = 2, description = "Bardzo fajne2", name = "Tajlandia2"),
        Destination(id = 3, description = "Bardzo fajne3", name = "Tajlandia3")
    )
    private val data = MutableStateFlow(
        default
    )

    init {
        CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                data.value = default.shuffled()
                delay(1000L)
            }
        }
    }

    override fun getDestinations() = data
}