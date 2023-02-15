package codes.hipporasy.pettoapp.di

import codes.hipporasy.pettoapp.domain.usecase.FetchPetUseCase
import org.koin.dsl.module

internal val useCaseModule = module {
    factory { FetchPetUseCase() }
}
