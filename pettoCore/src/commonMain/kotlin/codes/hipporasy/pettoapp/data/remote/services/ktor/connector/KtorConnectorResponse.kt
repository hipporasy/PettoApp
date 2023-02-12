package codes.hipporasy.pettoapp.data.remote.services.ktor.connector

import codes.hipporasy.pettoapp.data.remote.services.ktor.connector.ConnectorResponse
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText

internal class KtorConnectorResponse(private val httpResponse: HttpResponse) : ConnectorResponse {
    override fun statusCode(): Int = httpResponse.status.value
    override suspend fun content(): String = httpResponse.bodyAsText()
}
