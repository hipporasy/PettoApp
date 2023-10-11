package codes.hipporasy.pettoapp.data.remote.services.api

import codes.hipporasy.pettoapp.data.remote.services.ktor.requestable.RequestMethod
import codes.hipporasy.pettoapp.data.remote.services.ktor.requestable.Requestable

internal sealed class AuthApi : Requestable {

    object GetProfile : AuthApi()

    object Logout : AuthApi()

    override val url: String
        get() = ""

    override val path: String
        get() = when (this) {
            is GetProfile -> "v2/profile"
            is Logout -> "v2/invalidate_refresh_token"
        }

    override val httpMethod: RequestMethod
        get() = when (this) {
            is GetProfile -> RequestMethod.GET
            else -> RequestMethod.POST
        }

    override val headers: HashMap<String, String>
        get() = super.headers

    override val parameter: Map<String, Any>?
        get() = null

    override val body: Any?
        get() = null
}
