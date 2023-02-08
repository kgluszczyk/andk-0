package pl.altkom.destinator.data.datasource

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import pl.altkom.destinator.data.repository.DestinationsDataSource
import pl.altkom.destinator.data.responses.DestinationDTO
import pl.altkom.destinator.data.responses.toDomain
import pl.altkom.destinator.domain.entity.Destination
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

class DestinationsNetworkServiceDataSource : DestinationsDataSource {

    // TODO: inject
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://my-json-server.typicode.com/kgluszczyk/fake-server-destinator/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    // TODO: inject
    private val destinationsServer = retrofit.create(DestinationsService::class.java)

    private val data = MutableStateFlow(
        emptyList<Destination>()
    )

    override fun getDestinations() = data

    init {
        CoroutineScope(Dispatchers.IO).launch {
            data.value = destinationsServer.getDestinations().map {
                it.toDomain()
            }
        }
    }
}

interface DestinationsService {

    @GET("destinations")
    suspend fun getDestinations(): List<DestinationDTO>
}