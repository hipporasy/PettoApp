package codes.hipporasy.pettoapp.di

import codes.hipporasy.pettoapp.domain.repository.BaseRepository
import codes.hipporasy.pettoapp.domain.usecase.base.BaseUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

actual abstract class CoreModule : KoinComponent {

    open fun start(appDeclaration: KoinAppDeclaration) = startKoin {
        appDeclaration()
        modules(
            configModule(),
            networkModule,
            httpClientModule,
            repositoryModule,
            useCaseModule,
            preferenceModule,
            serviceModule
        )
    }

    private fun configModule(): Module {
        return module {
        }
    }

    inline fun <reified T : BaseUseCase<*, *>> providesUseCase(): T = get()
    inline fun <reified T : BaseRepository> providesRepository(): T = get()
}
