package pl.altkom.destinator.data.responses

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import pl.altkom.destinator.domain.entity.Destination

data class DestinationDTO(
    val id: Long,
    val name: String,
    val description: String,
    val country: String
)

fun DestinationDTO.toDomain() =
    Destination(
        id = id,
        name = name,
        description = description
    )
