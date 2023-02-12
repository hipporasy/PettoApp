package codes.hipporasy.pettoapp.data.remote.services

import codes.hipporasy.pettoapp.data.remote.services.api.AuthApi
import codes.hipporasy.pettoapp.data.remote.services.ktor.connector.Connector
import codes.hipporasy.pettoapp.data.remote.services.ktor.requestable.ServiceRequestable

internal class AuthService(connector: Connector<*, *>) : ServiceRequestable<AuthApi>(connector)