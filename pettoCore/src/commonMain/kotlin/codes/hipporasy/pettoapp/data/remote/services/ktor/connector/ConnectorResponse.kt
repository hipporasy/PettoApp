package codes.hipporasy.pettoapp.data.remote.services.ktor.connector

internal interface ConnectorResponse {
    fun statusCode(): Int
    suspend fun content(): String
}
