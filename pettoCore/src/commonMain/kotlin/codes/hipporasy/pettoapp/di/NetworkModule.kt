package codes.hipporasy.pettoapp.di

import codes.hipporasy.pettoapp.data.remote.services.ktor.connector.Connector
import codes.hipporasy.pettoapp.data.remote.services.ktor.connector.KtorConnector
import org.koin.dsl.module

internal val networkModule = module {
    single<Connector<*, *>> {
        KtorConnector(get())
    }
}
