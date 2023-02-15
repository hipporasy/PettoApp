package codes.hipporasy.pettoapp.di

import codes.hipporasy.pettoapp.common.PreferenceManager
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual val preferenceModule: Module = module {
    single {
        PreferenceManager(get())
    }
}
