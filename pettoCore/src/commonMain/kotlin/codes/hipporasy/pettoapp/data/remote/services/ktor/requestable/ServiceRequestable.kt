package codes.hipporasy.pettoapp.data.remote.services.ktor.requestable

import codes.hipporasy.pettoapp.data.remote.services.ktor.connector.Connector
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

internal abstract class ServiceRequestable<TRequestable : Requestable>(val connector: Connector<*, *>) {

    suspend inline fun <reified T> execute(request: TRequestable): T {
        val httpResponse = connector.execute(request)
        return Json.decodeFromString(httpResponse.content())
    }
}
