package codes.hipporasy.pettoapp

import codes.hipporasy.pettoapp.common.PreferenceManager
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object AppConfig : KoinComponent {
    val preferenceManager: PreferenceManager by inject()
}
