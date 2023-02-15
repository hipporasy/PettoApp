package codes.hipporasy.pettoapp.di

import codes.hipporasy.pettoapp.common.globalJson
import io.ktor.client.*
import io.ktor.client.engine.darwin.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual val httpClientModule: Module = module {
    single {
        HttpClient(Darwin) {
            install(HttpTimeout)

            install(ContentNegotiation) {
                json(globalJson)
            }
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }

            engine {
                configureRequest {
                    setAllowsCellularAccess(true)
                }
            }

            expectSuccess = true
        }
    }
}

