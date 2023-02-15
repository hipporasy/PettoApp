package codes.hipporasy.pettoapp.di

import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.ObjCProtocol
import kotlinx.cinterop.getOriginalKotlinClass
import org.koin.core.component.KoinComponent
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

    fun <T> provides(cType: ObjCClass): T = getKoin().get(getOriginalKotlinClass(cType)!!)
    fun <T> provides(pType: ObjCProtocol): T = getKoin().get(getOriginalKotlinClass(pType)!!)
}
