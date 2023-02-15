package codes.hipporasy.pettoapp.di

import codes.hipporasy.pettoapp.common.globalJson
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual val httpClientModule: Module = module {
    single {
        HttpClient(OkHttp) {
            install(HttpTimeout)

            install(ContentNegotiation) {
                json(globalJson)
            }
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }
            expectSuccess = true
        }
    }
}
